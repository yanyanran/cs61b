import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * ExtrinsicMinPQ 的一个非常基本的实现。
 * 操作性能很差，但至少是正确的，有一个例外：如果项目已经存在，add 方法应该抛出异常，但这样做会使 add 方法非常慢，以至于这个类很难使用用于检测。
 *  @author Matt Owen @since 03-11-19 */
public class NaiveMinPQ<T> implements ExtrinsicMinPQ<T> {

    private ArrayList<PriorityNode> items;

    public NaiveMinPQ() {
        items = new ArrayList<>();
    }

    /** 请注意，此方法不会抛出正确的异常，否则它会非常慢（线性时间）*/
    @Override
    public void add(T item, double priority) {
        items.add(new PriorityNode(item, priority));
    }

    @Override
    public boolean contains(T item) {
        return items.contains(new PriorityNode(item, 0));
    }

    @Override
    public T getSmallest() {
        if (size() == 0) {
            throw new NoSuchElementException("PQ is empty");
        }
        return Collections.min(items).getItem();
    }

    @Override
    public T removeSmallest() {
        if (size() == 0) {
            throw new NoSuchElementException("PQ is empty");
        }
        int minInd = indOf(getSmallest());
        return items.remove(minInd).getItem();
    }

    @Override
    public void changePriority(T item, double priority) {
        if (contains(item) == false) {
            throw new NoSuchElementException("PQ does not contain " + item);
        }
        items.get(indOf(item)).setPriority(priority);
    }

    /* Returns the number of items in the PQ. */
    @Override
    public int size() {
        return items.size();
    }

    private int indOf(T elem) {
        return items.indexOf(new PriorityNode(elem, 0));
    }

    private class PriorityNode implements Comparable<PriorityNode> {
        private T item;
        private double priority;

        PriorityNode(T e, double p) {
            this.item = e;
            this.priority = p;
        }

        T getItem() {
            return item;
        }

        double getPriority() {
            return priority;
        }

        void setPriority(double priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(PriorityNode other) {
            if (other == null) {
                return -1;
            }
            return Double.compare(this.getPriority(), other.getPriority());
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                return ((PriorityNode) o).getItem().equals(getItem());
            }
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }
    }
}