package ds.impl;

import ds.Iterator;
import ds.PeekingIterator;

public class PeekingIteratorImpl<T> implements PeekingIterator<T> {

    /**
     * The underlying iterator without peeking functionality.
     */
    private final Iterator<T> iterator;

    /**
     * Indicates whether the next element has been peeked/retrieved.
     */
    private boolean hasPeeked;

    /**
     * The value of the next element retrieved through peeking.
     */
    private T peekedValue;

    /**
     *
     * @param iterator the underlying basic iterator without
     *                 peeking functionality
     */
    public PeekingIteratorImpl(
            final Iterator<T> iterator) {
        this.iterator = iterator;
    }

    /**
     *
     * @return the value of the next element
     */
    @Override
    public T peek() {
        if (!hasPeeked) {
            peekedValue = iterator.next();
            hasPeeked = true;
        }

        return peekedValue;
    }

    /**
     *
     * @return whether or not the underlying data structure
     *  has one more element
     */
    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    /**
     *
     * @return the value of the next element
     */
    @Override
    public T next() {
        if (hasPeeked) {
            T nextValue = peekedValue;
            peekedValue = null;
            hasPeeked = false;

            return nextValue;
        } else {
            return iterator.next();
        }
    }
}
