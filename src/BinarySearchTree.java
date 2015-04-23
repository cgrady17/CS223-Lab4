/**
 * @author thaoc
 *
 * This class represents a binary search tree.
 * Its find, add, delete method are binary search tree specific
 */
public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryFileTree<E>
{
    private boolean addReturn; //whether add was successful
    private E deletedItem; //the time that is deleeted.

    boolean add(E item)
    {
        root = add(root, item);
        return addReturn;
    }

    /**
     Recursively searching for a match
     -if a match is found, return false;
     -if no match is found, create a node with the item and return it.
     -if item is less than current node's data,
     assign the result of the add method to the left child.
     -otherwise, assign the result to the right child.
     */

    private Node<E> add(Node<E> n, E item)
    {
        if (n == null)
        {
            addReturn = true;
            return new Node<E>(item);
        } else if (item.compareTo(n.data) == 0)
        {
            addReturn = false;
            return n;
        }
        else if (item.compareTo(n.data) < 0)
        {
            n.leftChild = add(n.leftChild, item);
            return n;
        }
        else
        {
            n.rightChild = add(n.rightChild, item);
            return n;
        }
    }

    public E find(E target)
    {
        return find(target, root);
    }

    /**
     case 1:
     node is null, not found.
     target == node.data, found it.
     target < node.data, search left
     target > node.data, search right
     */
    private E find(E target, Node<E> node)
    {
        if (node == null)
        {
            return null;
        }
        int result = target.compareTo(node.data);
        if (result == 0)
        {
            return node.data;
        }
        if (result < 0)
        {
            return find(target, node.leftChild);
        }
        return find(target, node.rightChild);
    }

    public E delete(E target)
    {
        delete(root, target);
        return deletedItem;
    }

    /**
     1. item < node.data, search left.
     2. item > node.data, search right.
     3. item is not found, do nothing.
     4. item = node.data, delete it.
     if node has a single child, attach the child to node's parent
     if node has two children,
     replace node with the largest node in its left sub tree
     */
    private Node<E> delete(Node<E> n, E item)
    {
        if (n == null)
        {
            deletedItem = null;
            return n;
        }
        int compResult = item.compareTo(n.data);
        if (compResult < 0)
        {
            n.leftChild = delete(n.leftChild, item);
            return n;
        } else if (compResult > 0)
        {
            n.rightChild = delete(n.rightChild, item);
            return n;
        } else { //item is found, perform deletion
            deletedItem = n.data;
            //has a single child, replace parent with child
            if (n.leftChild == null)
            {
                return n.rightChild;
            } else if (n.rightChild == null)
            {
                return n.leftChild;
                //has two children, replace the largest node on
                //left subtree.
            }
            else
            {
                n.data = findLargestChild(n.leftChild);
                return n;
            }
        }
    }

    /**
     Return the largest child of the node parent
     which is the right most node in the left sub tree.
     */
    private E findLargestChild(Node<E> parent)
    {
        if (parent.rightChild.rightChild == null)
        {
            E value = parent.rightChild.data;
            parent.rightChild = parent.rightChild.leftChild;
            return value;
        }
        else
        {
            return findLargestChild(parent.rightChild);
        }
    }

    public static void main(String[] args)
    {

//		BinarySearchTree<String> bst = new BinarySearchTree<>();
//
//		String[] input = {
//				"removal", "also", "follows", "the", "search",
//				"algorithm", "except", "that", "when",
//				"the", "item", "is", "found"};
//
//		for (String s : input)
//		{
//			bst.add(s);
//		}
//
//		System.out.println("search for algorithm:" +
//				(bst.find("algorithm")!=null?"found" : "not found"));
//
//		System.out.println(bst);
//
//		bst.delete("item");
//		System.out.println("deleting item");
//		System.out.println(bst);
//
//		bst.delete("removal");
//		System.out.println("deleting removal");
//		System.out.println(bst);

    }

}
