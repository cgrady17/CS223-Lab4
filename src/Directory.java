import java.util.ArrayList;
/*
 * @author Ericaceous Wood
 * Date: 3.30.2015
 * 
 * Directory node class.
 * Everything regarding child.
 * 
 * Directory.child != null, always (EMPTY "", never null)
 * Directory.parent == null ONLY when root, otherwise
 * 		Directory.parent != null (subdirectories)
 */

//**************************************************************************************
//Directory Class
//**************************************************************************************
@SuppressWarnings("hiding")
class Directory<String> extends File<String>
{
    //********************************************************
    // Directory Class Members
    //********************************************************
    protected ArrayList<File<String>> files = new ArrayList<File<String>>();
    private String name;
    private Directory<String> parent;
    private Directory<String> current;

    //********************************************************
    // Directory Constructor
    //********************************************************
    Directory(String name) { super(name); }

    // No two files in the same directory may share a name.
    // File names can be specified using absolute or relative name
    // (absolute: all ancestors up to /. relative: ancestors up till current dir)
    // .. = parent directory
    // . = current directory

    //********************************************************
    // getFileName()
    //********************************************************
    // @return String name
    // Retrieves textfile name
    //********************************************************
    public String getName() { return this.name; }

    //********************************************************
    // isFile()
    //********************************************************
    @Override
    public boolean isFile() { return false; }

    //********************************************************
    // isDirectory()
    //********************************************************
    // @return whether file is directory
    //********************************************************
    public boolean isDirectory(Directory<String> file)
    {
        return !isFile();
    }

    //********************************************************
    // hasChildren()
    //********************************************************
    // @return whether directory has children
    //********************************************************
    public boolean hasChildren()
    {
        return (getChildren() != null);
    }

    //********************************************************
    // getChildren()
    //********************************************************
    // @return ArrayList<File>
    // ls
    //********************************************************
    public ArrayList<File<String>> getChildren()
    {
        return files;
    } // End getChildren()

    //********************************************************
    // getParent()
    //********************************************************
    // @return Directory parent
    // $ cd..
    //********************************************************
    public Directory<String> getParent() { return parent; }

    //********************************************************
    // setParent()
    //********************************************************
    // $cd
    // Changes parent node (TODO needed?)
    //********************************************************
    public void setParent(Directory<String> parent)
    { this.parent = parent; }

    //********************************************************
    // addChild(File)
    //********************************************************
    // $mkdir or $edit ($edit is like touch, except no timestamp updates)
    //********************************************************
    public void addChild(File<String> f)
    {
        // Sort
        // Tree traversal

        // preorder(root)
        // if(root == null) return; (base case)
        // visit(root)
        // preorder(root.left)
        // preorder(root.right)

        // Check for duplicates
        int counter = 0;
        for (int i = 0; i < files.size(); i++)
        {
            if (files.toString().equals(files.get(i).toString()))
            {
                System.out.println("File already exists");
                counter++;
            }
        }
        if (counter <= 0)
        {
            files.add(f);
        }

    } // End addChild(File)

    //********************************************************
    // removeChild(File)
    //********************************************************
    // $mkdir or $edit ($edit is like touch, except no timestamp updates)
    //********************************************************
    public void removeChild(File<String> f)
    {
        // TODO if (directory/file !hasChildren())
        int counter = 0;
        for (int i = 0; i < files.size(); i++)
        {
            if (f.toString().equals(files.get(i).toString()))
            {
                files.remove(files.get(i));
                counter++;
            }
        }
        if (counter <= 0)	// If no occurence is found
        {
            System.out.println("File to delete does not exist.");
        }
        // TODO else { System.out.println("Directory is not empty.
        // Try -r argument."); }
    }

    //********************************************************
    // setCurrent()
    //********************************************************
    // $cd
    // Changes current node
    //********************************************************
    public void setCurrent(Directory<String> current)
    { this.current = current; }

    //********************************************************
    // getCurrent()
    //********************************************************
    // @return Current directory
    // $ pwd
    //********************************************************
    public Directory<String> getCurrent() { return current; }

    //********************************************************
    // toString()
    //********************************************************
    // @return whether directory has children
    //********************************************************
    public java.lang.String toString()
    {
        return (java.lang.String) (name.toString());
    } // End toString()

    //********************************************************
    // getPath()
    //********************************************************
    //
    //********************************************************
    @Override
    public String getPath()
    {
        // Compute path recursively (call getPath())
        Directory<String> d = new Directory<String>((String) "\\");
        StringBuilder sb = new StringBuilder();
        sb.append(this);

        return (String) sb.toString();
        // return (this.getPath());
    } // End getPath()

} // End Directory class