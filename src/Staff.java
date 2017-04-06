import java.util.Scanner;

public class Staff extends Person {
    private static final Scanner SC = new Scanner(System.in);
    public static final double[] BONUS = {0.08, 0.06, 0.03, 0.01, 0.0};
    private double salary;
    private char performance;

    public Staff(){
        salary = -1;
    }

    public Staff(String pers) {
        super(pers);
        String[] persArray = pers.split(", ");
        setSalary(Integer.parseInt(persArray[5]));
        setPerformance(persArray[6].charAt(0));
    }

    public static Staff askForStaff() {

        Person persstaff = Person.askForPerson();
        String staff;
        if (persstaff.getId() == -1) return new Staff();
        else staff = persstaff.toString();

        System.out.println("Please enter this person's salary: ");
        staff += ", " + Person.askForInteger();
        System.out.println("Please enter this staff's performance code: ");
        staff += ", " + askForChar();

        return new Staff(staff);
    }

    public static char askForChar() {
        while (true) {
            char character = SC.next().toUpperCase().charAt(0);
            if ((int) character < 70 && (int) character > 64){
                return character;
            }
            System.out.println("Character must be between A, B, C, D, or E!");
            SC.next();
        }
    }
    
    public String toString() {
        return super.toString() + ", " + salary + ", " + performance;
    }

    // Getters and Setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public char getPerformance() {
        return performance;
    }

    public void setPerformance(char performance) {
        this.performance = performance;
    }

}
