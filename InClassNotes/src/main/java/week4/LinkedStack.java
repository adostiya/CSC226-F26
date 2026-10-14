package week4;
import week3.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;

    public LinkedStack(){
        this.top = null;
    }

    public void push(T element){
        LLNode<T> newNode = new LLNode<>(element);
        newNode.setNext(top);
        top = newNode;
    }

    public void pop() {
    if (isEmpty()) {
        System.out.println("Empty stack");
        return;
    }
    top = top.getNext();
    }

    public T top(){
        if (isEmpty()){
            System.out.println("Empty stack");
            return null;
        }
        return top.getInfo();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public boolean isFull(){
        return false;
    }
}