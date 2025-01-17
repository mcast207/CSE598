package directory;

public class Volunteers extends Person {
    public Volunteers(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public void printDetails() {
    	System.out.print("Volunteer: ");
        printNameFirstMiddleLast(); 
    }
}