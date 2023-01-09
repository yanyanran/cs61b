import edu.princeton.cs.algs4.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortAlgs {
    @Test
    public void testMergeSort() {
        Queue<Integer> nums = new Queue<>();
        nums.enqueue(10);
        nums.enqueue(30);
        nums.enqueue(25);
        nums.enqueue(15);
        nums.enqueue(5);
        Queue<Integer> sorted = MergeSort.mergeSort(nums);

        assertEquals(5, (int) sorted.dequeue());
        assertEquals(10, (int) sorted.dequeue());
        assertEquals(15, (int) sorted.dequeue());
        assertEquals(25, (int) sorted.dequeue());
        assertEquals(30, (int) sorted.dequeue());

        Queue<String> tas = new Queue<>();
        tas.enqueue("Joe");
        tas.enqueue("Omar");
        tas.enqueue("Itai");
        Queue<String> sortedTas = MergeSort.mergeSort(tas);

        assertEquals("Itai", sortedTas.dequeue());
        assertEquals("Joe", sortedTas.dequeue());
        assertEquals("Omar", sortedTas.dequeue());

    }

    @Test
    public void testQuickSort() {
        Queue<Integer> nums = new Queue<>();
        nums.enqueue(10);
        nums.enqueue(30);
        nums.enqueue(25);
        nums.enqueue(15);
        nums.enqueue(5);
        Queue<Integer> sorted = QuickSort.quickSort(nums);

        assertEquals(5, (int) sorted.dequeue());
        assertEquals(10, (int) sorted.dequeue());
        assertEquals(15, (int) sorted.dequeue());
        assertEquals(25, (int) sorted.dequeue());
        assertEquals(30, (int) sorted.dequeue());

        for(int i = 0; i < 10000; i += 1) {
            nums.enqueue(10000 - i);
        }
        Queue<Integer> sorted2 = QuickSort.quickSort(nums);
        assertEquals(1, (int) sorted2.dequeue());
    }

    @Test
    public void duplicates() {
        Queue<Integer> nums = new Queue<>();
        for(int i = 0; i < 5000; i += 1) {
            nums.enqueue(3);
            nums.enqueue(2);
        }
        Queue<Integer> sorted = QuickSort.quickSort(nums);
//        Queue<Integer> sorted = MergeSort.mergeSort(nums);
        assertEquals(2, (int) sorted.peek());
        assertTrue(isSorted(sorted));
    }

    @Test
    public void sorted() {
        Queue<Integer> nums = new Queue<>();
        for(int i = 0; i < 10000; i += 1) {
            nums.enqueue(i + 1);
        }
        Queue<Integer> sorted = QuickSort.quickSort(nums);
//        Queue<Integer> sorted = MergeSort.mergeSort(nums);
        assertEquals(1, (int) sorted.peek());
    }

    /** 返回队列是否已排序 */
    private <Item extends Comparable> boolean isSorted(Queue<Item> items) {
        if (items.size() <= 1) {
            return true;
        }
        Item curr = items.dequeue();
        Item prev = curr;
        while (!items.isEmpty()) {
            prev = curr;
            curr = items.dequeue();
            if (curr.compareTo(prev) < 0) {
                return false;
            }
        }
        return true;
    }
}