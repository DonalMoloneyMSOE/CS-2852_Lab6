/*
 *CS 2852 - 011
 *Fall 2017
 *Lab 6 - Recursion
 *Name: Donal Moloney
 *Created: 10/12/2017
 */
package Moloneyda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test cases for the recursive linked-list class.
 */
class TestList {
    private LinkedList<String> defaultList;
    private LinkedList<String> getTestNullList;
    private LinkedList<String> getTestList;
    private LinkedList<String> emptyList;
    private LinkedList<String> testRemove;


    /**
     * Initializes and populates the linked lists
     * @result each test is able to have consistent collections to manipulate for their tests
     */
    @BeforeEach
    void setUp() {
        emptyList = new LinkedList<>();
        getTestList = new LinkedList<>();
        getTestNullList = new LinkedList<>();
        getTestNullList.add(0, null);
        defaultList = new LinkedList<>();
        defaultList.add(0, "A");
        defaultList.add(1, "B");
        defaultList.add(2, "C");
        defaultList.add(3, "D");
        defaultList.add(4, "E");
        defaultList.add(5, "F");
        defaultList.add(6, "G");
        defaultList.add(7, "H");
    }

    /**
     * Initilizes Collections and populates them.
     * @result all the lists have their data removed so a test doesn't carry its affects over
     */
    @AfterEach
    void tearDown() {
        emptyList = null;
        getTestList = null;
        getTestNullList = null;
        defaultList = null;
    }

    /**
     * Tests Get method
     * @result Ensure the get method obtains the correct element at an index and that the correct
     * exceptions are thrown when the get method is used incorrectly
     */
    @Test
    void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
        String testStr = "ABCDEFG";
        for (char c : testStr.toCharArray()) {
            getTestList.add("" + c);
        }
        for (int i = 0; i < testStr.length(); ++i) {
            assertEquals(testStr.substring(i, i + 1), getTestList.get(i),
                         "Unexpected value from get(" + i + ") : " + getTestList.get(i));
        }
        assertTrue(getTestNullList.get(0) == null);
        assertThrows(IndexOutOfBoundsException.class, () -> getTestList.get(testStr.length()));
        assertThrows(IndexOutOfBoundsException.class, () -> getTestList.get(-1));
    }

    /**
     * Tests the size method.
     * @result ensure that the collections change there size when elements are added and removed
     * from them and also that the correct exception is thrown when the method is called incorrectly
     */
    @Test
    void testSize() {
        Assertions.assertTrue(emptyList.size() == 0);
        emptyList.add(0, "1");
        emptyList.add(1, "2");
        emptyList.add(2, "3");
        emptyList.add(3, "4");
        Assertions.assertTrue(emptyList.size() == 4);
        emptyList.remove(0);
        Assertions.assertTrue(emptyList.size() == 3);

    }

    /**
     * Tests set method
     * @result Ensure the get method sets the correct element at the specified index also that the
     * correct exceptions are thrown when the get method is used incorrectly
     */
    @Test
    void testSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(-1, "Banana"));
        defaultList.set(0,"testSetTest1");
        assertTrue(defaultList.get(0).equals("testSetTest1"));
        defaultList.set(3, "Jumanji");
        assertTrue(defaultList.get(3).equals("Jumanji"));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(0, "A"));
        defaultList.add(1, "B");
        defaultList.add(2, "C");
        defaultList.add(3, "D");
    }

    /**
     * Tests remove method
     * @result Ensure the get removes the correct element at an index and that the and that the
     * correct exception is thrown when the get method is used incorrectly
     */
    @Test
    void testRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));
        assertTrue(defaultList.remove(1).equals("B"));
        assertTrue(defaultList.remove(0).equals("A"));
        assertTrue(defaultList.size()== 6);
        assertTrue(defaultList.remove(4).equals("G"));
    }

    /**
     * Tests add method
     * @result Ensure the method adds correctly, also that the correct exception is thrown when
     * trying to add at an index that is out of bounds
     */
    @Test
    void testAdd() {
        defaultList.add(0,"testAddTestAddNonEmpty");
        assertTrue(defaultList.get(0).equals("testAddTestAddNonEmpty"));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(-1, "testAddTest1"));
        emptyList.add(0, "testAddTest2");
        assertTrue(emptyList.get(0).equals("testAddTest2"));
        assertTrue(emptyList.size() == 1);
    }
}