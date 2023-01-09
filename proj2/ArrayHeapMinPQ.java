import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 这个抽象数据结构与第 20 讲中描述的 MinPQ ADT 之间主要区别：
 *
 * 优先级与对象无关。不依赖某种比较函数来决定哪个项目小于另一个，而是使用addorchangePriority函数简单地分配一个优先级值。
 * 有个附加changePriority功能允许我们在添加项目后设置项目的外部优先级。
 * */
public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    public class Entry<T> {
        T item;
        double priority;

        public Entry(T i, double p) {
            item = i;
            priority = p;
        }
        public void setPriority(double p) {
            this.priority = p;
        }
    }
    private int capacity;
    private Entry[] minHeap;
    private int size;
    private int pos;
    private Map<T, Integer> keys = new HashMap<>();

    public ArrayHeapMinPQ(int capacity) {
        this.capacity = capacity;
        minHeap = new Entry[capacity + 1]; // 将 0 留空
        size = 0;
        pos = 1;
    }

    private void resize() {
        if(size == minHeap.length - 1) {
            capacity *= 2;
        }
        if((double) size/minHeap.length < 0.25) {
            capacity /= 2;
        }
        Entry[] copy = new Entry[capacity + 1];
        System.arraycopy(minHeap, 1, copy, 1, size);
        minHeap = copy;
    }

    // 添加T具有给定优先级的类型的项目
    @Override
    public void add(T item, double priority) {
        if(contains(item)) {
            throw new IllegalArgumentException("this item already exists");
        }
        minHeap[pos] = new Entry(item, priority);
        keys.put(item, pos);
        bubbleUp(pos);
        pos += 1;
        size += 1;
        if(size == minHeap.length - 1) {
            resize();
        }
    }

    // 如果 PQ 包含给定的项目，则返回 true
    @Override
    public boolean contains(T item) {
        return keys.containsKey(item);
    }

    // 返回具有最小优先级的项目
    @Override
    public T getSmallest() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return (T) minHeap[1].item;
    }

    // 删除并返回优先级最低的项目
    @Override
    public T removeSmallest() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        T returnItem = (T)minHeap[1].item;
        keys.remove(returnItem);
        minHeap[1] = minHeap[pos - 1];
        minHeap[pos - 1] = null;
        pos -= 1;
        size -= 1;
        sinkDown(1);
        if((double) size/minHeap.length < 0.25) {
            resize();
        }
        return returnItem;
    }

    private void sinkDown(int n) {
        if(n >= pos/2) return;
        if(minHeap[n].priority < minHeap[n * 2].priority &&
                minHeap[n].priority < minHeap[n * 2 + 1].priority) {
            return;
        }
        else {
            swap(minHeap[n], minHeap[smallerChild(n)]);
            sinkDown(smallerChild(n));
        }
    }

    private void swap(Entry e1, Entry e2) {
        T temp = (T)e1.item;
        double p = e1.priority;
        int index1 = find((T)e1.item);
        int index2 = find((T)e2.item);
        keys.replace((T) e1.item, index2);
        keys.replace((T) e2.item, index1);
        e1.item = e2.item;
        e1.priority = e2.priority;
        e2.item = temp;
        e2.priority = p;

    }

    private int smallerChild(int n) {
        if(minHeap[n*2].priority < minHeap[n*2 + 1].priority) {
            return n*2;
        } else {
            return n*2 + 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    // 将给定项目的优先级设置为给定值
    @Override
    public void changePriority(T item, double priority) {
        if(!contains(item)) {
            throw new NoSuchElementException();
        }
        int index = find(item);
        minHeap[index].setPriority(priority);
        if(minHeap[index].priority < minHeap[parentIdx(index)].priority) {
            bubbleUp(index);
        } else {
            sinkDown(index);
        }
    }

    private void bubbleUp(int n) {
        if(n > 1 && minHeap[n].priority < minHeap[parentIdx(n)].priority) {
            swap(minHeap[n], minHeap[parentIdx(n)]);
            bubbleUp(parentIdx(n));
        }
    }

    private int parentIdx(int n) {
        if(n == 1) return 1;
        return n/2;
    }

    private int find(T item) {
        return keys.get(item);
    }
}