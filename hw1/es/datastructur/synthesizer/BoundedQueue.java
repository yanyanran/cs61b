package es.datastructur.synthesizer;

/**
 * 一个接口，声明必须由实现BoundedQueue的任何类实现的所有方法
 *
 * 与proj1中的Deque类似，不过BoundedQueue的容量固定，队列满后不允许入队
 *  */
public interface BoundedQueue<T> {
    int capacity();     // return 缓冲区大小
    int fillCount();    // return 缓冲区中当前的元素数
    void enqueue(T x);  // 在末尾添加x
    T dequeue();        // 从前面删除并返回元素
    T peek();           // return (但不删除) 前面元素

    // 缓冲区是否为空（fillCount等于零）？
    default boolean isEmpty()
    {
        return this.fillCount() == 0;
    }

    // 缓冲区是否已满（fillCount与容量相同）？
    default boolean isFull()
    {
        return this.fillCount() == this.capacity();
    }
}