package seedu.dietbook.parser;

import seedu.dietbook.list.FoodList;
import seedu.dietbook.person.Gender;
import seedu.dietbook.person.ActivityLevel;
import seedu.dietbook.exception.DietException;
import seedu.dietbook.Manager;

public class Parser {
    public static final String COMMAND_NAME = "name";
    public static final String COMMAND_INFO = "info";
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_CALCULATE = "calculate";
    public static final String[] PARAM_CALCULATE = {"fat", "carbohydrate","protein", "calorie", "all"};
    public static final String[] PARAM_INFO = {"g/","a/","h/","l/","o/","t/"};
    public static final String[] PARAM_ADD = {"n/","x/","k/"};


    /**
     * Returns the command of a user input.
     * @param userInput which is user input.
     * @return First word which is the command of the user input.
     */
    public static String getCommand(String userInput) {
        return userInput.split(" ")[0];
    }

    /**
     * Returns the subsequent parameter after the command from the user input.
     * @param userInput user input.
     * @return parameter part of the user input.
     * @throws DietException when the user input is of a wrong format.
     */
    public static String getCommandParam(String userInput) throws DietException {
        String command = getCommand(userInput);
        String[] input = {userInput};

        if (userInput.split(command).length < 2
                || userInput.split(command)[1].equals(" ")) {
            throw new DietException("Error! Missing command parameters!");
        } else {
            switch (command) {
            case COMMAND_NAME:
                return userInput.split("name")[1].trim();
            case COMMAND_CALCULATE:
                for (String param: PARAM_CALCULATE) {
                    if (userInput.contains(param)) {
                        return userInput.split("calculate")[1].trim();
                    }
                }
                throw new DietException("Incorrect nutrient type");
            case COMMAND_ADD:
                for (String param: PARAM_ADD) {
                    if (!userInput.contains(param)) {
                        throw new DietException("Missing or incorrect add statement");
                    }
                }
                return userInput.substring(userInput.indexOf(' ') + 1);
            case COMMAND_INFO:
                for (String param: PARAM_INFO) {
                    if (!userInput.contains(param)) {
                        throw new DietException("Missing or incorrect info statement");
                    }
                }
                return userInput.substring(userInput.indexOf(' ') + 1);
            default:
                return null;
            }
        }
    }

    /**
     * Processes the parameters for <code>add</code> command of user input and adds a <code>Food</code> object.
     * @param userInput user input.
     * @param foodList the FoodList object.
     * @return name of the food that was added.
     * @throws DietException when the user input is of a wrong format.
     */
    public static String getProcessedAdd(String userInput, FoodList foodList) throws DietException {
        int portionSize = 1;
        String foodName = "Food Name";
        int calorie = 0;
        int carb = 0;
        int protein = 0;
        int fat = 0;
        String trimmedParam;
        String[] processedParam;
        String[] paramList = {"x/", "n/", "k/", "c/", "p/", "f/"};
        for (String param: paramList) {
            if (getCommandParam(userInput).contains(param)) {
                processedParam = getCommandParam(userInput).split(param);
                trimmedParam = processedParam[1].trim();
                if (processedParam[1].contains("/")) {
                    trimmedParam = processedParam[1].substring(0, processedParam[1].indexOf("/") - 2).trim();
                }
                switch (param) {
                case "x/":
                    portionSize = Integer.parseInt(trimmedParam);
                    break;
                case "n/":
                    foodName = trimmedParam;
                    break;
                case "k/":
                    calorie = Integer.parseInt(trimmedParam);
                    break;
                case "c/":
                    carb = Integer.parseInt(trimmedParam);
                    break;
                case "p/":
                    protein = Integer.parseInt(trimmedParam);
                    break;
                default:
                    fat = Integer.parseInt(trimmedParam);
                    break;
                }
            }
        }
        return foodList.addFood(portionSize, foodName, calorie, carb, protein, fat);
    }

    /**
     * Processes the parameters for <code>info</code> command of user input and updates the <code>Person</code> object.
     * @param userInput user input.
     * @param manager the manager object.
     * @throws DietException when the user input is of a wrong format.
     */
    public static void executeProcessedInfo(String userInput, Manager manager) throws DietException {
        Gender gender = Gender.MALE;
        ActivityLevel actLvl = ActivityLevel.NONE;
        int age = 0;
        int height = 0;
        int orgWeight = 0;
        int tarWeight = 0;
        String trimmedParam;
        String[] processedParam;
        String[] paramList = {"g/", "a/", "h/", "o/", "t/", "l/"};
        for (String param: paramList) {
            processedParam = getCommandParam(userInput).split(param);
            trimmedParam = processedParam[1].trim();
            if (processedParam[1].contains("/")) {
                trimmedParam = processedParam[1].substring(0, processedParam[1].indexOf("/") - 2).trim();
            }
            switch (param) {
            case "g/":
                String processGender = trimmedParam;
                if (processGender.equals("M")) {
                    gender = Gender.MALE;
                } else {
                    gender = Gender.FEMALE;
                }
                break;
            case "a/":
                age = Integer.parseInt(trimmedParam);
                break;
            case "h/":
                height = Integer.parseInt(trimmedParam);
                break;
            case "o/":
                orgWeight = Integer.parseInt(trimmedParam);
                break;
            case "t/":
                tarWeight = Integer.parseInt(trimmedParam);
                break;
            default:
                String processActLvl = trimmedParam;
                if (processActLvl.equals("1")) {
                    actLvl = ActivityLevel.NONE;
                } else if (processActLvl.equals("2")) {
                    actLvl = ActivityLevel.LOW;
                } else if (processActLvl.equals("3")) {
                    actLvl = ActivityLevel.MEDIUM;
                } else if (processActLvl.equals("4")) {
                    actLvl = ActivityLevel.HIGH;
                } else {
                    actLvl = ActivityLevel.EXTREME;
                }
                break;
            }
        }
        manager.setPerson(manager.getName(), gender, age, height, orgWeight, tarWeight, actLvl);
    }

    /**
     * Returns the index after the command of a user input, e.g. delete 3.
     * @param userInput user input.
     * @return index part of the user input.
     * @throws DietException when the user input is of a wrong format.
     */
    public static int getCommandIndex(String userInput) throws DietException {
        String command = getCommand(userInput);

        if (userInput.split(command).length < 2 || userInput.split(command)[1].equals(" ")) {
            throw new DietException("OOPS!!! Missing index of duke.task!");
        }
        try {
            return Integer.parseInt(userInput.split(" ")[1]);
        } catch (NumberFormatException e) {
            throw new DietException("OOPS!!! No integer index detected!");
        }
    }
}
