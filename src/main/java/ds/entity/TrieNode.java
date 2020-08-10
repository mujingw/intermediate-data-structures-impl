package ds.entity;

import java.util.HashMap;
import java.util.Map;

public final class TrieNode {

    /**
     * Indicates whether the path ending at this TrieNode represents
     * a valid word.
     */
    private boolean isWord;

    /**
     * A map representation of the children of current TrieNode.
     */
    private final Map<Character, TrieNode> children;

    /**
     * Constructs a TrieNode object.
     */
    public TrieNode() {
        this.isWord = false;
        this.children = new HashMap<>();
    }

    /**
     *
     * @return isWord
     */
    public boolean isWord() {
        return this.isWord;
    }

    /**
     *
     * @param isWord indicates whether the path ending at the current
     *                    node represents a valid word
     */
    public void setIsWord(final boolean isWord) {
        this.isWord = isWord;
    }

    /**
     *
     * @return a map representation of the children of current TrieNode
     */
    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }
}
