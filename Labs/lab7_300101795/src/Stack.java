public interface Stack<E> {

    public abstract boolean isEmpty();
    public abstract E peek();
    public abstract E pop() throws Throwable;
    public abstract void push( E element) throws FullStackException;
    public abstract void clear();
    /* Add clear */
}