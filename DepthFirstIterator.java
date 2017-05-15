import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DepthFirstIterator implements Iterator<BinaryTreeNode>
{
    //Members
    private Stack<BinaryTreeNode> stack;

    //Constructor
    public DepthFirstIterator(BinaryTreeNode root)
    {
        stack = new Stack<>();
        stack.push(root);
    }

    /* Methods */
    public boolean hasNext() { return !(stack.isEmpty()); }

    public BinaryTreeNode next() throws NoSuchElementException
    {
        if(stack.isEmpty()) throw new NoSuchElementException("There is no node anymore...");

        BinaryTreeNode currentNode = stack.pop();

        //so, we have to prepare the following "next()" call, by checking if we have any childNodes to proceed
        if(currentNode.rightChild != null)
            stack.push(currentNode.rightChild);
        if(currentNode.leftChild != null)
            stack.push(currentNode.leftChild);

        return currentNode;
    }
}