package directory;

public class PersonnelFactory {

    public static Person createPerson(String lastName, String firstName, String middleName) {
        return new Person(lastName, firstName, middleName);
    }

    public static Employee createEmployee(String lastName, String firstName, String middleName, int empID, double salary) {
        return new Employee(lastName, firstName, middleName, empID, salary);
    }

    public static Executive createExecutive(String lastName, String firstName, String middleName) {
        return new Executive(lastName, firstName, middleName);
    }

    public static Security createSecurity(String lastName, String firstName, String middleName) {
        return new Security(lastName, firstName, middleName);
    }

    public static Volunteers createVolunteers(String lastName, String firstName, String middleName) {
        return new Volunteers(lastName, firstName, middleName);
    }
}

