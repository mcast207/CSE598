package directory;

public class Security extends Person {
    
    public Security(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public void printDetails() {
    	System.out.print("Security: ");
        printNameFirstMiddleLast(); 
    }
}