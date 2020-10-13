package seedu.duke.person;

/**
 * Represents a Person.
 * A <code>Person</code> has a name, gender, age, height, certain activity level, original and desired weight.
 */
public class Person {

    /* The height of the person in cm */
    private int height;
    /* The original weight of the person in kg */
    private int originalWeight;
    /* The target weight of the person in kg */
    private int targetWeight;
    private int age;
    private ActivityLevel activityLevel;
    private Gender gender;
    private String name;

    /**
     * Constructs a <code>Person</code> with the given name, gender, age, height, original weight, target
     * weight and activity level.
     *
     * @param name The name of the person.
     * @param gender The gender of the person.
     * @param age The age of the person.
     * @param height The height of the person.
     * @param originalWeight The original weight of the person.
     * @param targetWeight The target/desired weight that the person wants to achieve.
     * @param activityLevel The activity level of the person or in other words, the amount of exercise the
     *     person engages in.
     */
    public Person(String name, Gender gender, int age, int height, int originalWeight, int targetWeight,
                  ActivityLevel activityLevel) {
        assert name != null : "Name of person should not be null";
        assert name.trim().length() > 0 : "Name of person should not be an empty string";
        assert gender != null : "Gender of person should not be null";
        assert age > 0 : "Age of person should be greater than 0";
        assert age < 125 : "Age of person should be less than 125";
        assert height > 0 : "Height of person should be greater than 0";
        assert height < 273 : "Height of person should be less than 273";
        assert originalWeight > 0 : "Original weight of person should be greater than 0";
        assert originalWeight < 443 : "Original weight of person should be less than 443";
        assert targetWeight > 0 : "Target weight of person should be greater than 0";
        assert targetWeight < 443 : "Target weight of person should be less than 443";
        assert activityLevel != null : "Activity level of person should not be null";

        this.name = name.trim();
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.originalWeight = originalWeight;
        this.targetWeight = targetWeight;
        this.activityLevel = activityLevel;
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person to the new name given.
     *
     * @param newName The new/revised name of the person.
     */
    public void setName(String newName) {
        assert newName != null : "The revised name of person should not be null";
        assert newName.trim().length() > 0 : "The revised name of person should not be an empty string";
        name = newName.trim();
    }

    /**
     * Returns the gender of the person.
     *
     * @return The gender of the person.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person to the new gender given.
     *
     * @param newGender The new/revised gender of the person.
     */
    public void setGender(Gender newGender) {
        assert newGender != null : "The revised gender of person should not be null";
        gender = newGender;
    }

    /**
     * Returns the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person to the new age that is given.
     *
     * @param newAge The new/revised age of the person.
     */
    public void setAge(int newAge) {
        assert newAge > 0 : "The revised age of person should be greater than 0";
        assert newAge < 125 : "The revised age of person should be lesser than 125";
        age = newAge;
    }

    /**
     * Returns the height of the person.
     *
     * @return The height of the person.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the person to the new height given.
     *
     * @param newHeight The new/revised height of the person.
     */
    public void setHeight(int newHeight) {
        assert newHeight > 0 : "The revised height of person should be greater than 0";
        assert newHeight < 273 : "The revised height of person should be lesser than 273";
        height = newHeight;
    }

    /**
     * Returns the original weight of the person.
     *
     * @return The original weight of the person.
     */
    public int getOriginalWeight() {
        return originalWeight;
    }

    /**
     * Sets the original weight of the person to the new original weight given.
     *
     * @param newOriginalWeight The new/revised original weight of the person.
     */
    public void setOriginalWeight(int newOriginalWeight) {
        assert newOriginalWeight > 0 : "The revised original weight of person should be greater than 0";
        assert newOriginalWeight < 443 : "The revised original weight of person should be lesser than 443";
        originalWeight = newOriginalWeight;
    }

    /**
     * Returns the target weight the person the person wants to achieve.
     *
     * @return The target weight the person wants to achieve.
     */
    public int getTargetWeight() {
        return targetWeight;
    }

    /**
     * Sets the target weight of the person to the new target weight given.
     *
     * @param newTargetWeight The new/revised target weight of the person.
     */
    public void setTargetWeight(int newTargetWeight) {
        assert newTargetWeight > 0 : "The revised target weight of person should be greater than 0";
        assert newTargetWeight < 443 : "The revised target weight of person should be lesser than 443";
        targetWeight = newTargetWeight;
    }

    /**
     * Returns the activity level of the person.
     *
     * @return The activity level of the person.
     */
    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    /**
     * Sets the activity level of the person to the new activity level given.
     *
     * @param newActivityLevel The new/revised activity level of the person.
     */
    public void setActivityLevel(ActivityLevel newActivityLevel) {
        assert newActivityLevel != null : "The revised activity level of person should not be null";
        activityLevel = newActivityLevel;
    }

    /**
     * Returns a string representation of all information related to the user.
     * Information includes name, gender, age, height, original weight, target weight and activity level.
     *
     * @return A string representation of all information related to the user.
     */
    @Override
    public String toString() {
        String userInformation = "  Name: " + name + System.lineSeparator()
                + "  Gender: " + gender.getDescription() + System.lineSeparator()
                + "  Age: " + age + System.lineSeparator()
                + "  Height: " + height + "cm" + System.lineSeparator()
                + "  Original weight: " + originalWeight + "kg" + System.lineSeparator()
                + "  Target weight: " + targetWeight + "kg" + System.lineSeparator()
                + "  Activity level: " + activityLevel.getDescription();
        return userInformation;
    }
}
