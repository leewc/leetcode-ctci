class MyQueue {
    
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(output.isEmpty()) move();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if(output.isEmpty()) move();
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    
    // Moves all elements from the input stack to the output stack
    private void move() {
        while(!input.isEmpty())
            output.push(input.pop());
    }
}