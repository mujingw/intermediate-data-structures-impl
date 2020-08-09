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
        String word1 = "leetcode";
        String word2 = "lemon";
        Trie trie = new TrieImpl();
        trie.add(word1);

        boolean found1 = trie.search(word1);
        boolean found2 = trie.search(word2);

        Assert.assertTrue(found1);
        Assert.assertFalse(found2);
    }

    @Test
    public void startsWithTest() {
        String word = "leetcode";
        String prefix1 = "leet";
        String prefix2 = "fleet";
        Trie trie = new TrieImpl();
        trie.add(word);

        boolean doesPrefixExist1 = trie.startsWith(prefix1);
        boolean doesPrefixExist2 = trie.startsWith(prefix2);

        Assert.assertTrue(doesPrefixExist1);
        Assert.assertFalse(doesPrefixExist2);
    }
}
