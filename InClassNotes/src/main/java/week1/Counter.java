package week1;

public class Counter {

    // 2. Add a private field
    // TODO: Declare private int count;
    private int count;

    // 3. Write the default constructor
    public Counter(){
        count = 0;
    }

    // 4. Add an alternate constructor
    public Counter(int count){
        this.count = count;
    }
    // 5. Write an accessor method
    public int getCount(){
        return count;
    }

    // 6. Add an update method
    public void deacreaseCount(){
        count = count--;
    }
    
    // 7. Overload increment
    public void increaseCount(){
        count = count++;
    }
    public void increaseCount(int num){
        count = count+num;
    }
    public void increaseCount(int num, int num2){
        count = count+num+num2;
    }
   
    // 8. Add a reset method
    public void resetCount(){
        count = 0;
    }

    //9. Add a fixed-size history array that records the last 5 states of the counter. All logic must happen inside of the object and be hidden from the user.
    private void history(int g) {
        int[] counters = new int[5];
        int i = 0;
        counters[i] = g;
        if (i>5) {
            counter = 
        }
    }
}