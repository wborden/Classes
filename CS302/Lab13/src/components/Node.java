package components;
import visitors.FileSystemVisitor;

/**
 * Interface for representing any node in a File System. Date: 11-30-2014
 * @author spoudel
 */
public interface Node {

    /**
     * Accept the visitor for this Node.
     * @param visitor
     *            the visitor for the current node.
     */
    void accept(FileSystemVisitor visitor);

}
