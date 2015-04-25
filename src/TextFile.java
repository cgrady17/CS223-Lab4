/*
 * @author Ericaceous Wood
 * Date: 3.30.2015
 * 
 * TextFile leaf node class.
 * These files have no reference to other objects.
 * TextFile.child == null, always
 * TextFile.parent != null, always
 */

//**************************************************************************************
//TextFile Class
//**************************************************************************************
@SuppressWarnings("hiding")
public class TextFile<String> extends File<String>
{
    //********************************************************
    // TextFile Class Members
    //********************************************************
    private String name;	// File name
    private String text;	// File content
    //private ArrayList<File<String>> files = new ArrayList<>();

    //********************************************************
    // TextFile Constructor
    //********************************************************
    // Creates TextFile object with given file name & contents
    //********************************************************
    TextFile(String name, String text) { super(name); this.text = text; }
    @SuppressWarnings("unchecked")
    TextFile(String name) { super(name); new TextFile<String>(name, (String) ""); } // Empty textfile

    //********************************************************
    // getFileName()
    //********************************************************
    // @return String name
    // Retrieves textfile name
    //********************************************************
    public String getName() { return name; }

    //********************************************************
    // getText()
    //********************************************************
    // @return String content
    // Retrieves textfile contents
    //********************************************************
    public String getText() { return text; }

    //********************************************************
    // setText()
    //********************************************************
    // @param String content
    // Creates textfile contents
    //********************************************************
    public void setText(String text) { this.text = text; }

    //********************************************************
    // isFile()
    //********************************************************
    // @return boolean
    // Returns true if is TextFile
    //********************************************************
    public boolean isFile()
    {
        return true; // always a textfile
    } // End isFile()

    //********************************************************
    // removeFile(TextFile tf)
    //********************************************************
    /*public void removeFile(TextFile<String> tf)
    {
        if (tf.isFile())
        {
            int counter = 0;
            for (int i = 0; i < files.size(); i++)
            {
                if (tf.toString().equals(files.get(i).toString()))
                {
                    files.remove(files.get(i));
                    counter++;
                }
            }
            if (counter <= 0)	// If no occurence is found
            {
                System.out.println("File to delete does not exist.");
            }
        }
    } // End removeFile(TextFile)*/

    //********************************************************
    // getPath()
    //********************************************************
    @Override
    public String getPath()
    {
        return null;
    }

} // End TextFile class