package directory;

public class Person implements Printable {
    // Common coupling and object oriented encapsulation fix: Private attributes with getters and setters
    private String last;
    private String first;
    private String middle;

    public Person(String last, String first, String middle) {
        this.last = last;
        this.first = first;
        this.middle = middle;
    }

	//Stamp fix, overloading constructor
	public Person(String last, String first) {
        this.last = last;
        this.first = first;
        this.middle = "";
    }

	//Also Content coupling fix methods below:
    public String getFirstName() {
        return first;
    }

    public void setFirstName(String first) {
        this.first = first;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String last) {
        this.last = last;
    }

    public String getMiddleName() {
        return middle;
    }

    public void setMiddleName(String middle) {
        this.middle = middle;
    }
    
    //Control Coupling fix
    // Method to print First Middle Last format
    public void printNameFirstMiddleLast() {
        System.out.println(first + " " + middle + " " + last);
    }

    // Method to print First Last Middle format
    public void printNameFirstLastMiddle() {
        System.out.println(first + " " + last + " " + middle);
    }

    // Method to print Last First Middle format
    public void printNameLastFirstMiddle() {
        System.out.println(last + ", " + first + " " + middle);
    }
    
    @Override
    public void printDetails() {
        printNameFirstMiddleLast(); // Defaulting to the First Middle Last format
    }
}
