package programming2.tutorial8;

public class Employee extends Person
{
    private String jobTitle;

    public Employee(String firstName, String lastName, String address, int id, String jobTitle)
    {
        super(firstName, lastName, address, id);
        this.jobTitle = jobTitle;
    }

    @Override
    public void display()
    {
        System.out.println(getFirstName() + " " + getLastName() + " "
                + getAddress() + " " + id + " " + jobTitle);
    }
}