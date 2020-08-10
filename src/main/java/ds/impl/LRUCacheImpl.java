package ds.impl;

import ds.LRUCache;
import ds.entity.LRUCacheNode;

import java.util.HashMap;
import java.util.Map;

public final class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    /**
     * Indicates the maximum number of element the cache can hold.
     */
    private long capacity;

    /**
     * The underlying data structure that provides constant time lookup.
     */
    private Map<K, LRUCacheNode<K, V>> cache;

    /**
     * Head of the internal doubly-linked list, pointing to the least
     * recently used node.
     */
    private LRUCacheNode<K, V> head;

    /**
     * Tail of the internal doubly-linked list, pointing to the most
     * recently used node.
     */
    private LRUCacheNode<K, V> tail;

    /**
     *
     * @param capacity the maximum number of element the LRUCache object
     *                 can hold
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
            this.reRank(node);

            return node.getAuxValue();
        }

        return null;
    }

    @Override
    public boolean put(final K key, final V value) {
        if (this.cache.containsKey(key)) {
            this.reRank(this.cache.get(key));
            cache.get(key).setAuxValue(value);
        } else {
            LRUCacheNode<K, V> nodeToAdd = new LRUCacheNode<>(key, value);

            this.add(nodeToAdd);
            this.cache.put(key, nodeToAdd);

            if (this.cache.size() > this.capacity) {
                LRUCacheNode<K, V> nodeToRemove = this.head.getNext();
                this.remove(nodeToRemove);
                this.cache.remove(nodeToRemove.getKey());
            }
        }

        return true;
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
    private void reRank(final LRUCacheNode<K, V> node) {
        this.remove(node);
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
     * @param node the node to be removed from its current position
     *             in the list
     */
    private void remove(final LRUCacheNode<K, V> node) {
        LRUCacheNode<K, V> originalPrev = node.getPrev();
        LRUCacheNode<K, V> originalNext = node.getNext();
        originalPrev.setNext(originalNext);
        originalNext.setPrev(originalPrev);
    }
}
