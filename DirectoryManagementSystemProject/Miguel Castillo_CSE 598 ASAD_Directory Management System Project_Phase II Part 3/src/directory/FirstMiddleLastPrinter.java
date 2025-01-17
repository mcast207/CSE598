package directory;

public class FirstMiddleLastPrinter implements NamePrinter {
    @Override
    public void printName(Person person) {
        //Using content coupling fix with getter methods
        System.out.println(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());
    }
}