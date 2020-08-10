package ds.entity;

public class LRUCacheNode<K, V> extends ListNode<K> {

    /**
     * The actual information that the LRUCache stores.
     */
    private V auxValue;

    /**
     *
     * @param key key of the key-value pair which the LRUCache stores
     * @param value value of the key-value pair which the LRUCache stores
     */
    public LRUCacheNode(final K key, final V value) {
        super(key);

        this.auxValue = value;
    }

    /**
     *
     * @return the key of key-value pair stored in the cache; it is actually
     * the value field in its parent class
     * @see ListNode#getValue()
     */
    public K getKey() {
        return super.getValue();
    }

    /**
     *
     * @param auxValue the new value to be assigned to the current node
     */
    public void setAuxValue(final V auxValue) {
        this.auxValue = auxValue;
    }

    /**
     *
     * @return the auxValue in the node
     */
    public V getAuxValue() {
        return this.auxValue;
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
