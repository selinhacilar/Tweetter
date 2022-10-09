public class ArrayStack implements Stack {
    //fields to represent our stack in an array

    //the array of items
    private Object[] items;

    //maximium capacity
    private int maximum;

    //pointer to the position of the top of the stack
    //this points to -1 when the stack is empty
    private int top;

    public ArrayStack(){
        //set the capacity to 20
        maximum = 20;

        //create the array
        items = new Object[maximum];

        //set the top to -1 as the stack is empty
        top = -1;
    }

    @Override
    public Object pop() {
        // First check if the stack is empty.
        // If it is, print an error message and return null,
        // otherwise, return the item the top is pointing to
        // and decrement the top pointer
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return null;
        } else {
            Object answer = items[top];
            top--;
            return answer;
        }
    }

    @Override
    public void push(Object o) {
        // First check if the array is full.
        // If it is, print an error message,
        // else increment the top and put the item in that space
        if (top == (maximum - 1)){
            System.out.println("Stack full");
        } else {
            top++;
            items[top] = o;
        }
    }

    @Override
    public boolean isEmpty() {
        // The stack is empty if the top is pointing to -1
        return (top == -1);
    }

    @Override
    public int size() {
        // The size of the stack can be calculated using the position of top
        return(top + 1);
    }

    @Override
    public Object top() {
        // First check if the stack is empty.
        // If it is, print an error message and return null,
        // otherwise, return the item the top is pointing to.
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return null;
        } else {
            return items[top];
        }
    }
}
