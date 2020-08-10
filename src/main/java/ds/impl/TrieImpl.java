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
