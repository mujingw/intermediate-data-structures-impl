package ds.impl;

import ds.Trie;
import ds.entity.TrieNode;

import java.util.Map;

public final class TrieImpl implements Trie {

    /**
     * Root of the trie.
     */
    private final TrieNode root;

    /**
     * Constructs a TrieImpl object.
     */
    public TrieImpl() {
        this.root = new TrieNode();
    }

    /**
     *
     * @param word the word to be added
     * @return whether the word has been added to the trie successfully
     */
    @Override
    public boolean add(final String word) {
        TrieNode currNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> childNodes = currNode.getChildren();

            if (!childNodes.containsKey(ch)) {
                childNodes.put(ch, new TrieNode());
            }

            currNode = childNodes.get(ch);
        }

        currNode.setIsWord(true);

        return true;
    }

    /**
     *
     * @param word the word to be searched for
     * @return whether the word exists in the trie
     */
    @Override
    public boolean search(final String word) {
        TrieNode currNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> childNodes = currNode.getChildren();

            if (!childNodes.containsKey(ch)) {
                return false;
            } else {
                currNode = childNodes.get(ch);
            }
        }

        return currNode.isWord();
    }

    /**
     *
     * @param prefix the prefix to be searched for
     * @return whether there is a word in the trie that starts with
     * the prefix passed in
     */
    @Override
    public boolean startsWith(final String prefix) {
        TrieNode currNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Map<Character, TrieNode> childNodes = currNode.getChildren();

            if (!childNodes.containsKey(ch)) {
                return false;
            } else {
                currNode = childNodes.get(ch);
            }
        }

        return true;
    }
}
