/**
 * 这个抽象数据结构与第 20 讲中描述的 MinPQ ADT 之间主要区别：
 *
 * 优先级与对象无关。不依赖某种比较函数来决定哪个项目小于另一个，而是使用addorchangePriority函数简单地分配一个优先级值。
 * 有个附加changePriority功能允许我们在添加项目后设置项目的外部优先级。
 * */
public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {

    // 添加T具有给定优先级的类型的项目
    @Override
    public void add(T item, double priority) {

    }

    // 如果 PQ 包含给定的项目，则返回 true
    @Override
    public boolean contains(T item) {
        return false;
    }

    // 返回具有最小优先级的项目
    @Override
    public T getSmallest() {
        return null;
    }

    // 删除并返回优先级最低的项目
    @Override
    public T removeSmallest() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    // 将给定项目的优先级设置为给定值
    @Override
    public void changePriority(T item, double priority) {

    }
}