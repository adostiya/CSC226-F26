package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        // TODO: Initialize an empty queue.
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T item) {
        // TODO: Add a node at the rear. Update both references when the queue is empty.
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            size++;
        }
        else {
            rear.next = newNode;
            rear = newNode;
            size++;
        }
    }

    public T dequeue() {
        // TODO: Remove and return the front item, or return null if empty.
        // TODO: When removing the last item, make both front and rear null.
        if (isEmpty()) {
            return null;
        }
        else {
            if (front == rear){
                Node oldFront = front;
                size--;
                front = null;
                rear = null;
                return oldFront.data;
            }
            else {
                Node oldFront = front;
                front = front.next;
                size--;
                return oldFront.data;
            }
        }
    }

    public T peekFront() {
        // TODO: Return the front item without removing it, or null if empty.
        if (isEmpty()) return null;
        return front.data;
    }

    public boolean isEmpty() {
        // TODO: Determine whether the queue contains any items.
        return size == 0;
    }

    public int size() {
        // TODO: Return the number of queued items.
        return size;
    }

    @Override
    public String toString() {
        // TODO: Recursively build a string from front to rear without changing the queue.
        StringBuilder result = new StringBuilder();
        result.append("[");
        appendNodesRecursively(front, result);
        result.append("]");
        return result.toString();
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // TODO: Add the current node's data, then recursively visit current.next.
        // TODO: Stop at the null-node base case.
        if (current == null) {
            return;
        }

        result.append(current.data);

        if (current.next != null) {
            result.append(", ");
        }

        appendNodesRecursively(current.next, result);
    }

    // Add a recursive method that counts the nodes in a queue and 
    // compare its result with size(); test empty and multi-node queues
    public int recursiveSize() {
        return countRecursively(front);
    }

    private int countRecursively(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + countRecursively(current.next);
    }
}
