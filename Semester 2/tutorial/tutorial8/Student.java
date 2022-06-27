package programming2.tutorial8;

public class Student extends Person
{
    private double gpa;

    public Student(String firstName, String lastName, String address, int id, double gpa)
    {
        super(firstName, lastName, address, id);
        this.gpa = gpa;
    }

    @Override
    public void display()
    {
        System.out.println(getFirstName() + " " + getLastName() + " "
                + getAddress() + " " + id + " " + gpa);
    }
}
