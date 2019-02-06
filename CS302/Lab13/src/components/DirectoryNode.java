package components;

import java.util.ArrayList;
import java.util.List;

import visitors.FileSystemVisitor;

/**
 * DirectoryNode representing directory in FileSystem.
 * @author spoudel
 *
 */
public class DirectoryNode implements Node {

    /**
     * Constructor for constructing DirectoryNode with its name
     * and list of other nodes that it contains.
     * @param name name of the directory.
     * @param children contents of this directory.
     */
    public DirectoryNode(String name, List<Node> children) {
        
        this.currentChildren = new ArrayList<Node>();
        this.currentChildren.addAll(children);
        this.directoryname = name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {

        visitor.visitDirectoryNode(this);
    }

    /**
     * Get the name of this directory.
     * @return the name of this directory.
     */
    public String getName() {
        return this.directoryname;
    }

    /**
     * Get the current content of this directory.
     * @return the list of nodes this directory holds.
     */
    public List<Node> getCurrentChildren() {
        return this.currentChildren;
    }

    /**
     * Add new content to this directory.
     * @param node content to be added.
     */
    public void addNode(Node node) {
        this.currentChildren.add(node);
    }

    /**
     * Name of the directory this node holds.
     */
    private String directoryname;

    /**
     * Contents of this directory as list of nodes. Nodes
     * can be either a DirectoryNode or FileNode.
     */
    private List<Node> currentChildren;

}
