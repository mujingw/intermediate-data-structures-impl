package ds;

public interface UnionFind {

    /**
     *
     * @param i the node whose root needs to be found
     * @return the root of node {@code i}
     */
    int find(int i);

    /**
     *
     * @param x the first element to be merged
     * @param y the second element to be merged
     */
    void union(int x, int y);

    /**
     *
     * @return the number of disjoint sets in the UnionFind object
     */
    int getCount();
}
