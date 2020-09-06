package ds;

public interface PeekingIterator<T> extends Iterator<T> {

    /**
     *
     * @return the value of the next element in the underlying data
     *  structure, which is the same value as returned by
     * @see Iterator<T>#next()
     */
    T peek();
}
