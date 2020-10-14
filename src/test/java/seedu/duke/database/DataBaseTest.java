package seedu.duke.database;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


class DataBaseTest {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        try {
            database.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // ----- Print everything in the data base -----
        database.printAllData();

        // ---- Using stream version to print -----
        System.out.println("------------ printing using food stream ------------");
        database.foodStream().forEach(System.out::println);

        // ---- Printing out as list -----
        System.out.println("---------- printing food using list --------------");
        database.getFoodList().forEach(System.out::println);

        // ---- search food by name test -----
        try {
            System.out.println("------- testing the searchFoodByName function -------");
            System.out.println("Input: Prawn  ## OutPut: " + database.searchFoodByName("Prawn"));
            System.out.println("Input: Mee ## OutPut: " + database.searchFoodByName("Mee"));
            System.out.println("Input: lobster ## OutPut: " + database.searchFoodByName("lobster"));
            System.out.println("Input: Prawn ## OutPut: " + database.searchFoodByName("koala bears"));
        } catch (NoSuchElementException e) {
            System.out.println("No such food found! " + e);
        }

        // ---- search food by store name test ----
        System.out.println("------- testing the search food by store and by name function --------");
        try {
            System.out.println("Input: Fried , Halal Mini Wok ## OutPut: "
                    + database.searchFoodByNameByStore("Fried", "Halal Mini Wok"));
            System.out.println("Input: Chicken , Halal Mini Wok ## OutPut: "
                    + database.searchFoodByNameByStore("Chicken", "Halal Mini Wok"));
            System.out.println("Input: Chicken , Ayam Penyet ## OutPut: "
                    + database.searchFoodByNameByStore("Chicken", "Ayam Penyet"));
            System.out.println("Input: lobster , Michelin ## OutPut: "
                    + database.searchFoodByNameByStore("lobster", "Michelin"));
            System.out.println("Input: fish , Halal Mini Wok ## OutPut: "
                    + database.searchFoodByNameByStore("fish", "Halal Mini Wok"));
        } catch (NoSuchElementException e) {
            System.out.println("No such food found! " + e);
        }

        // ---- search all food by store -----
        try {
            System.out.println("------- testing the search ALL food by store and by name function --------");
            System.out.println("------- Input: Halal Mini Wok -------- ");
            database.searchAllFoodByStore("Halal Mini Wok").forEach(System.out::println);
            System.out.println("------- Input: Ayam Penyet -------- ");
            database.searchAllFoodByStore("Ayam Penyet").forEach(System.out::println);
            System.out.println("------- Input: Michelin -------- ");
            database.searchAllFoodByStore("Michelin").forEach(System.out::println);
            System.out.println("------- Input: Gordan Ramsey's restaurant -------- ");
            database.searchAllFoodByStore("Gordon Ramsey's restaurant").forEach(System.out::println);
        } catch (NoSuchElementException e) {
            System.out.println("There is no such store! " + e);
        }

        // ---- search food by Name by canteen ------
        try {
            System.out.println("------- testing the search food by canteen and by name function --------");
            System.out.println("Input: Fried , Science ## OutPut: "
                    + database.searchFoodByNameByCanteen("Fried", "Science"));
            System.out.println("Input: Chicken , Science ## OutPut: "
                    + database.searchFoodByNameByCanteen("Chicken", "Science"));
            System.out.println("Input: lobster , Science ## OutPut: "
                    + database.searchFoodByNameByCanteen("lobster", "Science"));
            System.out.println("Input: lobster , Raffles Hotel Suite ## OutPut: "
                    + database.searchFoodByNameByCanteen("lobster", "Raffles Hotel Suite"));
        } catch (NoSuchElementException e) {
            System.out.println("There is either no such canteen or no such food in that canteen!" + e);
        }

        // ---- search all food below calorie ------

        System.out.println("------- testing the search food below calorie function --------");
        System.out.println(" ---- Input : 400");
        database.searchAllFoodBelowCalorie(400).forEach(System.out::println);
        System.out.println(" ---- Input : 200");
        database.searchAllFoodBelowCalorie(200).forEach(System.out::println);
        System.out.println(" ---- Input : 3428");
        database.searchAllFoodBelowCalorie(3428).forEach(System.out::println);

    }
}