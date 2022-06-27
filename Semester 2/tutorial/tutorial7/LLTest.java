package programming2.tutorial7;

public class LLTest
{

    public static void main(String[] args)
    {
        LinkedList lnklist = new LinkedList();
        lnklist.add(1);
        lnklist.add(2);
        lnklist.add(3);
        lnklist.add(4);
        lnklist.add(5);

        System.out.println("All the Nodes available in the List : ");
        DisplayList(lnklist);

        lnklist.insert(10, 3);
        System.out.println("All the Nodes available in the List : ");
        DisplayList(lnklist);

        lnklist.remove(1);
        lnklist.remove(4);
        System.out.println("All the Nodes available in the List : ");
        DisplayList(lnklist);

        Node tmp = lnklist.get(4);
        System.out.println("Contents of node are "+ tmp.getData());

        System.out.println("Number Of Nodes in the List: " + lnklist.size());
    }

    public static void DisplayList(LinkedList ll)
    {
        for (int i = 1; i <= ll.size(); i++) {
            System.out.println(i + " : " + ll.get(i).getData());
        }
    }
}