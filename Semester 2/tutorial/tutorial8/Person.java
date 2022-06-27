package programming2.tutorial8;
/*
Write Java code to implement the following inheritance hierarchy. The two subclasses Student and Employee should override the display()
method. In Student, display() should show GPA and the other attributes in the super class. And in Employee, display() should show
the jobTitle and the other attributes in the super class.

Write a main program that should do the following:
1. Create an instance of class Student and an instance of class Employee with proper values for the attributes.
2. Display the content of each class using display() method.
Hint: You will need to call the get method of the superclass to access a private instance method
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String address;
    protected int id;

    Person()
    {
    }

    Person(String firstName, String lastName, String address, int id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public int getId()
    {
        return id;
    }

    public void display()
    {
        System.out.println(firstName + " " + lastName + " " + address + " " + id);
    }
}