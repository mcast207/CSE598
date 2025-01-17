package directory;

import java.util.ArrayList;
import java.util.List;

public class Personnel {
    private static int numObjects = 0;
    private List<Person> personList = new ArrayList<>(); 

    public void addPersonnel(Person person) {
        personList.add(person);
        incrementObjectCount();
    }

    //Common Coupling fix. 
    //Make private method to only be accessed within this class, not globally.
    private static void incrementObjectCount() {
        numObjects++;
    }

    // Public method to retrieve the count outside this class
    public static int getTotalObjects() {
        return numObjects;
    }
    
    public Person findPersonByName(String last, String first) {
        for (Person person : personList) {
            if (person.getFirstName().equals(first) && person.getLastName().equals(last)) {
                return person;
            }
        }
        return null; 
    }

    public int getTotalPersonnelCount() {
        return personList.size();
    }
    
    public void printAllNames(int order) {
        for (Person person : personList) {
            switch (order) {
                case 0:
                    person.printNameFirstMiddleLast(); 
                    break;
                case 1:
                    person.printNameFirstLastMiddle();
                    break;
                case 2:
                    person.printNameLastFirstMiddle();
                    break;
                default:
                    System.out.println("Invalid order");
                    break;
            }
        }
    }
}
