package ds;

import ds.impl.TrieImpl;
import org.junit.Assert;
import org.junit.Test;

public class TrieImplTest {

    @Test
    public void addTest() {
        Trie trie = new TrieImpl();

        Assert.assertTrue(trie.add("leetcode"));
        Assert.assertTrue(trie.add("apple"));

        Assert.assertFalse(trie.search("leet"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.search("leetcode"));
        Assert.assertTrue(trie.search("apple"));

        Assert.assertTrue(trie.add("app"));
        Assert.assertTrue(trie.search("app"));
    }

    @Test
    public void searchTest() {
        String word = "leetcode";
        Trie trie = new TrieImpl();
        trie.add(word);

        boolean isWordFound = trie.search(word);

        Assert.assertTrue(isWordFound);
    }

    @Test
    public void startsWithTest() {
        String word = "leetcode";
        String prefix = "leet";
        Trie trie = new TrieImpl();
        trie.add(word);

        boolean doesPrefixExist = trie.startsWith(prefix);

        Assert.assertTrue(doesPrefixExist);
    }
}
