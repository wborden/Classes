package visitors;

import java.util.List;
import java.util.ArrayList;
import components.DirectoryNode;
import components.FileNode;
import components.Node;

/**
 * Visitor for the directory and file nodes that collects the
 * names of all files that contain a given keyword.
 * @author spoudel
 *
 */
public class FindWithKeywordVisitor implements FileSystemVisitor {

    /**
     * Current keyword to search the files for.
     */
    private String currentKeyword;

    /**
     * List of file name for current search with
     * current keyword.
     */
    private List<String> fileList;

    /**
     * Default Constructor.
     */
    public FindWithKeywordVisitor() {
    }

    /**
     * Set new keyword for new search from this
     * visitor.
     * @param keyword new keyword to search from.
     */
    public void setNewSearchKeyword(String keyword) {
        this.currentKeyword = keyword;
        this.fileList = new ArrayList<String>();
    }

    /**
     * Get the search result with the currently set
     * keyword.
     * @return the list of filename containing the
     * currently set keyword.
     */
    public List<String> getSearchResult() {
        return this.fileList;
    }

    @Override
    public void visitFileNode(FileNode fileNode) {
        if (fileNode.getName().contains(this.currentKeyword)) {
            fileList.add(fileNode.getName());
        }
    }

    @Override
    public void visitDirectoryNode(DirectoryNode directoryNode) {
        for (Node node : directoryNode.getCurrentChildren()) {
            node.accept(this);
        }
    }

}
