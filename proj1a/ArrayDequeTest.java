import org.junit.Test;

import java.lang.reflect.Array;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkGet(String expected, String actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    public static void addGetTest() {
        System.out.println("Running add/get test.");
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");



        boolean passed = checkGet("front", lld1.get(0));
        passed = checkGet("middle", lld1.get(1)) && passed;
        passed = checkGet("back", lld1.get(2)) && passed;
        passed = checkGet(null, lld1.get(3)) && passed;
        printTestStatus(passed);
    }

    public static void manyAddsTest() {
        System.out.println("Running many adds test.");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

//        for (int i = 0; i < 3; i++) {
//            lld1.addFirst(i);
//        }
        for (int i = 0; i < 1000; i++) {
            lld1.addLast(i);
        }
        lld1.printDeque();


    }

    public static void manyAddsDeletesTest() {
        System.out.println("Running many adds/deletes test.");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        for (int i = 500; i >= 0; i--) {
            lld1.addFirst(i);
        }
        for (int i = 501; i <= 1000; i++) {
            lld1.addLast(i);
        }

        lld1.printDeque();

        for (int i = 0; i < 900; i++) {
            lld1.removeFirst();
        }

        lld1.printDeque();
        lld1.size();


    }

    public static void d001() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        for (int i = 0; i < 8; i++) {
            lld1.addLast(i);
        }
        for (int i = 0; i < 8; i++ ){
            System.out.println(lld1.get(i));
//            lld1.get(i);
        }
    }

    public static void d002() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        for (int i = 0; i < 100; i++) {
            lld1.addLast(i);
        }
        System.out.println(lld1.removeFirst());
        System.out.println(lld1.removeLast());
    }

    public static void d003() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        lld1.addFirst(0);
        lld1.addFirst(1);
        int x = lld1.removeLast();
        lld1.addFirst(3);
        lld1.isEmpty();
        lld1.addFirst(5);
        lld1.addFirst(6);
        int y = lld1.removeLast();
        int k = 1;
    }

    public static void d011() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        lld1.addLast(0);
        int x = lld1.removeFirst();
        lld1.addFirst(2);
        int x2=lld1.removeFirst();
        lld1.addFirst(4);
        lld1.addLast(5);
        lld1.addFirst(6);
        int x3=lld1.removeLast();
        int x4=lld1.removeLast();
        int x5=lld1.get(0);
        lld1.addFirst(10);
        lld1.addLast(11);
        int x6=lld1.removeLast();
        int x7=lld1.get(0);
        lld1.addFirst(14);
        lld1.addFirst(15);
        int x8=lld1.get(1);
        int x9=lld1.removeLast();
        lld1.addFirst(18);
        int x10=lld1.removeLast();
        int x11=lld1.removeLast();
        int x12=lld1.removeFirst();
        int x13=lld1.removeFirst();

        int x99 = 0;
    }

    public static void d012() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.removeFirst();
        lld1.removeLast();
        int x = lld1.size();
        int k = 1;
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
//        addIsEmptySizeTest();
//        addRemoveTest();
//        addGetTest();

//        manyAddsTest();
//        manyAddsDeletesTest();
        d011();
    }
}