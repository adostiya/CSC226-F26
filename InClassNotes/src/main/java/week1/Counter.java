package week1;

public class Counter {

    // 2. Add a private field
    // TODO: Declare private int count;
    private int count;
    private int[] history = new int[5];
    private int size = 0;

    // 3. Write the default constructor
    public Counter(){
        count = 0;
        historyclass();
    }

    // 4. Add an alternate constructor
    public Counter(int count){
        this.count = count;
        historyclass();
    }
    // 5. Write an accessor method
    public int getCount(){
        return count;
    }

    // 6. Add an update method
    public void decreaseCount(){
        count--;
        historyclass();
    }
    
    // 7. Overload increment
    public void increaseCount(){
        count++;
        historyclass();
    }
    public void increaseCount(int num){
        count = count+num;
        historyclass();
    }
    public void increaseCount(int num, int num2){
        count = count+num+num2;
        historyclass();
    }
   
    // 8. Add a reset method
    public void resetCount(){
        count = 0;
        historyclass();
    }

    //9. Add a fixed-size history array that records the last 5 states of the counter. All logic must happen inside of the object and be hidden from the user.
    private void historyclass() {
        if (size < 5) {
            history[size] = count;
            size++;
        }
        else {
            for (int i=0; i<4; i++) {
                history[i] = history[i+1];
            }
            history [4] = count;
        }
    }
}