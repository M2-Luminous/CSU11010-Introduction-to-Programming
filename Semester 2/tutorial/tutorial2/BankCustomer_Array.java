package programming2.tutorial2;
/*
Part1:

Update the BankCustomer class creating an array storing data of type bankCustomerArray and add your BankCustomer to this array.

Part2:

The Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

1.Only one disk can be moved at a time
2.Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack
3.No disk may be placed on top of a smaller disk
Write a Java program that asks the user to input the number of disks and implements a recursive function to implement your solution.


 */
class BankCustomer
{
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private int customerDateOfBirth;

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accNumber)
    {
        accountNumber = accNumber;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String name)
    {
        customerName = name;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(String address)
    {
        customerAddress = address;
    }

    public int getCustomerDateOfBirth()
    {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(int dob)
    {
        customerDateOfBirth = dob;
    }

    public static void main(String[] args)
    {
        /* Create an array that can hold reference to 10
           BankCustomer objects. Does not create the objects */
        BankCustomer[] bankCustomers = new BankCustomer[10];

        // Instantiate the objects
        for(int i=0; i<bankCustomers.length; i++)
            bankCustomers[i] = new BankCustomer();

        bankCustomers[0].setAccountNumber(12345);

        System.out.println("Customer Account Number is " + bankCustomers[0].getAccountNumber());
    }
}