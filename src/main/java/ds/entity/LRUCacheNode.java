package ds.entity;

public class LRUCacheNode<K, V> extends ListNode<V> {

    /**
     * The actual information that the LRUCache stores.
     */
    private K cacheKey;

    /**
     *
     * @param cacheKey key of the key-value pair which the LRUCache stores
     * @param value value of the key-value pair which the LRUCache stores
     */
    public LRUCacheNode(final K cacheKey, final V value) {
        super(value);

        this.cacheKey = cacheKey;
    }

    /**
     *
     * @param cacheKey the new value to be assigned to the current node
     */
    public void setCacheKey(final K cacheKey) {
        this.cacheKey = cacheKey;
    }

    /**
     *
     * @return the auxValue in the node
     */
    public K getCacheKey() {
        return this.cacheKey;
    }

    /**
     *
     * @return the next node of current node
     */
    @Override
    public LRUCacheNode<K, V> getNext() {
        return (LRUCacheNode<K, V>) super.getNext();
    }

    /**
     *
     * @return the previous node of current node
     */
    @Override
    public LRUCacheNode<K, V> getPrev() {
        return (LRUCacheNode<K, V>) super.getPrev();
    }
}
