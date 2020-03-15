import org.junit.Test;
import static org.junit.Assert.*;

public class MaxHeapTest {
    @Test
    public void testAdd(){
        MaxHeap myHeap = new MaxHeap (5);
        Integer[] test0 = {};
        assertEquals(0, myHeap.size);
        assertTrue(myHeap.Equals(test0));

        assertTrue(myHeap.add(1));
        Integer[] test1 = {1};
        assertEquals(1, myHeap.size);
        assertTrue(myHeap.Equals(test1));

        assertTrue(myHeap.add(4));
        Integer[] test2 = {4, 1};
        assertEquals(2, myHeap.size);
        assertTrue(myHeap.Equals(test2));

        assertTrue(myHeap.add(2));
        Integer[] test3 = {4, 1, 2};
        assertEquals(3, myHeap.size);
        assertTrue(myHeap.Equals(test3));

        assertTrue(myHeap.add(7));
        Integer[] test4 = {7, 4, 2, 1};
        assertEquals(4, myHeap.size);
        assertTrue(myHeap.Equals(test4));

        assertTrue(myHeap.add(3));
        Integer[] test5 = {7, 4, 2, 1, 3};
        assertEquals(5, myHeap.size);
        assertTrue(myHeap.Equals(test5));

        assertFalse(myHeap.add(23));

   }

    @Test
    public void testGet(){
        MaxHeap maxHeap = new MaxHeap(10);
        assertEquals(null, maxHeap.get());
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(4);
        assertEquals((Integer) 4, maxHeap.get());
        maxHeap.add(3);
        assertEquals((Integer) 4, maxHeap.get());
        maxHeap.add(122);
        assertEquals((Integer) 122, maxHeap.get());
        maxHeap.add(-1223);
        assertEquals((Integer) 122, maxHeap.get());
   }

    @Test
    public void testPop(){
       MaxHeap myHeap = new MaxHeap (10);
       myHeap.add(1);
       assertEquals((Integer) 1, myHeap.pop());
       assertEquals(null, myHeap.pop());

       myHeap.add(4);
       myHeap.add(2);
       assertEquals((Integer) 4, myHeap.pop());
       assertEquals((Integer) 2, myHeap.pop());

       myHeap.add(7);
       myHeap.add(3);
       myHeap.add(23);
       myHeap.add(234);
       assertEquals((Integer) 234, myHeap.pop());
       myHeap.pop();
       assertEquals((Integer) 7, myHeap.pop());
   }

    @Test
    public void testMaxHeapNlogN(){
        MaxHeap myHeap0 = new MaxHeap(10);
        Integer[] test0 = {};
        myHeap0.MaxHeapNLogN(test0);
        assertTrue(myHeap0.Equals(test0));

        MaxHeap myHeap1 = new MaxHeap(10);
        Integer[] test1 = {1, 4, 2, 7, 3};
        Integer[] result1 = {7, 4, 2, 1, 3};
        myHeap1.MaxHeapNLogN(test1);
        assertTrue(myHeap1.Equals(result1));

        MaxHeap myHeap2 = new MaxHeap(10);
        Integer[] test2 = {0, 0, 0, 0, 0, 0, 0};
        Integer[] result2 = {0, 0, 0, 0, 0, 0, 0};
        myHeap2.MaxHeapNLogN(test2);
        assertTrue(myHeap2.Equals(result2));

    }
    @Test
    public void testMaxHeapN(){
        MaxHeap myHeap0 = new MaxHeap(10);
        Integer[] test0 = {};
        myHeap0.MaxHeapN(test0);
        assertTrue(myHeap0.Equals(test0));

        MaxHeap myHeap1 = new MaxHeap(10);
        Integer[] test1 = {1, 4, 2, 7, 3};
        Integer[] result1 = {7, 4, 2, 1, 3};
        myHeap1.MaxHeapN(test1);
        assertTrue(myHeap1.Equals(result1));

        MaxHeap myHeap2 = new MaxHeap(10);
        Integer[] test2 = {0, 0, 0, 0, 0, 0, 0};
        Integer[] result2 = {0, 0, 0, 0, 0, 0, 0};
        myHeap2.MaxHeapN(test2);
        assertTrue(myHeap2.Equals(result2));

    }


}