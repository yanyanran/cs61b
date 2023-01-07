/**
 * 自定义队列的基本操作接口.
 * @param <E> 泛型,数据类型;
 */
public interface MyQueue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E element);    // 入队(添加)
    E dequeue();    // 出队(删除)
    E getFront();    // 获取队首元素
}
