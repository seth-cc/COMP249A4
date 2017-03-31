@SuppressWarnings({"WeakerAccess", "unused"})
public class PartFac extends Person {
// part-time faculty

    private int rate;
    private int hours;
    private int studentQuantity;

    public PartFac(){
        rate = -1;
        hours = -1;
        studentQuantity = -1;
    }
    public PartFac(String pers){
        super(pers);
        String[] persArray = pers.split(", ");
        setRate(Integer.parseInt(persArray[5]));
        setHours(Integer.parseInt(persArray[6]));
        setStudentQuantity(Integer.parseInt(persArray[7]));
    }

    public static PartFac askForPartFac() {

        Person perspartfac = Person.askForPerson();
        String partfac;
        if (perspartfac.getId() == -1) return new PartFac();
        else partfac = perspartfac.toString();

        System.out.println("Please enter this person's hourly rate: ");
        partfac += ", " + Person.askForInteger();
        System.out.println("Please enter this person's number of hours: ");
        partfac += ", " + Person.askForInteger();
        System.out.println("Please enter this person's number of students: ");
        partfac += ", " + Person.askForInteger();
        return new PartFac(partfac);
    }

    public String toString() {
        return super.toString() + ", " + rate + ", " + hours + ", " + studentQuantity;
    }

    // Getters and setters
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
    }
}
