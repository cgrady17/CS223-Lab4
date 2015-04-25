/*
  * @author Ericaceous Wood, Connor Grady, Amanda Starich, Owen Kirkeby
  * Date: 4.22.2015
  * Assignment: Lab 4
  * 
  * Read a text file and build an index of words found in the file.
  * Once done reading, display the list of words and the line number 
  * where they are found.
  * 
  * Sample output:
  * cat: 1
  * cow: 3, 4
  * jumps: 1
  * moo: 4
  * over: 2
  * the: 1, 2, 4
  */
public class Indexer
{
    // Binary search tree -- inOrderTraversal

    public int getLineNumber(TextFile<String> text, BinarySearchTree<String> bse)
    {
        // Split text by words
        String[] textArray = text.getText().split(" ");
        // Split text by line
        String[] lines = text.getText().split("\n");

        int numOfLines = lines.length;
        int numOfWords = textArray.length;

        for (String s : textArray)
        {
            bse.add(s);
        }

        for (int i=0; i < numOfLines; i++)
        {
            for (String aTextArray : textArray) {
                if (lines[i].contains(aTextArray)) {
                    int lineNumber = (i + 1);
                    System.out.println(bse.inOrderNodes() + " : " + lineNumber);
                }
            }

        }
        return numOfLines;
    }

    public static void main(String[] args)
    {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        // Create file
        TextFile<String> tf = new TextFile<String>("myFile.txt",
                "The cat jumps\n"
                        + "Over the\n"
                        + "Cow.\n"
                        + "The cow said moo.");
        Indexer in = new Indexer();
        System.out.println(in.getLineNumber(tf, bst));

    }
}
