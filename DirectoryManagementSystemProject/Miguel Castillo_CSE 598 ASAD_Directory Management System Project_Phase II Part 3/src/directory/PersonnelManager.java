package directory;

public class PersonnelManager {
    private Personnel personnel = new Personnel();

    public void addPersonnel(Person person){
        personnel.addPersonnel(person);
    }

    public Person findPerson(String last, String first) {
        return personnel.findPersonByName(last, first);
    }

    public int getTotalEntries() {
        return personnel.getTotalPersonnelCount();
    }

    public void printNames(int order) {
        personnel.printAllNames(order);
    }
}

