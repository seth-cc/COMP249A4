public class Staff extends Person {
    public static double[] bonus = {0.08, 0.06, 0.03, 0.01, 0.0};     // double
    private int salary;

    public Staff(){
        salary = -1;
    }

    public Staff(String pers) {
        super(pers);
        String[] persArray = pers.split(", ");
        setSalary(Integer.parseInt(persArray[5]));
    }

    public static Staff askForStaff() {

        Person persstaff = Person.askForPerson();
        String staff;
        if (persstaff.getId() == -1) return new Staff();
        else staff = persstaff.toString();

        System.out.println("Please enter this person's salary: ");
        staff += ", " + Person.askForInteger();
        return new Staff(staff);
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
