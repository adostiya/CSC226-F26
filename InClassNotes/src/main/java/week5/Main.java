package week5;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> temp = new LinkedQueue<>();
        System.out.println(temp.isEmpty());
        System.out.println(temp.isFull());
        
        temp.enqueue(1);
        temp.enqueue(2);
        temp.enqueue(3);
        temp.enqueue(4);
        temp.enqueue(5);
    }
}
