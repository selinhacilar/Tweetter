public interface Queue {
    /**
     * Removes and returns the item at the front of the queue
     *
     * @return the item at the front the queue
     */
    public Object dequeue();

    /**
     * Inserts an object to the back of the queue
     *
     * @param o the object to be pushed
     */
    public void enqueue(Object o);


    /**
     * Tells us if the queue is empty
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of items in the queue
     *
     * @return the number of items in the queue
     */
    public int size();

    /**
     * Tells us the item at the front without removing it
     *
     * @return the object at the front of the queue
     */
    public Object front();
}

