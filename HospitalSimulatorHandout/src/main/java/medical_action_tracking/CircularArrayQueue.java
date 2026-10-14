//Implement a second queue representation, such as a circular array,
//and compare its operations and tradeoffs with the linked queue.

package medical_action_tracking;

public class CircularArrayQueue<T> {
    private T[] data;
    private int front;
    private int rear;
    private int size;

    public CircularArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == data.length) {
            throw new IllegalStateException("Full");
        }
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

// Linked queue grows dynamically without limit, but uses a lot of memory for every new Node and its data.
// Circular array queue uses the same memory space again and again, but has fixed limit, so if we want to expand it
// we need to copy it to new array 