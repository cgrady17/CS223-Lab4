/*
 * @author Ericaceous Wood
 * Date: 3.30.2015
 * 
 * Organize fake file system.
 * Wrapper class that contains the root of the tree and the
 * set of operations that can be performed on a tree.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryFileTree<E>
{
    protected static class Node<E>
    {
        public E data;
        public Node<E> leftChild;
        public Node<E> rightChild;
        public Node(E data) { this.data = data; }
        public String toString() { return "" + data; }
    } // End nested Node<E> class

    protected Node<E> root;

    //********************************************************
    // Constructors
    //********************************************************
    public BinaryFileTree() { }

    public BinaryFileTree(Node<E> root)
    {
        this.root = root;
    }

    //********************************************************
    // preOrderNodes()
    // Order & Traversal Methods
    //	 / @return List<Node<E>> list
    //********************************************************
    public List<Node<E>> preOrderNodes()
    {
        List<Node<E>> list = new ArrayList<Node<E>>();
        preOrderTraverse(root, list);
        return list;
    } // End preOrderNodes()

    //********************************************************
    // preOrderTraverse(Node<E>, List<Node<E>>)
    // @param Node<E> n
    // @param List<Node<E>>list
    //********************************************************
    private void preOrderTraverse(Node<E> n, List<Node<E>> list)
    {
        // Base case: Empty nodes
        if (n == null) return;
        // Progress through children nodes
        // Adding nodes to list till empty nodes are reached
        list.add(n);
        preOrderTraverse(n.leftChild, list);
        preOrderTraverse(n.rightChild, list);
    } // End preOrderTraverse(Node<E>, List<Node<E>>)

    //********************************************************
    // inOrderNodes()
    // @return List<Node<E>> list
    //********************************************************
    public List<Node<E>> inOrderNodes()
    {
        List<Node<E>> list = new ArrayList<Node<E>>();
        inOrderTraverse(root, list);
        return list;
    } // End inOrderNodes()

    //********************************************************
    // inOrderTraverse(Node<E>, List<Node<E>>)
    // @param Node<E> n
    // @param List<Node<E>> list
    //********************************************************
    private void inOrderTraverse(Node<E> n, List<Node<E>> list)
    {
        // Base case: Empty nodes
        if (n == null) return;
        // Progress through children nodes
        // Adding nodes to list till empty nodes are reached
        inOrderTraverse(n.leftChild, list);
        list.add(n);
        inOrderTraverse(n.rightChild, list);
    } // End inOrderTraverse(Node<E>, List<Node<E>>)

    //********************************************************
    // postOrderNodes()
    // @return List<Node<E>> list
    //********************************************************
    public List<Node<E>> postOrderNodes()
    {
        List<Node<E>> list = new ArrayList<Node<E>>();
        postOrderTraverse(root, list);
        return list;
    } // End postOrderNodes()

    //********************************************************
    // postOrderTraverse(Node<E>, List<Node<E>>)
    // @param Node<E> n
    // @param List<Node<E>> list
    //********************************************************
    private void postOrderTraverse(Node<E> n, List<Node<E>> list)
    {
        // Base case: Empty nodes
        if (n == null) return;
        // Progress through children nodes
        // Adding nodes to list till empty nodes are reached
        postOrderTraverse(n.leftChild, list);
        postOrderTraverse(n.rightChild, list);
        list.add(n);
    } // postOrderTraverse()

    //********************************************************
    // toString()
    // @return String object.toString()
    //********************************************************
    @SuppressWarnings("rawtypes")
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        List<Node<E>> nodes = preOrderNodes();
        for(Node n : nodes) sb.append(n.data.toString());
        return sb.toString();
    } // End toString()

    //********************************************************
    // displayHelper(Node<E>, int)
    // @param Node<E> n
    // @param int indent
    //********************************************************
    private void displayHelper(Node<E> n, int indent)
    {
        if (n == null)
        {
            System.out.printf("%" + indent + "s\n", "null");
            return;
        }

        System.out.printf("%" + indent + "s\n", n);
        displayHelper(n.leftChild, indent + 3);
        displayHelper(n.rightChild, indent+ 3);
    } // End displayHelper(Node<E>, int)

    //********************************************************
    // Display()
    //********************************************************
    public void display()
    {
        // Display root with 3 indents
        displayHelper(root, 3);
    } // End display()

    //********************************************************
    // read(String)
    // @param input
    // @return BinaryTree<String>(readHelper(Scanner))
    //********************************************************
    public static BinaryFileTree<String> read(String input)
    {
        Scanner s = new Scanner(input);
        return new BinaryFileTree<String>(readHelper(s));
    } // End read(input)

    //********************************************************
    // readHelper(Scanner)
    // @param s
    // @return Node<String> n
    //********************************************************
    private static Node<String> readHelper(Scanner s)
    {
        if (!s.hasNext()) return null;
        String data = s.next();
        if (data.equals("null")) return null;
        Node<String> n =  new Node<String>(data);
        n.leftChild = readHelper(s);
        n.rightChild = readHelper(s);
        return n;
    } // End readHelper(Scanner)

    //********************************************************
    // Main
    // @param args
    //********************************************************
    public static void main(String[] args)
    {
        // Add BinaryTree Nodes
        BinaryFileTree<String> tree = BinaryFileTree.read("a b null null c d null null null");
        tree.display();
        System.out.println("preorder : " + tree.preOrderNodes());
        System.out.println("inorder  : " + tree.inOrderNodes());
        System.out.println("postorder: " + tree.postOrderNodes());
    }

}