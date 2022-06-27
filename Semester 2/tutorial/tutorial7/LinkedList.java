package programming2.tutorial7;

public class LinkedList
{
    private int listCount;
    private Node head;

    public LinkedList()
    {
        head = new Node();//initialising a constructor
        listCount = 0;//set the private int
    }

    public void add(int data)
    {
        Node newNode = new Node(data);//initialising an object
        Node currentNode = head;//assigning value

        while (currentNode.getNextNode() != null)
        {
            currentNode = currentNode.getNextNode();   //检测如果没有到达链表末尾就一直循环获取下一个节点数字,直到检测到null,即末尾
        }

        currentNode.setNextNode(newNode);//在末尾加入需要添加的数字
        listCount++;//为size()做准备
    }

    public void insert(int data, int index)
    {
        if (index <= listCount && index > 0)//起手一个错误检测
            //listCount means the size of the arraylist
        {
            Node newNode = new Node(data);//setting object
            Node currentNode = head;//把第一位节点数字获取出来先

            for (int i = 1; i < index; i++)
            {
                currentNode = currentNode.getNextNode();//先通过一手循环从开头(currentNode->head)不断往下一个节点数字读取,一直读取到我们需要insert数据
            }

            newNode.setNextNode(currentNode.getNextNode());//读取到对应index的前一位时,只需要往下一位(index+1)填充好想要insert的节点数字即可
            currentNode.setNextNode(newNode);
            listCount++;//继续为size()做准备
        }
    }

    public Node get(int index)
    {
        if (index > listCount || index <= 0)//error detection
            return null;

        Node currentNode = head;//get the first index of element again

        for (int i = 1; i <= index; i++)
        {
            currentNode = currentNode.getNextNode();//和上一个insert的方法有异曲同工之妙,不过在此时我们只需要用<=号直接获取index的内容并return就好了
        }
        return currentNode;
    }

    public boolean remove(int index)
    {
        if (index > listCount || index <= 0)//error detection again
            return false;

        Node currentNode = head;//get the first index of element again

        for (int i = 0; i < index - 2; i++)
        {
            currentNode = currentNode.getNextNode();//assign the value for the replacement functionality below
        }

        currentNode.setNextNode(currentNode.getNextNode().getNextNode());//直接获取相应想要移除的index的下一位数字并且将这一位数字覆盖到想要移除的数字上即可
        listCount--;//还是为size()做准备
        return true;
    }

    public int size()
    {
        return listCount;//通过前面几个method的准备以直接获取到正确的count数值--即表示链表的确切元素个数
    }
}