package seedu.duke.food;

import seedu.duke.food.Food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FoodTest {
    private Food testFood;

    @BeforeEach
    public void setUp() {
        testFood = new Food("Kobe Beef", 480,50,40,30);
    }

    @Test
    public void footTest() {
        assertEquals(480, testFood.getCalorie());
        assertEquals(50, testFood.getCarbohydrate());
        assertEquals(40, testFood.getProtein());
        assertEquals(30, testFood.getFats());
    }
}