package ds;

public interface LRUCache<K, V> {

    /**
     *
     * @param key the key to lookup for
     * @return the corresponding value of the key-value pair stored in the cache
     */
    V get(K key);

    /**
     *
     * @param key the key of the key-value pair to be stored
     * @param value the value of the key-value pair to be stored
     * @return whether or not the operation was successful
     */
    boolean put(K key, V value);

    /**
     *
     * @return the logical size of the underlying data structure of the cache
     */
    long size();
}
