package seedu.duke.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("Jack", Gender.MALE,21,165,75,65,
                ActivityLevel.LOW);
    }

    @Test
    void getName_person_returnsName() {
        assertEquals("Jack", person.getName());
    }

    @Test
    void setName_personWithNewName_returnNewName() {
        person.setName("Jackie");
        assertEquals("Jackie", person.getName());
    }

    @Test
    void gender_person_returnsGender() {
        assertEquals(Gender.MALE, person.getGender());
    }

    @Test
    void gender_personWithNewGender_returnsNewGender() {
        person.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, person.getGender());
    }

    @Test
    void getAge_person_returnsAge() {
        assertEquals(21, person.getAge());
    }

    @Test
    void setAge_personWithNewAge_returnsNewAge() {
        person.setAge(24);
        assertEquals(24, person.getAge());
    }

    @Test
    void getHeight_person_returnsHeight() {
        assertEquals(165, person.getHeight());
    }

    @Test
    void setHeight_personWithNewHeight_returnsNewHeight() {
        person.setHeight(175);
        assertEquals(175, person.getHeight());
    }

    @Test
    void getOriginalWeight_person_returnsOriginalWeight() {
        assertEquals(75, person.getOriginalWeight());
    }

    @Test
    void setOriginalWeight_personWithNewOriginalWeight_returnsNewOriginalWeight() {
        person.setOriginalWeight(70);
        assertEquals(70, person.getOriginalWeight());
    }

    @Test
    void getTargetWeight_person_returnsTargetWeight() {
        assertEquals(65, person.getTargetWeight());
    }

    @Test
    void setTargetWeight_personWithNewTargetWeight_returnsNewTargetWeight() {
        person.setTargetWeight(68);
        assertEquals(68, person.getTargetWeight());
    }

    @Test
    void getActivityLevel_person_returnsActivityLevel() {
        assertEquals(ActivityLevel.LOW, person.getActivityLevel());
    }

    @Test
    void setActivityLevel_personWithNewActivityLevel_returnsNewActivityLevel() {
        person.setActivityLevel(ActivityLevel.HIGH);
        assertEquals(ActivityLevel.HIGH, person.getActivityLevel());
    }

    @Test
    void toString_person_returnsStringRepresentationOfPersonInformation() {
        assertEquals("  Name: Jack" + System.lineSeparator()
                + "  Gender: male" + System.lineSeparator()
                + "  Age: 21" + System.lineSeparator()
                + "  Height: 165cm" + System.lineSeparator()
                + "  Original weight: 75kg" + System.lineSeparator()
                + "  Target weight: 65kg" + System.lineSeparator()
                + "  Activity level: You engage in some form of light exercise or have a job that requires "
                + "some physical activity.", person.toString());
    }
}
