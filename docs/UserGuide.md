# DietBook User Guide

## Introduction

DietBook is a desktop application targeting NUS students optimized for use via a **Command Line Interface**. Not only can DietBook track and show the user's food and nutritional intake, it also provides users with a list of commonly eaten food items around and outside NUS. 
 
## Quick Start
1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `dietbook.jar` from [here](https://github.com/AY2021S1-CS2113-T14-4/tp/releases).
1. Copy the file to the folder you want to use as the home folder for your DietBook.
1. Either double-click the jar file to start the application or navigate to the folder containing the jar file on command prompt and run the command `java -jar dietbook.jar`. 

## Features 

Notes about the command format:

* Words in `UPPER_CASE` are parameters to be supplied by the user.<br/> 
e.g. For `delete INDEX`, `delete 1`would be a valid command.
  
* Parameters in square brackets are optional. However, if all parameters are optional, at least one parameter needs to be given. In such cases, any one of the parameters would be valid.<br/>
e.g. For `add x/PORTION_SIZE n/FOOD_NAME k/CALORIE [c/CARBOHYDRATE] [p/PROTEIN] [f/FAT]`, `add x/1 n/Toast k/120`, `add x/1 n/Toast k/120 c/18`,  `add x/1 n/Toast k/120 c/18 p/3`, `add x/1 n/Toast k/120
 c/18 p/3 f/4` are all valid commands.
 
* For commands with multiple parameters, the parameters can be in any order.<br/>
e.g. For `add n/FOOD_NAME x/PORTION_SIZE`, `add n/mee x/1` and `add x/1 n/mee` are both valid.

* Command words and parameter indicators are case-sensitive.<br/>
e.g. `help` is a valid command but `Help` is not.<br/>
e.g. For `add n/FOOD_NAME x/PORTION_SIZE`, `add n/mee x/1` is valid but `add N/mee x/1` is not.

* Spaces to separate command words, parameters, command word and parameters are important.<br/>
e.g. For `calculate all`, `calculate all` is valid but `calculateall` is not.<br/>
e.g. For `delete INDEX`, `delete 1` is valid if there is a food item with index 1 but`delete1` is not.<br/>
e.g. For `add n/FOOD_NAME x/PORTION_SIZE`, `add n/mee x/1` is valid but `add n/meex/1` is not.<br/>

### Features related to user information

#### Viewing user information: `userinfo`

Shows the user information stored in DietBook.

Format: `userinfo` 

Output example: 
```
Here is your information:
  Name: Jack
  Gender: male
  Age: 21
  Height: 175cm
  Original weight: 85kg
  Current weight: 85kg
  Target weight: 75kg
  Activity level: You engage in some form of light exercise or have a job that requires some physical activity.
```

#### Editing user information: `editinfo`

Edits the user information stored in DietBook.

Format: `editinfo [n/NAME] [g/GENDER] [a/AGE] [h/HEIGHT] [o/ORIGINAL_WEIGHT] [c/CURRENT_WEIGHT] [t/TARGET_WEIGHT] [l/ACTIVITY_LEVEL]` 

* Although all parameters are listed as optional, **at least one of the optional fields needs to be provided**. In this case, any one of the parameters would work.
* If more than one parameter is given, they can be in any order.
* Existing values will be updated to the input values.
* The name must not be empty.
* The gender must be either **`M` for male, `F` for female or `O` for others**.
* The age must be a positive integer **between 0 and 150**.
* The height must be a positive integer **between 0 and 300**.
* The original, current and target weight must be a positive integer **between 0 and 500**.
* The activity level must be a positive integer **from 1 to 5, inclusive**.
  * 1 = You hardly engage in any exercise or have a job that requires little to no physical activity.
  * 2 = You engage in some form of light exercise or have a job that requires some physical activity.
  * 3 = You engage in moderate amount of exercise or have a job that requires moderate physical activity.
  * 4 = You engage in vigorous exercise or have a physically demanding job.
  * 5 = You engage in extremely vigorous exercise or have an extremely physically demanding job.

Input examples:

* `editinfo n/John` edits the updated the name stored in DietBook.
* Both `editinfo c/75 l/4` and `editinfo l/4 c/75` edits the current weight and activity level of the
 user to be `75` and `You engage in vigorous exercise or have a physically demanding job.` respectively.
 
Output example for input example 2: 
```
Got it! I've updated your personal information:
  Name: Jack
  Gender: male
  Age: 21
  Height: 175cm
  Original weight: 85kg
  Current weight: 75kg
  Target weight: 75kg
  Activity level: You engage in vigorous exercise or have a physically demanding job.
```

### Features related to the food database

To add a food from the database: add n/FOOD_NAME x/PORTION_SIZE
To view all food in the database: data
 
### Features related to the food list

To add you own food: add x/PORTION_SIZE n/FOOD_NAME k/CALORIE [c/CARBOHYDRATE] [p/PROTEIN] [f/FAT]
To view all food in DietBook: list
To view all food in DietBook recorded within a time period: list yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
To view all food in DietBook recorded from a certain date until now: list yyyy-mm-ddTHH:mm 
To delete a food from DietBook: delete INDEX
To delete all food items from the DietBook: clear

### Features related to nutritional intake and recommendation

To get recommended calorie intake: recommend

 To calculate carbohydrate intake: calculate carbohydrate
 To calculate carbohydrate intake within a time period: calculate carbohydrate yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
 To calculate carbohydrate intake from a certain date until now: calculate carbohydrate yyy-mm-ddTHH:mm

 To calculate calorie intake: calculate calorie
 To calculate calorie intake within a time period: calculate calorie yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
 To calculate calorie intake from a certain date until now: calculate calorie yyyy-mm-ddTHH:mm

 To calculate protein intake: calculate protein
 To calculate protein intake within a time period: calculate protein yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
 To calculate protein intake from a certain date until now: calculate protein yyyy-mm-ddTHH:mm

 To calculate fat intake: calculate fat
 To calculate fat intake within a time period: calculate fat yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
 To calculate fat intake from a certain date until now: calculate fat yyyy-mm-ddTHH:mm

 To calculate all nutritional intake: calculate all
 To calculate all nutritional intake within a time period: calculate all yyyy-mm-ddTHH:mm yyyy-mm-ddTHH:mm
 To calculate all nutritional intake from a certain date until now: calculate all yyyy-mm-ddTHH:mm
 
### Other features

 To view a list of valid commands: help
 To exit DietBook: exit
 Saving
 
#### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
