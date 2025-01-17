package directory;
import java.util.Scanner;

public class PersonnelDirectory {
    public static void main(String[] args) {
        PersonnelManager manager = new PersonnelManager();
        TotalObjects total = new TotalObjects(); 
        Scanner scan = new Scanner(System.in);
        String firstN, lastN, middleN;
        int empID;
        double salary;
        int choice;

        do {
            System.out.println("Welcome to the Personnel Directory Management System");
            System.out.println("====================================================");
            System.out.println("\n\n\t 1. Add Personnel");
            System.out.println("\n\t 2. Find Personnel");
            System.out.println("\n\t 3. Print Names");
            System.out.println("\n\t 4. Number of Entries in the Directory");
            System.out.println("\n\t Select one of the options above (1, 2, 3, 4)");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter personnel type (Employee, Executive, Security, Volunteer): ");
                    String type = scan.nextLine();
                    System.out.println("Enter first name: ");
                    firstN = scan.nextLine();
                    System.out.println("Enter last name: ");
                    lastN = scan.nextLine();
                    System.out.println("Enter middle name: ");
                    middleN = scan.nextLine();
            
                    switch (type.toLowerCase()) {
                        case "person":
                            Person person = PersonnelFactory.createPerson(lastN, firstN, middleN);
                            manager.addPersonnel(person); 
                            person.printDetails();
                            break;
                            
                        case "employee":
                            System.out.println("Enter employee ID: ");
                            empID = scan.nextInt();
                            
                            System.out.println("Enter base salary: ");
                            salary = scan.nextDouble();
                            scan.nextLine();  // Consume newline
                    
                            Employee employee = PersonnelFactory.createEmployee(lastN, firstN, middleN, empID, salary);
                            manager.addPersonnel(employee);  
                            employee.printDetails();
                            break;
                            
                        case "executive":
                            Executive executive = PersonnelFactory.createExecutive(lastN, firstN, middleN);
                            manager.addPersonnel(executive);
                            executive.printDetails();
                            break;
                    
                        case "security":
                            Executive security = PersonnelFactory.createExecutive(lastN, firstN, middleN);
                            manager.addPersonnel(security);
                            security.printDetails();
                            break;

                        case "volunteers":
                            Executive volunteer = PersonnelFactory.createExecutive(lastN, firstN, middleN);
                            manager.addPersonnel(volunteer);
                            volunteer.printDetails();
                            break;

                        default:
                            System.out.println("Unknown personnel type.");
                            break;
                    }
                    break;

                case 2:

                    System.out.println("Enter first name: ");
                    firstN = scan.nextLine();
                    System.out.println("Enter last name: ");
                    lastN = scan.nextLine();

                    //Common coupling solution
                    Person foundPerson = manager.findPerson(lastN, firstN);
                    if (foundPerson != null) {
                        System.out.println("Found");
                        foundPerson.printNameFirstMiddleLast();
                    } 
                    else{
                        System.out.println("Person not found. Would you like to add them? (yes/no)");
                        String response = scan.nextLine();
                    
                        if (response.equalsIgnoreCase("yes")) {
                    
                            Printable newPerson = PersonnelFactory.createPerson(lastN, firstN, "");
                            if (newPerson != null) {
                                manager.addPersonnel((Person) newPerson); 
                                total.objectAdded(); 
                                System.out.println("New Person" + " added to directory.");
                            } else {
                                System.out.println("Invalid personnel type.");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the order 0: first, middle, last, 1: first, last, middle, 2: last, first, middle ");
                    int order = scan.nextInt();
                    manager.printNames(order);
                    break;

                case 4:
                    System.out.println("Total Entries: " + manager.getTotalEntries());
                    break;
            }
        } while (choice != 0);
        scan.close(); 
    }
}