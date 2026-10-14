package week5;

public class LinkedQueue<T> implements QueueInterface<T> {
    private LLNode<T> front;
    private LLNode<T> rear;
    public int numElements = 0;

    @Override
    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        if (isEmpty())  {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numElements++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T el = front.getInfo();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        numElements--;
        return el;
    }

    @Override
    public boolean isFull() {
        return false; 
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }
}