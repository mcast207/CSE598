package directory;

public class LastFirstMiddlePrinter implements NamePrinter {
    @Override
    public void printName(Person person) {
        //Using content coupling fix with getter methods
        System.out.println(person.getLastName() + ", " + person.getFirstName() + " " + person.getMiddleName());
    }
}