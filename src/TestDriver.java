import java.util.ArrayList;
import java.util.Arrays;


public class TestDriver {

    public static void main(String[] args) {

        Student.validateTAs("database/TAs.txt");
        System.out.println("Adding Full Time Faculty members:");
        addFTRecords();
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

    public static <T extends Person> void addRecords(String file, T newPers) {
        FileManager fm = new FileManager();
        ArrayList<String> stringContents = new ArrayList(Arrays.asList(fm.readAll(file)));
        ArrayList<Person> contents = new ArrayList<Person>(10);
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
