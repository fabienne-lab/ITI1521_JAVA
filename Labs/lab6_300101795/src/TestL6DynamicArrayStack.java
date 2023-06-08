import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL6DynamicArrayStack {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for DynamicArrayStack (out of possible 3.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorDynamicLessThanMinimumCapacity() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(15);
      assertEquals("The capacity should never be less than the default value of 25", 25, (int) myStack.getCapacity());

      grade += 0.25;
    }

    @Test
    public void testPushDynamic24th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 24; i++) {
        myStack.push(i);
      }
      assertEquals("Peek should return the last element pushed into the stack", 23, (int) myStack.peek());
      assertEquals("The capacity of the array should not be changed", 25, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testPushDynamic26th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 26; i++) {
        myStack.push(i);
      }
      assertEquals("Peek the last element of an increased size stack", 25, (int) myStack.peek());
      assertEquals("Pushing beyond capacity should increase the capacity of the array", 50, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testPopDynamic1st() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(0);
      assertEquals(25, (int) myStack.getCapacity());
      myStack.push(999);
      assertEquals("Popping the only element of the stack", 999, (int) myStack.pop());

      grade += 0.5;
    }

    @Test
    public void testPopDynamic26th25th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 26; i++) {
        myStack.push(i);
      }
      myStack.pop();
      assertEquals("Popping should decrease the capacity", 25, (int) myStack.getCapacity());

      grade += 0.25;
    }

    @Test
    public void testPopMaintainingMinimumCapacity() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(30); //default capacity 25
      //push 26 elements => capacity 50
      for (int i = 0; i < 6; i++) {
        myStack.push(i);
      }
      //pop until we remain with 6 elements and capacity 25
      myStack.pop();
      assertEquals("After first pop, decrease the capacity by 25 only if the new capacity is larger than 25", 30, (int) myStack.getCapacity());
      myStack.pop();
      assertEquals("After second pop, decrease the capacity by 25 only if the new capacity is larger than 25", 30, (int) myStack.getCapacity());

      grade += 0.25;
    }

    @Test
    public void testPopMaintainingMinimumCapacityAfterResize() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(30); //default capacity 25
      //push 26 elements => capacity 50
      for (int i = 0; i < 35; i++) {
        myStack.push(i);
      }
      assertEquals("Capacity not increased after pushing more than 30 elemets", 55, (int) myStack.getCapacity());
      //pop 25 elements
      for(int i=0; i < 25; i++){
        myStack.pop();
      }
      assertEquals("After 25 pop calls, decrease the capacity by 25", 30, (int) myStack.getCapacity());
      for(int i=0; i < 5; i++){
        myStack.pop();
      }
      assertEquals("After another 5 pop calls, the capacity should not decrease since the new capacity would not be larger than 25", 30, (int) myStack.getCapacity());

      grade += 0.25;
    }

    @Test
    public void testClearDynamic5() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 5; i++) {
        myStack.push(i);
      }
      myStack.clear();
      assertEquals("After clearing the stack, the isEmpty should return true", true, myStack.isEmpty());
      assertEquals("The capacity after clearing should be the default value", 25, (int) myStack.getCapacity());

      grade += 0.25;
    }

    @Test
    public void testClearDynamic100() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 100; i++) {
        myStack.push(i);
      }
      myStack.clear();
      assertEquals("After clearing the stack, the isEmpty should return true", true, myStack.isEmpty());
      assertEquals("After clearing, the capacity should be decreased back to its default", 25, (int) myStack.getCapacity());

      grade += 0.25;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL6DynamicArrayStack.class);

    }

}
