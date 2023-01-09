/**
 * 优先级队列，其中对象具有外部提供的优先级，即在插入期间作为参数提供，并且可以使用 change Priority 方法更改。
 */
public interface ExtrinsicMinPQ<T> {
    /* 添加具有给定优先级值的项目。如果项目已经存在，则抛出 IllegalArgumentException。
    *  您可以假设该项目永远不会为空。 */
    void add(T item, double priority);
    /* 如果 PQ 包含给定的项目，则返回 true */
    boolean contains(T item);
    /* 返回最小项。如果 PQ 为空则抛出 NoSuchElementException */
    T getSmallest();
    /* 删除并返回最小项。如果 PQ 为空则抛出 NoSuchElementException */
    T removeSmallest();
    /* 返回 PQ 中的项目数 */
    int size();
    /* 更改给定项目的优先级。如果该项不存在，则抛出 NoSuchElementException */
    void changePriority(T item, double priority);
}