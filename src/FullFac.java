import java.util.Scanner;

public class FullFac extends Person {
    private static final Scanner SC = new Scanner(System.in);

    private int salary;

    public FullFac() {
        setSalary(-1);
    }

    public FullFac(String pers){
        super(pers);
        String[] persArray = pers.split(", ");
        setSalary(Integer.parseInt(persArray[5]));
    }

    public static FullFac askForFullFac() {

        Person persfullfac = Person.askForPerson();
        String fullfac;
        if (persfullfac.getId() == -1) return new FullFac();
        else fullfac = persfullfac.toString();

        System.out.println("Please enter this person's salary: ");
        fullfac += ", " + Person.askForInteger();
        return new FullFac(fullfac);
    }


    public String toString() {
        return super.toString() + ", " + salary;
    }

    // Getters and Setters
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
