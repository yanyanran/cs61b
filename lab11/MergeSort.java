import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * 删除并返回q1或q2中的最小项
     *
     * 该方法假设q1和q2都是按排序顺序排列的，最小的项目排在第一位
     * q1 或 q2 至多有一个可以为空（但不能都为空）
     *
     * @param   q1  从最小到最大排序的队列
     * @param   q2  从最小到最大排序的队列
     * @return      Q1或 q2中的最小项
     */
    private static <Item extends Comparable> Item getMin(Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // 查看每个队列中的最小项目（位于前面，因为队列已排序）以确定哪个较小
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // dequeue删除最小项
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /**
     * 返回一个队列队列，每个队列中包含一个项目
     * @param   items  项目队列
     */
    private static <Item extends Comparable> Queue<Queue<Item>> makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> singles = new Queue<>();
        for (Item i : items) {
            Queue<Item> q = new Queue<>();
            q.enqueue(items.dequeue());
            singles.enqueue(q);
        }
        return singles;
    }

    /**
     * 返回包含从最小到最大排序的给定项目的队列
     *
     * 此方法应该花费大致的nlogn时间，其中n是“项”的大小
     * 这种方法应该是非破坏性的，而不是空的“项目”
     *
     * @param   items  要排序的队列
     * @return         包含“items”中每个项目的队列
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(Queue<Item> items) {
        Queue<Queue<Item>> allItems = makeSingleItemQueues(items);
        Queue<Item> sorted = new Queue<>();
        Queue<Item> left;
        Queue<Item> right;
        while(allItems.size() >= 2) {
            left = allItems.dequeue();
            right = allItems.dequeue();
            sorted = mergeSortedQueues(left, right);
            allItems.enqueue(sorted);
        }
        while (!allItems.isEmpty()) {
            sorted = mergeSortedQueues(sorted, allItems.dequeue());
        }
        return sorted;
    }

    /**
     * 返回按排序顺序包含q1和q2中项目的新队列
     * 此方法所花费的时间应与 q1 和 q2 中的项目总数成线性关系。运行此方法后，q1 和 q2 将为空，并且它们的所有项都将在返回队列中
     *
     * @param   q1  从最小到最大排序的队列
     * @param   q2  从最小到最大排序的队列
     * @return      包含按从小到大排序的所有 q1 和 q2 的队列
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> sorted = new Queue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Item min = getMin(q1, q2);
            sorted.enqueue(min);
        }
        if(!q1.isEmpty()) {
            for(Item i : q1) {
                sorted.enqueue(q1.dequeue());
            }
        }
        if(!q2.isEmpty()) {
            for(Item i : q2) {
                sorted.enqueue(q2.dequeue());
            }
        }
        return sorted;
    }
}
