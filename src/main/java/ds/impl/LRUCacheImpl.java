package ds.impl;

import ds.LRUCache;
import ds.entity.LRUCacheNode;

import java.util.HashMap;
import java.util.Map;

public final class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    /**
     * Indicates the maximum number of element the cache can hold.
     */
    private final long capacity;

    /**
     * The underlying data structure that should provide constant time lookup.
     */
    private final Map<K, LRUCacheNode<K, V>> cache;

    /**
     * Head of the internal doubly-linked list, pointing to the least
     * recently used node.
     */
    private final LRUCacheNode<K, V> head;

    /**
     * Tail of the internal doubly-linked list, pointing to the most
     * recently used node.
     */
    private final LRUCacheNode<K, V> tail;

    /**
     *
     * @param capacity the maximum number of elements of type V,
     *                which the LRUCache object can hold
     */
    public LRUCacheImpl(final long capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new LRUCacheNode<>(null, null);
        this.tail = new LRUCacheNode<>(null, null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    @Override
    public V get(final K key) {
        if (cache.containsKey(key)) {
            LRUCacheNode<K, V> node = cache.get(key);
            this.updateRank(node);

            return node.getValue();
        }

        return null;
    }

    @Override
    public V put(final K key, final V value) {
        if (this.cache.containsKey(key)) {
            V existingValue = this.cache.get(key).getValue();

            // overwrite the existing value
            cache.get(key).setValue(value);
            // update the rank now that the node has just been accessed
            this.updateRank(this.cache.get(key));

            return existingValue;
        } else {
            LRUCacheNode<K, V> nodeToAdd = new LRUCacheNode<>(key, value);

            // add node to the lookup cache
            this.cache.put(key, nodeToAdd);
            // insert the newly added node to the tail of the doubly-linked
            //  list, indicating that it is the most recently accessed node
            this.add(nodeToAdd);

            if (this.cache.size() > this.capacity) {
                LRUCacheNode<K, V> nodeToEvict = this.head.getNext();
                this.evict(nodeToEvict);
                this.cache.remove(nodeToEvict.getCacheKey());
            }

            return null;
        }
    }

    @Override
    public long size() {
        return this.cache.size();
    }

    /**
     * Removes the node from its current position in the doubly-linked list and
     * adds it back to the tail (most recently used) of the doubly-linked list.
     * @param node the node to be re-ranked
     */
    private void updateRank(final LRUCacheNode<K, V> node) {
        this.evict(node);
        this.add(node);
    }

    /**
     *
     * @param node the node to be added to the tail of the list
     */
    private void add(final LRUCacheNode<K, V> node) {
        LRUCacheNode<K, V> prevLastNode = this.tail.getPrev();
        this.tail.setPrev(node);
        prevLastNode.setNext(node);

        node.setNext(this.tail);
        node.setPrev(prevLastNode);
    }

    /**
     *
     * @param node the node to be evicted from its current position
     *             in the list
     */
    private void evict(final LRUCacheNode<K, V> node) {
        LRUCacheNode<K, V> originalPrev = node.getPrev();
        LRUCacheNode<K, V> originalNext = node.getNext();
        originalPrev.setNext(originalNext);
        originalNext.setPrev(originalPrev);
    }
}
