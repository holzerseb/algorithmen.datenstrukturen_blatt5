import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        /* #### TASK 1 #### */
        BinaryTreeNode root = CreateNode();
        root.leftChild = CreateNode();
        root.rightChild = CreateNode();
        root.leftChild.leftChild = CreateNode();
        root.leftChild.rightChild = CreateNode();
        root.rightChild.leftChild = CreateNode();
        root.rightChild.rightChild = CreateNode();
        root.leftChild.leftChild.leftChild = CreateNode();
        root.rightChild.leftChild.leftChild = CreateNode();
        /* Looks like this:
                    x
                x       x
              x   x   x   x
            x		 x
        */

        System.out.println("######");
        System.out.println("How the Tree looks like currently");
        System.out.println("######");
        PrintBinaryTree(root);
        System.out.println("");
        System.out.println("######");
        System.out.println("Depth First");
        System.out.println("######");
        PrintBinaryTreeDepthFirst(root);
        System.out.println("");
        System.out.println("######");
        System.out.println("Breadth First");
        System.out.println("######");
        PrintBinaryTreeBreadthFirst(root);
    }

    private static BinaryTreeNode CreateNode()
    {
        BinaryTreeNode node = new BinaryTreeNode();
        node.leftChild = null;
        node.rightChild = null;
        node.data = (int)(Math.random() * 1000); //random int between 0 and 1000
        return node;
    }


    //Printer
    private static void PrintBinaryTree(BinaryTreeNode root)
    {
        BTreePrinter.printNode(root);
    }

    private static void PrintBinaryTreeDepthFirst(BinaryTreeNode root)
    {
        DepthFirstIterator depthFirstIterator = new DepthFirstIterator(root);

        System.out.println("Printing BinaryTree in PreOrder:");
        while(depthFirstIterator.hasNext())
        {
            System.out.println(depthFirstIterator.next().data);
        }
    }

    private static void PrintBinaryTreeBreadthFirst(BinaryTreeNode root)
    {
        BreadthFirstIterator breadthFirstIterator = new BreadthFirstIterator(root);

        System.out.println("Printing BinaryTree in Breadth First Order:");
        while(breadthFirstIterator.hasNext())
        {
            System.out.println(breadthFirstIterator.next().data);
        }
    }
}
