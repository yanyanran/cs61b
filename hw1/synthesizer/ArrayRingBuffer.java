package synthesizer;

import java.util.Iterator;

/**
 * 实现BoundedQueue，并使用数组作为Bounded队列的实际实现
 *
 * 对于BoundedQueue中的dequeue，每次头删元素都要让元素大量前移，数据量一大性能堪忧
 * ArrayRingBuffer 将通过使用类似于 proj1a 中的循环数组的“环形缓冲区”数据结构来显着改进
 *
 * TODO：RingBuffer满了，如果再执行一次enqueue()，就会出现Exception --> 手动抛出此异常
 * */
public class ArrayRingBuffer<T> implements AbstractBoundedQueue<T> {
    private int first;
    private int last;
    private T[] rb; // 存储缓冲区数据
    private int fillCount;

    /**
     * 创建一个具有给定容量的新 ArrayRingBuffer。
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[])new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * 将 x 添加到环形缓冲区的末尾。
     */
    public void enqueue(T x) {
        // TODO: 排队项目。不要忘记增加 fillCount 并最后更新。
        if(fillCount == rb.length) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = plusOne(last);
        fillCount += 1;
    }

    private int plusOne(int x) {
        if(x == rb.length - 1) {
            x = 0;
        } else {
          x += 1;
        }
        return x;
    }

    /**
     * 将环形缓冲区中最旧的项目出列。
     */
    public T dequeue() {
        // TODO: 出列第一项。不要忘记减少 fillCount 和更新
        if(fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T remove = rb[first];
        rb[first] = null;
        first = plusOne(first);
        fillCount -= 1;
        return remove;
    }

    /**
     * 返回最旧的项目，但不要删除它。
     */
    public T peek() {
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayBufferIterator();
    }

    private class ArrayBufferIterator implements Iterator<T> {
        private int pos;
        private int num;

        public ArrayBufferIterator() {
            pos = first;
            num = 0;
        }

        public boolean hasNext() {
            return num < rb.length;
        }

        public T next() {
            T item =rb[pos];
            pos = plusOne(pos);
            num += 1;

            return item;
        }
    }
    // TODO: 当到达第 5 部分时，实现支持迭代所需的代码。
}