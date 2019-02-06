package components;
import visitors.FileSystemVisitor;

/**
 * FileNode representing a file in FileSystem.
 * @author spoudel
 *
 */
public class FileNode implements Node {

    /**
     * Constructor for FileNode with the name for the file
     * represented by this node.
     * @param name name of the file.
     */
    public FileNode(final String name) {
        this.filename = name;
    }


    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFileNode(this);
    }


    /**
     * Return the name of the file.
     * @return the name of the file.
     */
    public String getName() {
        return this.filename;
    }

    /**
     * Name of the file represented by this node.
     */
    private String filename;


}
