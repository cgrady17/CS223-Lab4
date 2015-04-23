/*
        * @author Ericaceous Wood
        * Date: 3.30.2015
        *
        * This class can track its current directory, its parent
* directory and files in this directory (in case this file
        * is a special file called directory.)
        *
        * Provide the template for Directory nodes which will become directories and textfiles.
        *
        */

//**************************************************************************************
// File Abstract Class
//**************************************************************************************
@SuppressWarnings("hiding")
abstract class File<String>
{
    //********************************************************
    // File Class Members
    //********************************************************
    private String name;
    private Directory<String> parent;
    //private Directory<String> child;
    //private Directory<String> current;
    //private boolean isDirectory;
    //private File<String> childFile;
    //private File<String> currentFile;
    //public ArrayList<File<String>> files;
    public static int counter = 0;

    //********************************************************
    // File Constructors (Abstract?)
    //********************************************************
    public File() { }
    public File(String name) { this.name = name; counter++; }

    // TODO for ls -a (if using)
    // public boolean isHidden() { if f.charAt(0) == '.' }

    //********************************************************
    // getName()
    //********************************************************
    // @return File name
    //********************************************************
    public String getName()
    {
        return name;
    }

    // if (child == null) return true;
    // else return false;

    public void setParent(Directory<String> parent)
    { this.parent = parent; }

    //********************************************************
    // getParent()
    //********************************************************
    // @return Directory parent name
    // $ cd..
    //********************************************************
    public Directory<String> getParent() { return parent; }

    //********************************************************
    // isFile()
    // @return boolean
    // Returns true if is TextFile
    //********************************************************
    abstract public boolean isFile();

    public boolean isDirectory()
    {
        return !isFile();
    }

    //********************************************************
    // getPath()
    //********************************************************
    // @return String
    //********************************************************
    //@SuppressWarnings("unchecked")
    public abstract String getPath();

    // Compute path recursively (call getPath())
    //Directory<String> d = new Directory<String>((String) "\\");
    //StringBuilder sb = new StringBuilder();
    //sb.append(this);
    //return sb.toString();
    // return (this.getPath())

    // End getPath()

} // End File abstract class