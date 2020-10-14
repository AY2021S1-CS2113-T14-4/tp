package seedu.duke.database;


import seedu.duke.food.Food;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataBase {
    private static final String START_SYMBOL = "&%START";
    private static final String STOP_SYMBOL = "&%STOP";
    private static final String UP_SYMBOL = "&%UP";

    private static final String DATA_FILE_SEPERATOR = "\\|";

    private static final String rootDirectory = System.getProperty("user.dir");
    private static final String dataFileFolder = "src" + File.separator + "main" + File.separator
            + "java" + File.separator + "seedu" + File.separator + "duke" + File.separator + "database";

    private final List<Canteen> canteenList;

    public DataBase() {
        this.canteenList = new ArrayList<>();
    }

    /**
     * Reads a file from the data base and puts it into the DataBase object.
     */
    public void init() throws FileNotFoundException {
        String fileFolder = rootDirectory + File.separator + dataFileFolder;
        File dataFile = new File(fileFolder + File.separator + "data.txt");
        Scanner fileReader = new Scanner(dataFile);
        String fileLine;
        boolean start = false;
        while (fileReader.hasNext()) {
            fileLine = fileReader.nextLine();
            // ------ Check if the data base has started scanning ------
            if (fileLine.equals(START_SYMBOL)) {
                start = true;
                continue;
            }
            if (!(start)) {
                continue;
            }
            if (fileLine.equals(STOP_SYMBOL)) {
                break;
            }
            canteenList.add(fillCanteen(fileLine, fileReader));
        }
    }

    /**
     * This function is called right after the canteen name is provided
     * The very next line that the file reads is the store name
     * It will turn call fillStore with that name inserted, when the function fillStore
     * finishes executing, fileRead.nextLine() can either provide a new store name or UP_SYMBOL
     * if the UP_SYMBOL is provided, the function ends and the final Canteen object is returned.
     *
     * @param name name of store
     * @param fileSegment the file reader with the next line being a food item or UP_SYMBOL
     * @return Canteen objected with all it's stores loaded
     */
    private Canteen fillCanteen(String name, Scanner fileSegment) {
        Canteen canteen = new Canteen(name);
        String fileLine = fileSegment.nextLine();
        while (!(fileLine.equals(UP_SYMBOL))) {
            canteen.addStore(fillStore(fileLine,fileSegment));
            fileLine = fileSegment.nextLine();
        }
        return canteen;
    }

    /**
     * This function is called right after the store name is provided.
     * The very next line in the file should be the first food to be added.
     * The function stops when it hits the line of the file that says UP_SYMBOL.
     *
     * @param name name of the store
     * @param fileSegment the Scanner object used for the init() function
     * @return the completed store with all the food loaded
     */
    private Store fillStore(String name, Scanner fileSegment) {
        Store store = new Store(name);
        Food food;
        String fileLine = fileSegment.nextLine();
        String[] fileData = fileLine.split(DATA_FILE_SEPERATOR);
        while (!(fileLine.equals(UP_SYMBOL))) {
            food = new Food(fileData[0], Integer.parseInt(fileData[1]),Integer.parseInt(fileData[2]),
            Integer.parseInt(fileData[3]),Integer.parseInt(fileData[4]));
            store.addFood(food);
            fileLine = fileSegment.nextLine();
            fileData = fileLine.split(DATA_FILE_SEPERATOR);
        }
        return store;
    }

    /**
     * Debugging function prints out all contents.
     */
    public void printAllData() {
        System.out.println("Printing out all data");
        for (Canteen canteen : canteenList) {
            System.out.println("Canteeh : " + canteen.getName());
            for (Store store : canteen.getStoreList()) {
                System.out.println("Store : " + store.getName());
                for (Food food : store.getFoodList()) {
                    System.out.println(food);
                }
            }
        }
        System.out.println("Finished Printing out all data");
    }

    // -------- Search functions --------

    /**
     * This method searchs the whole data base and returns the first food item whose name contains the provided string.
     * ( CASE SENSITIVE ! )
     *
     * @param food part of the name of the food
     * @return Food
     * @throws NoSuchElementException if no food contains the name provided
     */
    public Food searchFoodByName(String food) {
        return foodStream().filter(x -> x.getName().contains(food)).findFirst().orElseThrow();
    }

    /**
     * This method searchs the whole data base and returns all of the food whose name contains the provided string.
     * @param food part of the name of the food e.g. chicken
     * @return data stream of all food items
     */
    public Stream<Food> searchAllFoodContainingName(String food) {
        return foodStream().filter(x -> x.getName().contains(food));
    }

    /**
     * Search for the first food that contains the string provided in the first store which matchs the store
     * string provided.
     *
     * @param food partial name of the food
     * @param store partial name of the store
     * @return Food object
     * @throws NoSuchElementException if no food contains the name provided
     */
    public Food searchFoodByNameByStore(String food, String store) {
        return searchAllFoodByStore(store)
                .filter(x -> x.getName().contains(food))
                .findFirst()
                .orElseThrow();
    }

    /**
     * Returns a stream of all the food in the first store that contains the given string.
     *
     * @param store partial name of the store
     * @return food stream
     * @throws NoSuchElementException if no there is no store
     */
    public Stream<Food> searchAllFoodByStore(String store) {
        return canteenList.stream()
                .flatMap(x -> x.getStoreList().stream())
                .filter(x -> x.getName().contains(store))
                .findFirst()
                .orElseThrow()
                .getFoodList()
                .stream();
    }

    /**
     * Returns a stream of all the food in all stores that contains the given string.
     *
     * @param store partial name of the store
     * @return  food stream
     */
    public Stream<Food> searchAllFoodOfAllStores(String store) {
        return canteenList.stream()
                .flatMap(x -> x.getStoreList().stream())
                .filter(x -> x.getName().contains(store))
                .flatMap(x -> x.getFoodList().stream());
    }


    /**
     * Returns the first food that contains the food String provided that is in the first canteen that contains the
     * canteen String provided.
     *
     * @param food partial name of the food
     * @param canteen partial name of the canteen
     * @return Food object
     *
     * @throws NoSuchElementException if no food contains the name provided
     */
    public Food searchFoodByNameByCanteen(String food, String canteen) {
        return searchAllFoodByNameByCanteen(food, canteen)
                .findFirst()
                .orElseThrow();
    }

    /**
     * Returns all food that contains the provided food name in the first canteen that matchs the canteen name.
     *
     * @param food partial name of the food
     * @param canteen partial name of the canteen
     * @return Food Stream
     */
    public Stream<Food> searchAllFoodByNameByCanteen(String food, String canteen) {
        return canteenList.stream()
                .filter(x -> x.getName().contains(canteen))
                .findFirst()
                .orElseThrow()
                .getStoreList()
                .stream()
                .flatMap(x -> x.getFoodList().stream())
                .filter(x -> x.getName().contains(food));
    }

    /**
     * Returns a stream of food whose calorie is below the provided amount.
     *
     * @param calorie the maximum calorie of the food
     * @return food stream
     */
    public Stream<Food> searchAllFoodBelowCalorie(int calorie) {
        return foodStream().filter(x -> x.getCalorie() < calorie);
    }

    /**
     * Returns all food within the calorie range.
     *
     * @param minCalorie minimum calories
     * @param maxCalorie maxinum calories
     * @return food stream
     */
    public Stream<Food> searchAllFoodInCalorieRange(int minCalorie, int maxCalorie) {
        return foodStream().filter(x -> x.getCalorie() <= maxCalorie && x.getCalorie() >= minCalorie);
    }

    /**
     * Provides a data stream of all the food in the data base.
     *
     * @return a food stream
     */
    public Stream<Food> foodStream() {
        return canteenList.stream()
                .flatMap(x -> x.getStoreList().stream())
                .flatMap(x -> x.getFoodList().stream());
    }

    public List<Food> getFoodList() {
        return foodStream().collect(Collectors.toList());
    }
}
