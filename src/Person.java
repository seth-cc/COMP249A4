import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    private static final Scanner SC = new Scanner(System.in);
    private int id;
    private String fname;
    private String lname;
    private String city;
    private int startYear;         // Hire year for staff / faculty, year of enrollment for students


    public Person() {
        id = -1;
        fname = "null";
        lname = "null";
        city = "null";
        startYear = -1;
    }

    public Person(String pers) {
        String[] persArray = pers.split(", ");
        setId(Integer.parseInt(persArray[0]));
        setStartYear(Integer.parseInt(persArray[4]));
        setFname(persArray[1]);
        setLname(persArray[2]);
        setCity(persArray[3]);
    }

    public String toString() {

        return id + ", " + fname + ", " + lname + ", " + city + ", " + startYear;
    }

    public static int askForInteger() {
        while (true) {
            try {
                int num = SC.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer: ");
                SC.next();
            }
        }
    }

    public static Person askForPerson() {
        String person = "";
        System.out.println("Please enter an ID: ");
        person += askForInteger();
        if (person.contains("-1")){
            return new Person(); // when the user no longer has anyone to enter.
        }
        System.out.println("Please enter a first name: ");
        person += ", " + SC.next();
        System.out.println("Please enter a last name: ");
        person += ", " + SC.next();
        System.out.println("Please enter a city: ");
        person += ", " + SC.next();
        System.out.println("Please enter a startYear: ");
        person += ", " + askForInteger();
        return new Person(person);
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
}
