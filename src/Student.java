import java.util.Scanner;

public class Student extends Person {
    private static final Scanner SC = new Scanner(System.in);

    public enum Type {GRAD, UGRAD, ALUM}
    public static final double UGRAD_RATE = 18.25;
    public static final double GRAD_RATE = UGRAD_RATE * 1.2;
    private Type type;
    private int classNum;
    private int hours;

    public Student(){
        type = Type.UGRAD;
        classNum = -1;
        hours = -1;
    }

    public Student(String pers) {
        super(pers);
        String[] persArray = pers.split(", ");
        setType(Type.valueOf(persArray[5]));
        setClassNum(Integer.parseInt(persArray[6]));
        setHours(Integer.parseInt(persArray[7]));
    }


    public static String askForType() {
        while (true) {
            String type = SC.next();
            if (type.toUpperCase() == "UGRAD" || type == "GRAD" || type == "ALUM") {
                return type.toUpperCase();
            } else {
                System.out.println("You must enter UGRAD, GRAD, or ALUM: ");
                SC.next();

            }
        }
    }


    public static Student askForStudent() {

        Person persstudent = Person.askForPerson();
        String student;
        if (persstudent.getId() == -1) return new Student();
        else student = persstudent.toString();

        System.out.println("Please enter a student type (UGRAD, GRAD, or ALUM) : ");
        student += ", " + askForType();
        System.out.println("Please enter the number of classes that student is involved with: ");
        student += ", " + Person.askForInteger();
        System.out.println("Please enter the number of hours per week dedicated to these classes: ");
        student += ", " + Person.askForInteger();
        return new Student(student);
    }


    public static void validateTAs(String file) {
        FileManager fm = new FileManager();
        String[] contents = fm.readAll(file);
        int max = contents.length;
        for (int i = 0; i < max; i++) {
            if (contents[i].contains("ALUM")) {
                System.out.println("Found an alumni, deleting: " + contents[i]);
                fm.removeLine(file, Integer.parseInt(contents[i].substring(0, contents[i].indexOf(","))));
                // The above passes the id as second param
            }
        }
    }

    public String toString() {
        return super.toString() + ", " + type + ", " + classNum + ", " + hours;
    }


    // Getters and setters
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}
