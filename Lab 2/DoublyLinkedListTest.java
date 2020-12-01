import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author Oscar O'Neill
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
    	new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

    /**
     * Check if the get works
     */
    @Test
    public void testGet() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        assertEquals( "Checking get to a list containing 3 elements at position 0", 1, (int)testDLL.get(0) );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking get to a list containing 4 elements at position 1", 5, (int)testDLL.get(1) );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking get to a list containing 5 elements at position 2", 6, (int)testDLL.get(2) );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking get to a list containing 6 elements at position -1 - expected null", null, testDLL.get(-1) );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking get to a list containing 7 elements at position 8 - expected null", null, testDLL.get(7) );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking get to a list containing 8 elements at position 700 - expected null", null, testDLL.get(700) );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();      
        assertEquals( "Checking get to an empty list at position 0 - expected null", null, testDLL.get(0) );
        assertEquals( "Checking get to an empty list at position 4 - expected null", null, testDLL.get(4) );
        assertEquals( "Checking get to an empty list at position -2 - expected null", null, testDLL.get(-2) );
        assertEquals( "Checking get to an empty list at position 600 - expected null", null, testDLL.get(600) );
    }
    
    /**
     * Check if the deleteAt works
     */
    @Test
    public void testDeleteAt() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 0", "2,3", testDLL.toString() );
        testDLL.insertBefore(3,4);
        testDLL.deleteAt(1);
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 1", "2,4", testDLL.toString() );
        testDLL.deleteAt(-1);    
        assertEquals( "Checking deleteAt to a list containing 2 elements at position -1", "2,4", testDLL.toString() );
        testDLL.deleteAt(4);      
        assertEquals( "Checking deleteAt to a list containing 2 elements at position 4", "2,4", testDLL.toString() );
        testDLL.deleteAt(700);        
        assertEquals( "Checking deleteAt to a list containing 2 elements at position 700", "2,4", testDLL.toString() );
        testDLL.deleteAt(1);        
        assertEquals( "Checking deleteAt to a list containing 2 elements at last position", "2", testDLL.toString() );
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 1 element", "", testDLL.toString() );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();      
        assertEquals( "Checking deleteAt to an empty list at position 0 - expected false", false, testDLL.deleteAt(0) );
        assertEquals( "Checking deleteAt to an empty list at position 4 - expected false", false, testDLL.deleteAt(4) );
        assertEquals( "Checking deleteAt to an empty list at position -2 - expected false", false, testDLL.deleteAt(-2) );
        assertEquals( "Checking deleteAt to an empty list at position 600 - expected false", false, testDLL.deleteAt(600) );
    }
    
    /**
     * Check if the reverse works
     */
    @Test
    public void testReverse() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 3 elements", "3,2,1", testDLL.toString() );
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 3 elements", "1,2,3", testDLL.toString() );
        testDLL.insertBefore(0, 4); 
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 4 elements", "3,2,1,4", testDLL.toString() );
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 1 element", "4", testDLL.toString() );
        testDLL.insertBefore(0, 1);
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 2 elements", "4,1", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals( "Checking reverse to an empty list", "", testDLL.toString() );
    }
    
    /*
    /**
     * Check if the makeUnique works
     */
    @Test
    public void testMakeUnique() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,1);
        
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique to a list containing 4 elements with 2 of the same element", "1,2,3", testDLL.toString() );
        testDLL.insertBefore(3, 2);
        testDLL.insertBefore(3, 2);
        testDLL.makeUnique();
        //assertEquals( "Checking makeUnique to a list containing 5 elements with 3 of the same element", "1,2,3", testDLL.toString() );
        /*
        testDLL.insertBefore(0, 4); 
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 4 elements", "3,2,1,4", testDLL.toString() );
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        testDLL.deleteAt(0);
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 1 element", "4", testDLL.toString() );
        testDLL.insertBefore(0, 1);
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 2 elements", "4,1", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals( "Checking reverse to an empty list", "", testDLL.toString() );
        */
    }
    
    /**
     * Check if the push works
     */
    @Test
    public void testPush() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
        
        assertEquals( "Checking pushing 3 items to a list", "1,2,3", testDLL.toString() );
        testDLL.push(4);
        assertEquals( "Checking pushing 4 items to a list", "1,2,3,4", testDLL.toString() );
    }
    
    /**
     * Check if the pop works
     */
    @Test
    public void testPop() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
        
        testDLL.pop();
        assertEquals( "Checking popping an item from a list with 3 items", "1,2", testDLL.toString() );
        assertEquals( "Checking popping an item from a list with 2 items", 2, (int)testDLL.pop() );
        testDLL.pop();
        assertEquals( "Checking popping an item from a list with 1 item", "", testDLL.toString() );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.pop();
        assertEquals( "Checking popping an item from a list with 0 items", "", testDLL.toString() );
    }
    
    /**
     * Check if the enqueue works
     */
    @Test
    public void testEnqueue() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        
        assertEquals( "Checking queueing an item to a list", "1,2,3", testDLL.toString() );
    }
    
    /**
     * Check if the dequeue works
     */
    @Test
    public void testDequeue() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        
        testDLL.dequeue();
        assertEquals( "Checking popping an item from a list with 3 items", "2,3", testDLL.toString() );
        assertEquals( "Checking popping an item from a list with 2 items", 2, (int)testDLL.dequeue() );
        testDLL.dequeue();
        assertEquals( "Checking popping an item from a list with 1 item", "", testDLL.toString() );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.dequeue();
        assertEquals( "Checking popping an item from a list with 0 items", "", testDLL.toString() );
    }
}