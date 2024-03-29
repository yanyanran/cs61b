// 使用数组作为核心数据结构

/**
 * 将数组视为循环数组。
 * 如果前指针位于位置零，addFirst，则前指针应该循环回到数组的末尾（因此双端队列中的新前项将是基础数组中的最后一项）
 * */
public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    // 头插标识位置 - 数组开始前的标志位(LinkedListDeque.sentinel.prev)
    private int nextFirst;
    // 尾插标识位置 - 数组最后的的标志位(LinkedListDeque.sentinel.next)
    private int nextLast;

    /**
     * 考虑循环改变后的下标
     * */
    private int plusOne(int index) {
        // 使得元素下标后移
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        // 使得元素下标前移（+ items.length防止出现负数）
        return (index - 1 + items.length) % items.length;
    }

    // 创个空数组双端队列
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    // 深拷贝other
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[])new Object[other.nextFirst];
        int i = plusOne(other.nextFirst);
        while (i != other.nextLast) {
            items[i] = other.items[i];
            i = plusOne(i);
        }
        size = other.size();
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
    }

    // 扩容API
    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);

        for (int i = 0; i < size; i++) {
            newDeque[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    @Override
    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + "   ");
            index = plusOne(index);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;

        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size = size - 1;
        }

        /**
         * 判断数组的存储效率，过低考虑降容
         */
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return item;
    }

    // 大优势：不需要迭代，可直接索引
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }
}
