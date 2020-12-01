import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for BST
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author Oscar O'Neill
 */

@RunWith(JUnit4.class)
public class BSTTest {

	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */
	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> tree = new BST<Integer, Integer>();
		assertEquals("Check prettyPrint for empty tree", "-null", tree.prettyPrintKeys());
      
	                          //  -7
	                          //   |-3
	                          //   | |-1
	                          //   | | |-null
	    tree.put(7, 7);       //   | |  -2
	    tree.put(8, 8);       //   | |   |-null
	    tree.put(3, 3);       //   | |    -null
	    tree.put(1, 1);       //   |  -6
	    tree.put(2, 2);       //   |   |-4
	    tree.put(6, 6);       //   |   | |-null
	    tree.put(4, 4);       //   |   |  -5
	    tree.put(5, 5);       //   |   |   |-null
	                          //   |   |    -null
	                          //   |    -null
	                          //    -8
	                          //     |-null
	                          //      -null
     
	    String result = 
			"-7\n" +
			" |-3\n" + 
			" | |-1\n" +
			" | | |-null\n" + 
			" | |  -2\n" +
			" | |   |-null\n" +
			" | |    -null\n" +
			" |  -6\n" +
			" |   |-4\n" +
			" |   | |-null\n" +
			" |   |  -5\n" +
			" |   |   |-null\n" +
			" |   |    -null\n" +
			" |    -null\n" +
			"  -8\n" +
			"   |-null\n" +
			"    -null\n";
		assertEquals("Check prettyPrint for non-empty tree", result, tree.prettyPrintKeys());
	}

	/** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testDelete() {
    	BST<Integer, Integer> tree = new BST<Integer, Integer>();
        tree.delete(1);
        assertEquals("Delete from empty tree", "()", tree.printKeysInOrder());
         
					        //  -7
					        //   |-3
					        //   | |-1
					        //   | | |-null
        tree.put(7, 7);		//   | |  -2
		tree.put(8, 8);     //   | |   |-null
		tree.put(3, 3);     //   | |    -null
		tree.put(1, 1);     //   |  -6
		tree.put(2, 2);     //   |   |-4
		tree.put(6, 6);     //   |   | |-null
		tree.put(4, 4);     //   |   |  -5
		tree.put(5, 5);     //   |   |   |-null
							//   |   |    -null
					        //   |    -null
					        //    -8
					        //     |-null
					        //      -null
         
		assertEquals("Order of tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",
				tree.printKeysInOrder());
         
        tree.delete(11);
        assertEquals("Delete key not in tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",
        		tree.printKeysInOrder());
 
        tree.delete(5);
        assertEquals("Delete leaf", "(((()1(()2()))3((()4())6()))7(()8()))",
        		tree.printKeysInOrder());
 
        tree.delete(6);
        assertEquals("Delete node with one child", "(((()1(()2()))3(()4()))7(()8()))",
        		tree.printKeysInOrder());
 
        tree.delete(3);
        assertEquals("Delete node with two children", "(((()1())2(()4()))7(()8()))",
        		tree.printKeysInOrder());
    }
     
    @Test
    public void testIsEmpty() {
        BST<Integer, Integer> tree = new BST<Integer, Integer>();
        assertTrue(tree.isEmpty());
        assertEquals(false, !tree.isEmpty());
    }
     
    @Test
    public void testSize() {
    	BST<Integer, Integer> tree = new BST<Integer, Integer>();
    	assertEquals(0, tree.size());
    	 
					         //  -7
					         //   |-3
					         //   | |-1
					         //   | | |-null
    	tree.put(7, 7);      //   | |  -2
		tree.put(8, 8);      //   | |   |-null
		tree.put(3, 3);      //   | |    -null
		tree.put(1, 1);      //   |  -6
		tree.put(2, 2);      //   |   |-4
		tree.put(6, 6);      //   |   | |-null
		tree.put(4, 4);      //   |   |  -5
		tree.put(5, 5);      //   |   |   |-null
					         //   |   |    -null
					         //   |    -null
					         //    -8
					         //     |-null
					         //      -null
         
        assertEquals(8, tree.size());
    }
     
    @Test
    public void testContains() {
    	BST<Integer, Integer> tree = new BST<Integer, Integer>();
    	 
					         //  -7
					         //   |-3
					         //   | |-1
					         //   | | |-null
    	tree.put(7, 7);      //   | |  -2
		tree.put(8, 8);      //   | |   |-null
		tree.put(3, 3);      //   | |    -null
		tree.put(1, 1);      //   |  -6
		tree.put(2, 2);      //   |   |-4
		tree.put(6, 6);      //   |   | |-null
		tree.put(4, 4);      //   |   |  -5
		tree.put(5, 5);      //   |   |   |-null
					         //   |   |    -null
					         //   |    -null
					         //    -8
					         //     |-null
					         //      -null
		
        assertEquals(true, tree.contains(7));
        assertEquals(true, tree.contains(8));
        assertEquals(true, tree.contains(3));
        assertEquals(true, tree.contains(1));
        assertEquals(true, tree.contains(2));
        assertEquals(true, tree.contains(6));
        assertEquals(true, tree.contains(4));
        assertEquals(false, tree.contains(40));   
    }
     
    @Test
    public void testHeight() {
    	BST<Integer, Integer> tree = new BST<Integer, Integer>();
    	assertEquals(-1, tree.height()); 
					         //  -7
					         //   |-3
					         //   | |-1
					         //   | | |-null
		tree.put(7, 7);      //   | |  -2
		tree.put(8, 8);      //   | |   |-null
		tree.put(3, 3);      //   | |    -null
		tree.put(1, 1);      //   |  -6
		tree.put(2, 2);      //   |   |-4
		tree.put(6, 6);      //   |   | |-null
		tree.put(4, 4);      //   |   |  -5
		tree.put(5, 5);      //   |   |   |-null
					         //   |   |    -null
					         //   |    -null
					         //    -8
					         //     |-null
					         //      -null
         
        assertEquals(4, tree.height());
    }
     
    @Test
    public void testMedian() {
    	BST<Integer, Integer> tree = new BST<Integer, Integer>();
    	assertEquals(null, tree.median());
    	 
					         //  -7
					         //   |-3
					         //   | |-1
					         //   | | |-null
		tree.put(7, 7);      //   | |  -2
		tree.put(8, 8);      //   | |   |-null
		tree.put(3, 3);      //   | |    -null
		tree.put(1, 1);      //   |  -6
		tree.put(2, 2);      //   |   |-4
		tree.put(6, 6);      //   |   | |-null
		tree.put(4, 4);      //   |   |  -5
		tree.put(5, 5);      //   |   |   |-null
					         //   |   |    -null
					         //   |    -null
					         //    -8
					         //     |-null
					         //      -null

		assertEquals(4, tree.median().intValue());
    }
}