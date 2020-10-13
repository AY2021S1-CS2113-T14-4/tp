package seedu.calculator;

import org.junit.jupiter.api.Test;
import seedu.duke.food.Food;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {



    @Test
    void calculateCalorie_foodListOfThreeItems_sumOfCalorie() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("chicken rice", 666, 55, 30, 0));
        foodList.add(new Food("pancake", 150, 16, 0, 0));
        foodList.add(new Food("bao", 290, 0, 16, 0));
        Calculator calculator = new Calculator(foodList);
        assertEquals(666 + 150 + 290, calculator.calculateCalorie());
    }

    @Test
    void calculateCarbs_foodListOfThreeItems_sumOfCarbs() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("chicken rice", 666, 55, 30, 0));
        foodList.add(new Food("pancake", 150, 16, 0, 0));
        foodList.add(new Food("bao", 290, 0, 16, 0));
        Calculator calculator = new Calculator(foodList);
        assertEquals(55 + 16, calculator.calculateCarb());
    }

    @Test
    void calculateProtein_foodListOfThreeItems_sumOfProtein() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("chicken rice", 666, 55, 30, 0));
        foodList.add(new Food("pancake", 150, 16, 0, 0));
        foodList.add(new Food("bao", 290, 0, 16, 0));
        Calculator calculator = new Calculator(foodList);
        assertEquals(30 + 16, calculator.calculateProtein());
    }

    @Test
    void calculateFats_foodListOfThreeItems_sumOfFats() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("chicken rice", 666, 55, 30, 0));
        foodList.add(new Food("pancake", 150, 16, 0, 0));
        foodList.add(new Food("bao", 290, 0, 16, 0));
        Calculator calculator = new Calculator(foodList);
        assertEquals(0, calculator.calculateFat());
    }
}
