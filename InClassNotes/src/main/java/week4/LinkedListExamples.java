package week4;

import java.util.ArrayList;

public class LinkedListExamples {
    public static void main(String[] args){
        // Create a sample linked list for testing
        LLNode<String> head = new LLNode<>("First");
        head.setNext(new LLNode<>("Second"));
        head.getNext().setNext(new LLNode<>("Third"));
        head.getNext().getNext().setNext(new LLNode<>("Fourth"));
        
        // Test your functions here
        System.out.println("--- Display with positions ---");
        displayWithPositions(head);
        
        System.out.println("\nLength: " + getLength(head));
        System.out.println("Contains 'Third': " + contains(head, "Third"));
        System.out.println("Element at 2: " + getElementAt(head, 2));
    }
    
    /**
     * 2. Program to display both elements and their position in a linked list
     */
    public static <T> void displayWithPositions(LLNode<T> head) {
        int position = 0;
        LLNode<T> current = head;
        while (current != null) {
            System.out.println("Position " + position + ": \"" + current.getInfo() + "\"");
            position++;
            current = current.getNext();
        }
    }
    
    /**
     * 3. Program to remove a specified element from a linked list
     */
    public static <T> LLNode<T> removeElement(LLNode<T> head, T target) {
        if (head == null) return null;

        if (head.getInfo() != null && head.getInfo().equals(target)) {
            return head.getNext();
        }

        LLNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getInfo() != null && current.getNext().getInfo().equals(target)) {
                current.setNext(current.getNext().getNext());
                break;
            }
            current = current.getNext();
        }
        return head;
    }
    
    /**
     * 4. Program to remove all elements from a linked list
     */
    public static <T> LLNode<T> removeAllElements(LLNode<T> head) {
        return null; 
    }
    
    /**
     * 5. Program to copy a linked list to another linked list
     */
    public static <T> LLNode<T> copyList(LLNode<T> original) {
        if (original == null) return null;

        LLNode<T> newHead = new LLNode<>(original.getInfo());
        LLNode<T> currentNew = newHead;
        LLNode<T> currentOrig = original.getNext();

        while (currentOrig != null) {
            LLNode<T> newNode = new LLNode<>(currentOrig.getInfo());
            currentNew.setNext(newNode);
            currentNew = newNode;
            currentOrig = currentOrig.getNext();
        }
        return newHead;
    }
    
    /**
     * 6. Program to check if a particular element exists in a linked list
     */
    public static <T> boolean contains(LLNode<T> head, T target) {
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo() != null && current.getInfo().equals(target)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * Helper function to calculate the length of a linked list
     */
    public static <T> int getLength(LLNode<T> head) {
        int length = 0;
        LLNode<T> current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    /**
     * 7. Program to convert a linked list to an array list
     */
    public static <T> ArrayList<T> toArrayList(LLNode<T> head) {
        ArrayList<T> list = new ArrayList<>();
        LLNode<T> current = head;
        while (current != null) {
            list.add(current.getInfo());
            current = current.getNext();
        }
        return list;
    }
        
    /**
     * Helper function to get the element at a specific position
     */
    public static <T> T getElementAt(LLNode<T> head, int position) {
        if (position < 0) return null;
        
        int index = 0;
        LLNode<T> current = head;
        while (current != null) {
            if (index == position) {
                return current.getInfo();
            }
            index++;
            current = current.getNext();
        }
        return null;
    }
}