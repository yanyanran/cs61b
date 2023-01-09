import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * 从小到大排
     */
    public static <Item extends Comparable> Queue<Item> quickSort(Queue<Item> items) {
        if(items.size() <= 1) {
            return items;
        }
        Item cur= getRandomItem(items);
        Queue<Item> less = new Queue<>();  // <
        Queue<Item> equal = new Queue<>();  // =
        Queue<Item> more = new Queue<>();  // >
        partition(items, cur, less, equal, more);
        less = quickSort(less);
        more = quickSort(more);

        items = catenate(less, equal);
        items = catenate(items, more);
        return items;
    }

    /**
     * 从给定队列中返回随机项
     */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item cur = null;
        // 遍历队列以查找给定索引处的项目
        for (Item item : items) {
            if (pivotIndex == 0) {
                cur = item;
                break;
            }
            pivotIndex--;
        }
        return cur;
    }

    /**
     * 划分未排序队列
     */
    private static <Item extends Comparable> void partition(Queue<Item> unsorted, Item cur, Queue<Item> less, Queue<Item> equal, Queue<Item> more) {
        while(!unsorted.isEmpty()) {
            Item next = unsorted.dequeue();
            if(next.compareTo(cur) > 0) {
                more.enqueue(next);
            } else if(next.compareTo(cur) < 0) {
                less.enqueue(next);
            } else {
                equal.enqueue(next);
            }
        }
    }

    /**
     * 返回包含链接在一起的给定队列的新队列（q2项目将链接到q1所有项目之后
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> res = new Queue<Item>();
        for (Item item : q1) {
            res.enqueue(item);
        }
        for (Item item: q2) {
            res.enqueue(item);
        }
        return res;
    }
}