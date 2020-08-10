package ds;

import ds.impl.LRUCacheImpl;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheImplTest {

    @Test
    public void cachePutTest() {
        LRUCache<Integer, Integer> lruCache = new LRUCacheImpl<>(100);

        Integer oldValue1 = lruCache.put(1, 1);
        Integer oldValue2 = lruCache.put(2, 2);
        Integer oldValue3 = lruCache.put(1, 3);

        Assert.assertEquals(2, lruCache.size());
        Assert.assertNull(oldValue1);
        Assert.assertNull(oldValue2);
        Assert.assertEquals(Integer.valueOf(1), oldValue3);
    }

    @Test
    public void cacheGetTest() {
        LRUCache<Integer, Integer> lruCache = new LRUCacheImpl<>(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        Assert.assertEquals(Integer.valueOf(1), lruCache.get(1));

        lruCache.put(3, 3);

        Assert.assertNull(lruCache.get(2));

        lruCache.put(4, 4);

        Assert.assertNull(lruCache.get(1));

        Assert.assertEquals(Integer.valueOf(3), lruCache.get(3));
        Assert.assertEquals(Integer.valueOf(4), lruCache.get(4));
    }

    @Test
    public void overwriteGetTest() {
        LRUCache<Integer, Integer> lruCache = new LRUCacheImpl<>(2);

        lruCache.put(3, 3);
        lruCache.put(3, 33);

        Assert.assertEquals(Integer.valueOf(33), lruCache.get(3));
    }
}
