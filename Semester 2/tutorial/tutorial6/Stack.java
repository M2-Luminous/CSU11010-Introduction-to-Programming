package programming2.tutorial6;

import java.util.ArrayList;

public class Stack
{
    private ArrayList<Integer> stack;

    Stack()
    {
        stack = new ArrayList<Integer>();//creating an constructor
    }

    public void push(int element)//implementing a push function
    {
        stack.add(element);//add the element into the arraylist we set already
    }

    public void pop()//implementing a pop function
    {
        if (stack.isEmpty())
            System.out.println("Stack is empty");//error detection

        stack.remove(0);//remove the top of the element in the stack, which means remove the first element in arraylist
        System.out.printf("Pop: ");
        printStack();//reveals previously concealed items
    }

    public int peek()//implementing a peek function
    {
        int sizeOfStack;

        sizeOfStack = stack.size();//get the length of the arraylist

        if (sizeOfStack>=1)
            return(stack.get(sizeOfStack-1));//the last item's index is the length of the arraylist minus one

        return(-1);//if sizeOfStack is less than 1, the program returns -1

    }

    public int search(int element)
    {
        return(stack.indexOf(element));//find the position of the element in stack arraylist
        //automatically return -1 if there isn't exist a number in that index
    }

    public Boolean move(int element)//move an element to the top of the stack without removing it from the stack
    {
        int pos, tmp1, tmp2;
        pos = search(element);

        if (pos == -1)
        {
            System.out.println("Move: Element does not exist in the stack");
            return(false);
        }

        while (pos>0)//if there exist an element in that index
        {
            tmp1 = stack.get(pos);
            tmp2 = stack.get(pos-1);
            stack.set(pos-1, tmp1);
            stack.set(pos, tmp2);
            pos--;//switch the index of the data for several times until target reaches the top of the stack(arraylist)
        }

        return(true);
    }

    public void printStack()
    {
        for (Integer item: stack)
            System.out.printf("%d ", item);//using a for loop to check all the elements in the stack arraylist and print them
        System.out.println();
    }
}
