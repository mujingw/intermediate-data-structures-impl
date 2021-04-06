package ds.impl;

import ds.UnionFind;

import java.util.Arrays;

public class UnionFindImpl implements UnionFind {

    /**
        Total number of disjoint sets in the current object.
     */
    private int count;
    /**
        An array representation of each node's parent.
     */
    private final int[] parent;
    /**
        An array representation of each disjoint set's rank.
     */
    private final int[] rank;

    /**
     *
     * @param size number of distinct elements in the disjoint set
     *             represented by the UnionFind object
     * @param initialNodes nodes to be created during object initialization
     */
    public UnionFindImpl(final int size, final int[] initialNodes) {
        this.parent = new int[size];
        this.rank = new int[size];
        this.count = 0;

        Arrays.fill(this.parent, -1);
        Arrays.fill(this.rank, 0);

        for (int node : initialNodes) {
            this.parent[node] = node;
            this.count++;
        }
    }

    /**
     *
     * @param i the node to query for
     * @return the root of node {@code i}
     */
    public int find(final int i) {
        if (this.parent[i] != i) {
            this.parent[i] = find(this.parent[i]);
        }

        return this.parent[i];
    }

    /**
     *
     * @param x the first element to be unionized
     * @param y the second element to be unionized
     */
    public void union(final int x, final int y) {
        int rootX = this.find(x);
        int rootY = this.find(y);

        if (rootX != rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                this.parent[rootY] = rootX;
            } else if (this.rank[rootY] > this.rank[rootX]) {
                this.parent[rootX] = rootY;
            } else {
                this.parent[rootY] = rootX;
                this.rank[rootX]++;
            }

            this.count--;
        }
    }

    /**
     *
     * @return the number of disjoint sets represented by the object
     */
    public int getCount() {
        return this.count;
    }
}
