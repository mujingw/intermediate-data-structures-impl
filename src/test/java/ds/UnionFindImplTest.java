package ds;

import ds.impl.UnionFindImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnionFindImplTest {

    private UnionFind uf;

    @Before
    public void setUp() {
        this.uf = new UnionFindImpl(5, new int[]{1, 2, 3, 4});
    }

    @Test
    public void initializationTest() {
        Assert.assertEquals(4, this.uf.getCount());
    }

    @Test
    public void unionTest() {
        this.uf.union(1, 2);
        this.uf.union(3, 2);
        this.uf.union(1, 4);

        Assert.assertEquals(1, uf.getCount());
    }

    @Test
    public void findTest() {
        Assert.assertEquals(1, this.uf.find(1));
        Assert.assertEquals(2, this.uf.find(2));
        Assert.assertEquals(3, this.uf.find(3));
    }
}
