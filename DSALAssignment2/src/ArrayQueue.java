public class ArrayQueue implements Queue {
    //fields to represent our stack in an array

    //the array of items
    private Object[] items;

    //maximium capacity
    private int maximum;

    //pointer to the position of the front of the queue
    //this points to 0 when the stack is empty
    private int front;

    //Actual number of items in the queue
    private int size;

    //Constructor
    public ArrayQueue(){
        //set the capacity to 20
        maximum = 20;

        //create the array
        items = new Object[maximum];

        //set the front to 0 as the stack is empty
        front = 0;

        //set the size to 0
        size = 0;
    }


    @Override
    public Object dequeue() {
        // first check if the queue is empty.
        // If it is, print an error message and return null,
        // otherwise return the item at the front,
        // decrement the size and increment the front pointer.
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return null;
        } else {
            Object answer = items[front];
            front = (front + 1) % maximum;
            size--;
            return answer;
        }
    }

    @Override
    public void enqueue(Object o) {
        // first check if the queue is full.
        // If it is, print an error message,
        // else calculate the position of the back of the queue
        // and put the item in the back,
        // and finally increment the size
        if (size == maximum){
            System.out.println("Queue full");
        } else {
            int back = (front + size) % maximum;
            items[back] = o;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        //use the size!
        return (size==0);
    }

    @Override
    public int size() {
        //use the size!
        return size;
    }

    @Override
    public Object front() {
        // First check if the queue is empty.
        // If it is, print an error message and return null,
        // otherwise return the item at the front.

        if (isEmpty()) {
            System.out.println("Stack Empty");
            return null;
        } else {
            return items[front];
        }
    }
}
