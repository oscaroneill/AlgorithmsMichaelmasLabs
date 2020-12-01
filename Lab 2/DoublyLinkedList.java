// TIME SPENT: 7 hours

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author Oscar O'Neill
 *  @version 01/10/18 17:35:49
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated string of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode {
    	public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
        	data = theData;
        	prev = prevNode;
          	next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    
    int listSize = 0;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() {
    	head = null;
    	tail = null;
    }
    
    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  Only one operation is performed, without any looping.
     */
    public boolean isEmpty() {
       	return head == null;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  One for-loop results in a running time cost of Theta(n). Even though other operations exist in
     *  the method, the for-loop is the dominant time cost operation of the method. We use a variable n
     *  as the number of loops of the for-loop will change depending on the size of the list.
     */
    public void insertBefore(int pos, T data) {
    	if (listSize == 0) {
    		DLLNode node = new DLLNode(data, null, null);
    		head = node;
    		tail = node;
    	} else if (pos <= 0) {
    		DLLNode node = new DLLNode(data, null, head);
    		head.prev = node;
    		head = node;
    	} else if (pos >= listSize-1) {
    		DLLNode node = new DLLNode(data, tail, null);
    		tail.next = node;
    		tail = node;
    	} else {
    		DLLNode currentNext = head;
    		DLLNode currentPrev = null;
    		for (int i = 0; i < pos; i++) {
    			currentPrev = currentNext;
    			currentNext = currentNext.next;
    		}
    		DLLNode node = new DLLNode(data, currentPrev, currentNext);
    		node.next.prev = node;
    		node.prev.next = node;
    	}
    	listSize++;
    	return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  One for-loop results in a running time cost of Theta(n). Even though other operations exist in
     *  the method, the for-loop is the dominant time cost operation of the method. We use a variable n
     *  as the number of loops of the for-loop will change depending on the size of the list.
     */
    public T get(int pos) {
    	if (pos < 0 || pos >= listSize) {
    		return null;
    	} else {
    		DLLNode currentNode = head;
    		for (int i = 0; i < pos; i++) {
    			currentNode = currentNode.next;
    		}
    		return currentNode.data;
    	}
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  One for-loop results in a running time cost of Theta(n). Even though other operations exist in
     *  the method, the for-loop is the dominant time cost operation of the method. We use a variable n
     *  as the number of loops of the for-loop will change depending on the size of the list.
    */
    public boolean deleteAt(int pos) {
    	if (pos < 0 || pos >= listSize) {
    		return false;
    	} else {
    		if (pos == 0) {
    			if (listSize == 1) {
    				head = null;
    				tail = null;
    			} else {
        			head = head.next;
        			head.prev = null;
    			}
    		} else if (pos == listSize-1) { 
    			tail.prev.next = null;
    			tail = tail.prev;
    		} else {
    			DLLNode currentNext = head;
        		DLLNode currentPrev = null;
        		for (int i = 0; i < pos; i++) {
        			currentPrev = currentNext;
        			currentNext = currentNext.next;
        		}
        		currentNext.next.prev = currentPrev;
        		currentPrev.next = currentNext.next;
        		currentNext.next = null;
        		currentNext.prev = null;
    		}
    		listSize--;
    		return true;
    	}
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  One for-loop results in a running time cost of Theta(n). Even though other operations exist in
     *  the method, the for-loop is the dominant time cost operation of the method. We use a variable n
     *  as the number of loops of the for-loop will change depending on the size of the list.
     */
    public void reverse() {
    	DLLNode currentNode = head;
    	
    	for (int i = 0; i < listSize; i++) {
    		DLLNode currentNext = currentNode.next;
        	DLLNode currentPrev = currentNode.prev;
        	
    		currentNode.next = currentPrev;
    		currentNode.prev = currentNext;
    		
    		currentNode = currentNext;
    	}
    	
    	DLLNode tempHead = head;
    	head = tail;
    	tail = tempHead;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(n^2)
     *
     * Justification:
     *  Two nested for-loops result in a running time cost of Theta(n^2) as they are the dominant
     *  time cost operations of the method. One for-loop has a time cost of Theta(n), and because the
     *  loops are nested, we multiple n by n to result in n^2.
     */
    public void makeUnique() {
    	DLLNode currentNodeA = head;
    	for (int a = 0; a < listSize; a++) {
    		DLLNode currentNodeB = head;
    		for (int b = 0; b < listSize; b++) {
    			if (currentNodeA.data == currentNodeB.data && currentNodeA.next != currentNodeB.next) {
    				System.out.println("Duplicate found at: " + b);
    				//System.out.println("Before: " + toString());
    				deleteAt(b);
    				break;
    				//System.out.println("After: " + toString());
    				//currentNodeB.next.prev = currentNodeB.prev;
    				//currentNodeB.prev.next = currentNodeB.next;
    			}
    			currentNodeB = currentNodeB.next;
    		}
    		currentNodeA = currentNodeA.next;
    	}
    }

    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  Time cost is constant as there are a limited number of operations without looping.
     */
    public void push(T item) {
    	DLLNode node = new DLLNode(item, tail, null);
    	if (listSize == 0) {
    		head = node;
    	} else if (listSize == 1) {
    		head.next = node;
    	} else {
    		tail.next = node;
    	}
    	tail = node;
    	listSize++;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  Time cost is constant as there are a limited number of operations without looping.
     */
    public T pop() {
    	DLLNode node = tail;
    	if (listSize < 1) {
    		return null;
    	} else if (listSize > 1) {
    		tail = tail.prev;
    		tail.next = null;
    	} else {
    		tail = null;
    		head = null;
    	}
    	listSize--;
    	return node.data;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  Time cost is constant as there are a limited number of operations without looping.
     */
    public void enqueue(T item) {
    	DLLNode node = new DLLNode(item, tail, null);
    	if (listSize == 0) {
    		head = node;
    	} else {
    		tail.next = node;
    	}
    	tail = node;
    	listSize++;
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  Time cost is constant as there are a limited number of operations without looping.
     */
    public T dequeue() {
    	DLLNode node = head;
    	
    	if (listSize < 1) {
    		return null;
    	} else if (listSize > 1) {
    		head = head.next;
        	head.prev = null;
    	} else {
    		tail = null;
    		head = null;
    	}
    	listSize--;
    	return node.data;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	boolean isFirst = true; 

    	// iterate over the list, starting from the head
    	for (DLLNode iter = head; iter != null; iter = iter.next) {
    		if (!isFirst) {
    			s.append(",");
    		} else {
    			isFirst = false;
    		}
    		s.append(iter.data.toString());
    	}

    	return s.toString();
    }
}