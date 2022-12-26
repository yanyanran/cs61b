package es.datastructur.synthesizer;

/**
 * 实现BoundedQueue，并使用数组作为Bounded队列的实际实现
 *
 * 对于BoundedQueue中的dequeue，每次头删元素都要让元素大量前移，数据量一大性能堪忧
 * ArrayRingBuffer 将通过使用类似于 proj1a 中的循环数组的“环形缓冲区”数据结构来显着改进
 *
 * TODO：RingBuffer满了，如果再执行一次enqueue()，就会出现Exception --> 手动抛出此异常
 * */
public class ArrayRingBuffer<T> implements BoundedQueue<T>{
    private int first;
    private int last;
    private T[] rb;

    /**
     * 创建一个具有给定容量的新 ArrayRingBuffer。
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: 创建具有容量元素的新数组。first、last 和 fillCount 都应设置为 0。
        //  this.capacity 应该适当设置。注意局部变量
        //  这里隐藏了我们从 AbstractBoundedQueue 继承的字段，所以你需要使用 this.capacity 来设置容量。

    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public int fillCount() {
        return 0;
    }

    /**
     * 将 x 添加到环形缓冲区的末尾。如果没有空间，那么
     * throw new RuntimeException("环形缓冲区溢出")。例外情况
     * 涵盖周一。
     */
    public void enqueue(T x) {
        // TODO: 排队项目。不要忘记增加 fillCount 并最后更新。
    }

    /**
     * 将环形缓冲区中最旧的项目出列。如果缓冲区为空，则
     * throw new RuntimeException("环形缓冲区下溢")。例外情况
     * 涵盖周一。
     */
    public T dequeue() {
        // TODO: 出列第一项。不要忘记减少 fillCount 和更新
    }

    /**
     * 返回最旧的项目，但不要删除它。
     */
    public T peek() {
        // TODO: 返回第一个项目。您的实例变量都不应更改。
    }

    // TODO: 当到达第 5 部分时，实现支持迭代所需的代码。
}