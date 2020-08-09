package ds;

public interface Trie {
    /**
     * @param word word the be added
     * @return whether or not the word has been added to the trie successfully
     */
    boolean add(String word);

    /**
     * @param word to be searched for
     * @return whether or not the word is found in the trie
     */
    boolean search(String word);

    /**
     * @param prefix prefix to be searched for
     * @return whether or not there is a word in the trie that
     * starts with the prefix passed in
     */
    boolean startsWith(String prefix);
}
