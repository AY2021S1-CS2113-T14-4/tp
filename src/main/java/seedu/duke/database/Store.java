package seedu.duke.database;

import seedu.duke.food.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private final String name;
    private final ArrayList<Food> foodList;


    public Store(String name) {
        this.name = name;
        this.foodList = new ArrayList<>();
    }

    /**
     * The name of the store will be used for filtering purposes.
     *
     * @return store name
     */

    public String getName() {
        return name;
    }

    /**
     * This function should only be called when we initialize the data base from the text file.
     */
    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

}
