package ds;

public interface Iterator<T> {

    /**
     *
     * @return whether or not the underlying data structure has
     * one more element to be iterated through
     */
    boolean hasNext();

    /**
     *
     * @return the next element available
     */
    T next();
}
