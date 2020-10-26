package seedu.dietbook.checker;

import seedu.dietbook.exception.DietException;

/**
 * InputChecker class of the program.
 * This class checks the validity of the user input and throws an exception if input is not as intended/expected.
 *
 * @author tikimonarch
 */

public class InputChecker {
    /**
     * The value limits are based on current limits observed in th world.
     */
    public static final int AGE_CAP = 150;
    public static final int FOOD_CAP = 100000;
    public static final int HEIGHT_CAP = 300;
    public static final int WEIGHT_CAP = 500;
    public static final String[] PARAM_ACTIVITY = {"1","2","3","4","5"};
    public static final String[] PARAM_ADD = {"n/","x/","k/"};
    public static final String[] PARAM_CALCULATE = {"fat", "carbohydrate","protein", "calorie", "all"};
    public static final String[] PARAM_GENDER = {"M","F","O"};
    public static final String[] PARAM_INFO = {"g/","a/","h/","l/","o/","t/"};

    /**
     * Takes in user input and command to check for any expected parameters after the command.
     *
     * @param userInput user input.
     * @param command command in user input.
     * @throws DietException when at least one parameter is expected but not present.
     */
    public static void checkEmpty(String userInput, String command) throws DietException {
        if (userInput.split(command).length < 2
                || userInput.split(command)[1].equals(" ")) {
            throw new DietException("Error! Missing command parameters!");
        }
    }

    /**
     * Takes in processed user input to check for options specified with an empty field.
     *
     * @param input user input.
     * @throws DietException when an option is specified but its field is empty.
     */
    public static void checkEmptyOption(String[] input) throws DietException {
        try {
            if (input[1].charAt(0) == ' ') {
                throw new DietException("Error! Option specified with empty field!");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DietException("Error! Option specified with empty field!");
        }
    }

    /**
     * Takes in user input to check if the expected number and type of parameter for the add command is present.
     *
     * @param userInput user input.
     * @throws DietException when expected parameters are missing.
     */
    public static void checkAddParam(String userInput) throws DietException {
        for (String param: PARAM_ADD) {
            if (!userInput.contains(param)) {
                throw new DietException("Missing or incorrect add statement");
            }
        }
    }

    /**
     * Takes in user input to check if the expected number and type of parameter for the info command is present.
     *
     * @param userInput user input.
     * @throws DietException when expected parameters are missing.
     */
    public static void checkInfoParam(String userInput) throws DietException {
        for (String param: PARAM_INFO) {
            if (!userInput.contains(param)) {
                throw new DietException("Missing or incorrect info statement");
            }
        }
    }

    /**
     * Takes in an integer from food to check if the value is within the logical limit.
     *
     * @param foodValue integer value of attributes.
     * @throws DietException when value is not within the limit.
     */
    public static void checkFoodLimit(int foodValue) throws DietException {
        if (foodValue < 0) {
            throw new DietException("Input value cannot be less than 0!");
        } else if (foodValue > FOOD_CAP) {
            throw new DietException("Input value cannot be more than 100,000!");
        }
    }

    /**
     * Takes in user input to check if the nutrient type is of the expected input.
     *
     * @param userInput user input.
     * @throws DietException when it is not one of the expected nutrient type.
     */
    public static void checkNutrientType(String userInput) throws DietException {
        boolean checkContain = false;
        for (String param: PARAM_CALCULATE) {
            if (userInput.contains(param)) {
                checkContain = true;
            }
        }
        if (!checkContain) {
            throw new DietException("Incorrect nutrient type!");
        }
    }

    /**
     * Takes in user input to check if the activity level is of the expected input.
     *
     * @param userInput user input.
     * @throws DietException when it is not one of the expected activity level.
     */
    public static void checkActivity(String userInput) throws DietException {
        boolean checkContain = false;
        for (String param: PARAM_ACTIVITY) {
            if (userInput.contains(param)) {
                checkContain = true;
            }
        }
        if (!checkContain) {
            throw new DietException("No such activity level!");
        }
    }

    /**
     * Takes in user input to check if the gender is of the expected input.
     *
     * @param userInput user input.
     * @throws DietException when it is not one of the expected gender input.
     */
    public static void checkGender(String userInput) throws DietException {
        boolean checkContain = false;
        for (String param: PARAM_GENDER) {
            if (userInput.contains(param)) {
                checkContain = true;
            }
        }
        if (!checkContain) {
            throw new DietException("Please key in the specified gender characters.");
        }
    }

    /**
     * Takes in an integer age to check if the value is within the logical limit.
     *
     * @param age integer value of age.
     * @throws DietException when value is not within the limit.
     */
    public static void checkAgeLimit(int age) throws DietException {
        if (age < 0) {
            throw new DietException("Input value cannot be less than 0!");
        } else if (age > AGE_CAP) {
            throw new DietException("Input value cannot be more than 125!");
        }
    }

    /**
     * Takes in an integer height to check if the value is within the logical limit.
     *
     * @param height integer value of height.
     * @throws DietException when value is not within the limit.
     */
    public static void checkHeightLimit(int height) throws DietException {
        if (height < 0) {
            throw new DietException("Input value cannot be less than 0!");
        } else if (height > HEIGHT_CAP) {
            throw new DietException("Input value cannot be more than 273!");
        }
    }

    /**
     * Takes in an integer weight to check if the value is within the logical limit.
     *
     * @param weight integer value of weight.
     * @throws DietException when value is not within the limit.
     */
    public static void checkWeightLimit(int weight) throws DietException {
        if (weight < 0) {
            throw new DietException("Input value cannot be less than 0!");
        } else if (weight > WEIGHT_CAP) {
            throw new DietException("Input value cannot be more than 443!");
        }
    }

}
