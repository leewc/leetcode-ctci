class MyStack {
    
    private Queue<Integer> queue = new LinkedList<>();
    
    // Push element x onto stack.
    // O(n) since we need to 'rotate' all the other elements
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}


//Question only allows standard Queue ops. Not Dequeue
class MyStackUsingDeQue {
    
    Deque<Integer> dq = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        dq.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        dq.removeLast();
    }

    // Get the top element.
    public int top() {
        return dq.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return dq.isEmpty();
    }
}