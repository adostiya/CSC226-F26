package week3;
import week1.*;

public class Main {
    public static void main(String args[]){
        ArrayBoundedStack<Car> temp = new ArrayBoundedStack<>();
        Car bmw = new Car(02100);
        Car ford = new Car(77777);

        
        System.out.println(temp.isEmpty());
        System.out.println(temp.isFull());

        temp.push(bmw);

        System.out.println(temp.isEmpty());
        System.out.println(temp.isFull());
        System.out.println(temp.top());

        temp.pop();

        System.out.println(temp.isEmpty());
        System.out.println(temp.isFull());
        System.out.println(temp.top());

        temp.push(bmw);
        temp.push(ford);

        System.out.println(temp.isEmpty());
        System.out.println(temp.isFull());
        System.out.println(temp.top());

    }
}