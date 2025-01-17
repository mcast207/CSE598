package directory;


public class FirstLastMiddlePrinter implements NamePrinter {
    @Override
    public void printName(Person person) {
        //Using content coupling fix with getter methods
        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getMiddleName());
    }
}
