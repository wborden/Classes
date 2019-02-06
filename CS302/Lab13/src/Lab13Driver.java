import java.util.ArrayList;
import java.util.List;
import java.io.File;

import visitors.FindWithKeywordVisitor;
import components.DirectoryNode;
import components.FileNode;
import components.Node;

/**
 * Driver program to test the visitor pattern.
 * @author spoudel
 *
 */
public final class Lab13Driver {

    /**
     * Default private constructor.
     */
    private Lab13Driver() {

    }

    /**
     * Main method of the driver.
     * @param args arguments passed to application.
     */
    public static void main(String[] args) {
        DirectoryNode node = getTestDirectoryNode();
        FindWithKeywordVisitor findVisitor = new FindWithKeywordVisitor();
        findVisitor.setNewSearchKeyword("11");
        node.accept(findVisitor);
        System.out.println(findVisitor.getSearchResult());
    }

    /**
     * Get {@link DirectoryNode} for test.
     * @return the test directory node.
     */
    private static DirectoryNode getTestDirectoryNode() {
        File file = new File("Root");
        DirectoryNode root = getDirectoryNode(file);
        return root;
    }

    /**
     * Return the {@link FileNode} for this file.
     * @param file file in the File System.
     * @return the FileNode for this file.
     */
    private static FileNode getFileNode(File file) {
        return new FileNode(file.getName());
    }

    /**
     * Return the {@link DirectoryNode} for this file.
     * @param directory directory in the File System.
     * @return the DirectoryNode for this directory.
     */
    private static DirectoryNode getDirectoryNode(File directory) {
        List<Node> contents = new ArrayList<Node>();
        for (File fileIter:directory.listFiles()) {
            if (fileIter.isDirectory()) contents.add(getDirectoryNode(fileIter));
            else contents.add(getFileNode(fileIter));
        }
        return new DirectoryNode(directory.getName(), contents);
    }
}
