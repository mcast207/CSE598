package directory;

public class Executive extends Person {
    public Executive(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public void printDetails() {
    	System.out.print("Executive: ");
        printNameFirstMiddleLast(); 
    }
}
