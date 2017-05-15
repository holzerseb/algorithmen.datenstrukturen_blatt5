import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BreadthFirstIterator implements Iterator<BinaryTreeNode>
{
    //Members
    private LinkedList<BinaryTreeNode> queue; //Linked list is basically a queue :^}

    //Constructor
    public BreadthFirstIterator(BinaryTreeNode root)
    {
        queue = new LinkedList<>();
        queue.add(root);
    }

    /* Methods */
    public boolean hasNext() { return !(queue.isEmpty()); }

    public BinaryTreeNode next() throws NoSuchElementException
    {
        if(queue.isEmpty()) throw new NoSuchElementException("There is no node anymore...");

        BinaryTreeNode currentNode = queue.remove(); //gets and removes

        //so, we have to prepare the following "next()" call, by checking if we have any childNodes to proceed
        if(currentNode.leftChild != null)
            queue.add(currentNode.leftChild);
        if(currentNode.rightChild != null)
            queue.add(currentNode.rightChild);

        return currentNode;
    }
}