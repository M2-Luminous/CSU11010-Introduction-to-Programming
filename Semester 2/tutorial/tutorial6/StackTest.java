package programming2.tutorial6;
/*
A Stack is a last in, first out (LIFO) linear data structure and can have any object as an element.
It is characterized by three fundamental operations namely: push, pop and peek.

The push operation adds a new item (taken as a parameter) to the top of the stack. It extends the stack to accommodate the new item.
The pop operation removes an item from the top of the stack. A pop reveals previously concealed items or results in an empty stack.
If the stack is empty when a pop operation is attempted, then an error condition is raised.
The peek operation returns the last item in a stack without removing it. If the stack is empty, then the return value is -1.
Create a Java class (Stack.java) that implements a LIFO stack to store integers with the appropriate accessor and mutator methods.
Your code should store the stack elements in an ArrayList and should not make use of a stack class from a class library.
 Stack.java should implement the functions push(), pop() and peek().

Additionally, implement a method search (Object element) which determines whether an object exists in the stack.
If the element is found, it returns the position of the element from the top of the stack. Else, it returns -1.

Also implement a method move (Object element) to move an element to the top of the stack without removing it from the stack.
It should make use of the search() method to determine if the element exists in the stack.

Finally, implement a test application (StackTest.java) that demonstrates the correct operation of the stack functions.
StackTest.java creates a Stack object, inserts the numbers from 1 to 10 into the stack using push(),
and calls pop(), peek(), search() & move() passing in elements of your choice where applicable and printing the output.
User input in not required in this program.
 */
import java.util.Scanner;

public class StackTest
{
    public static void main(String[] args)
    {
        int element, pos;
        Boolean success;

        // Create a stack object
        Stack myStack = new Stack();

        // Initialize the stack
        System.out.print("Please enter an element and terminate by entering 0: ");
        Scanner input = new Scanner(System.in);
        element = input.nextInt();
        while (element !=0)//check whether the element is 0 or not first
        {
            myStack.push(element);//push the element onto the stack
            System.out.print("Please enter an element and terminate by entering 0: ");
            element = input.nextInt();
        }

        // Print the elements in the stack
        myStack.printStack();

        // Pop: Remove an element from the top of the stack
        myStack.pop();

        // Peek: Print the last element in the stack
        element = myStack.peek();
        if (element != -1)
            System.out.println("Peek: " + element);//error detection

        // Search: Search for a specific element in the stack
        System.out.print("Please enter the element to search in the stack: ");
        input = new Scanner(System.in);
        element = input.nextInt();
        pos = myStack.search(element);
        if (pos == -1)
            System.out.println("Search: Element does not exist in the stack");
        else
            System.out.println("Search: Element at position " + pos);

        // Move: Move an element to the top of the stack without removing it from the stack
        System.out.print("Please enter the element to move to the top of the stack: ");
        input = new Scanner(System.in);
        element = input.nextInt();
        success = myStack.move(element);
        if(success)//the move function return's a boolean result
        {
            System.out.printf("Move: ");
            myStack.printStack();
        }
    }
}
