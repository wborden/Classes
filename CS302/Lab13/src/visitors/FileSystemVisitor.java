package visitors;
import components.DirectoryNode;
import components.FileNode;

/**
 * Visitor interface to visit different nodes in FileSystem.
 * @author spoudel
 *
 */
public interface FileSystemVisitor {

    /**
     * Visit the provided FileNode.
     * @param fileNode the file node to be visited.
     */
    void visitFileNode(FileNode fileNode);

    /**
     * Visit the provided DirectoryNode.
     * @param directoryNode the directory node to be
     * visited.
     */
    void visitDirectoryNode(DirectoryNode directoryNode);

}
