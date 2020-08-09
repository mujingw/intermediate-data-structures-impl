package ds.impl;

import ds.Trie;
import ds.entity.TrieNode;

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
        TrieNode iterator = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!iterator.getChildren().containsKey(ch)) {
                iterator.getChildren().put(ch, new TrieNode());
            }

            iterator = iterator.getChildren().get(ch);
        }

        iterator.setIsWord(true);

        return true;
    }

    /**
     *
     * @param word the word to be searched for
     * @return whether the word exists in the trie
     */
    @Override
    public boolean search(final String word) {
        TrieNode iterator = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!iterator.getChildren().containsKey(ch)) {
                return false;
            } else {
                iterator = iterator.getChildren().get(ch);
            }
        }

        return iterator.isWord();
    }

    /**
     *
     * @param prefix the prefix to be searched for
     * @return whether there is a word in the trie that starts with
     * the prefix passed in
     */
    @Override
    public boolean startsWith(final String prefix) {
        TrieNode iterator = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!iterator.getChildren().containsKey(ch)) {
                return false;
            } else {
                iterator = iterator.getChildren().get(ch);
            }
        }

        return true;
    }
}
