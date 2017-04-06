import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class Driver {

    public static void main(String[] args) {

//        System.out.println("Adding Full Time Faculty members:");
//        addFTRecords();
//        findTermSalary();
//        findHighest_and_Lowest_FT_Salary();
//        increase_Staff_Salary();


//        Person p1 = new Person("8, Hippolyte, Bergamotte, Brussels, 1949");
//        Person p2 = new Person("8, Hippolyte, Bergamotte, Brussels, 1950");
//
//        System.out.println(p1.precedes(p2));
//        System.out.println(p1.follows(p2));

    }

    public static void findTermSalary(){

        FileManager fm = new FileManager();
        System.out.println("Verifying TA File contents...");
        Student.validateTAs("database/TAs.txt");

        System.out.println("Fetching TAs...");
        String[] students = fm.readAll("database/TAs.txt");
        MyLinkedList<Student> linkedStudents = new MyLinkedList<>();
        for(int i = 0; i < students.length; i++){
            linkedStudents.addAt(new Student(students[i]), i);
        }

        System.out.println("Fetching Part Time Faculty...");
        String[] partFacs = fm.readAll("database/Part-Time-Faculty.txt");
        MyLinkedList<PartFac> linkedPartFac = new MyLinkedList<>();
        for(int i = 0; i < partFacs.length; i++){
            linkedPartFac.addAt(new PartFac(partFacs[i]), i);
        }

        double total = 0;
        for(int i = 0; i < linkedStudents.getSize(); i++){
            Student current = linkedStudents.findAt(i);
            if (current.getType() == Student.Type.UGRAD){
                total += Student.UGRAD_RATE * current.getHours();
            }
            else {
                if(current.getType() == Student.Type.GRAD){
                    total += Student.GRAD_RATE * current.getHours();
                }
            }
        }
        for(int i = 0; i < linkedPartFac.getSize(); i++){
            PartFac current = linkedPartFac.findAt(i);
            if (current.getStudentQuantity() > 60){
                total += 1000;
            }
            else if(current.getStudentQuantity() >= 40) {
                total += 500;
            }
            total += (double) current.getHours() * current.getRate();
        }
        System.out.println("The total calculated term salary is: $" + total);
    }

    public static void findHighest_and_Lowest_FT_Salary(){
        FileManager fm = new FileManager();
        System.out.println("Fetching Full Time Faculty...");
        String[] fullfacs = fm.readAll("database/Full-Time-Faculty.txt");
        MyLinkedList<FullFac> linkedFullFacs = new MyLinkedList<>();
        for(int i = 0; i < fullfacs.length; i++){
            linkedFullFacs.addAt(new FullFac(fullfacs[i]), i);
        }
        FullFac lowest = linkedFullFacs.findAt(0);
        FullFac highest = linkedFullFacs.findAt(0);

        for(int i = 0; i < linkedFullFacs.getSize(); i++) {
            FullFac current = linkedFullFacs.findAt(i);
            if(current.getSalary() < lowest.getSalary()){
                lowest = current;
            }
            if(current.getSalary() > highest.getSalary()){
                highest = current;
            }
        }

        System.out.println("The full-time faculty member with the lowest salary is:\n" + lowest);
        System.out.println("The full-time faculty member with the highest salary is:\n" + highest);

    }

    public static void increase_Staff_Salary(){
        FileManager fm = new FileManager();
        System.out.println("Fetching Staff...");
        String[] staffs = fm.readAll("database/Staff.txt");
        MyLinkedList<Staff> linkedStaff = new MyLinkedList<>();
        for(int i = 0; i < staffs.length; i++){
            linkedStaff.addAt(new Staff(staffs[i]), i);
        }
        System.out.println("Changing salaries...");
        for(int i = 0; i < linkedStaff.getSize(); i++) {
            Staff current = linkedStaff.findAt(i);
            int performance_int = (int) current.getPerformance() - 65;
            current.setSalary(current.getSalary() + current.getSalary() * Staff.BONUS[performance_int]);
            current.setPerformance('E');
            fm.removeLine("database/Staff.txt", current.getId());
            fm.write("database/Staff.txt",current.toString());
        }
        System.out.println("Done.");

    }

    public static void addFTRecords(){
        String file = "database/Full-Time-Faculty.txt";
        while(true){
            FullFac newFullFac = FullFac.askForFullFac();
            if(newFullFac.getId() == -1){
                System.out.println("Exiting...");
                break;
            }
            addRecords(file, newFullFac);
        }
    }
    public static void addPTRecords(){
        String file = "database/Part-Time-Faculty.txt";
        while(true){
            PartFac newPartFac = PartFac.askForPartFac();
            if(newPartFac.getId() == -1){
                System.out.println("Exiting...");
                break;
            }
            addRecords(file, newPartFac);
        }
    }
    public static void addTARecords(){
        String file = "database/TAs.txt";
        while(true){
            Student newStudent = Student.askForStudent();
            if(newStudent.getId() == -1){
                System.out.println("Exiting...");
                break;
            }
            if(newStudent.getType() == Student.Type.ALUM){
                System.out.println("Cannot be a TA if the student is alumnus!");
            }
            else addRecords(file, newStudent);
        }
    }

    private static <T extends Person> void addRecords(String file, T newPers) {
        FileManager fm = new FileManager();
        ArrayList<String> stringContents = new ArrayList<>(Arrays.asList(fm.readAll(file)));
        ArrayList<Person> contents = new ArrayList<>(10);
        for( String stringpers : stringContents){
            contents.add(new Person(stringpers));
        }
        boolean validID = false;
        while(!validID) {
            validID = true;
            for (Person persInFile : contents) {
                if (persInFile.getId() == newPers.getId()) {
                    validID = false;
                    System.out.println("That ID is already taken. \nPlease enter a new ID: ");
                    newPers.setId(Person.askForInteger());
                }
            }
        }
        System.out.println("Accepted person! will add to file...");
        fm.write(file, newPers.toString());
    }
}
