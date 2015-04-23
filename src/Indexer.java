import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @author Ericaceous Wood, 
 * Date: 4.22.2015
 * Assignment: Lab 4
 * 
 * Read a text file and build an index of words found in the file.
 * Once done reading, display the list of words and the line number 
 * where they are found.
 * 
 * Sample output:
 * and: 1,2
 * cat: 1
 * cow: 2,
 * fiddle: 1
 * jump: 3
 * moon: 3
 * over: 3
 * the: 1,2,3
 */
public class Indexer
{
    // Binary search tree -- inOrderTraversal

    public int getLineNumber(TextFile<String> text, BinarySearchTree<String> bse)
    {
        int lineNumber = 0;
        String[] textArray = text.getText().split(" ");
        String[] lines = text.getText().split("\n");
        int numOfLines = lines.length;

        for (String s : textArray)
        {
            bse.add(s);
        }

        for(int i=0; i<numOfLines; i++)
        {
            for(int j=0; j<textArray.length; j++)
            {
                if(lines[i].contains(textArray[j]))
                {
                    System.out.println(lines[i] + " : " + textArray);
                }
            }

        }
        return numOfLines;
    }

    public static void main(String[] args)
    {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        // Create file
        TextFile<String> tf = new TextFile<String>("name.txt", "The cat and the fiddle\nand the cow\njump over the moon");
        Indexer in = new Indexer();
        System.out.println(in.getLineNumber(tf, bst));

    }
}