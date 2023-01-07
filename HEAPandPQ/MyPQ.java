public class MyPQ<T extends Comparable<T>> implements MyQueue<T> {
    private MaxHeap<T> maxHeap;

    public MyPQ() {
        maxHeap = new MaxHeap<T>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队(添加元素)
     *
     * @param element 需要添加的元素
     */
    @Override
    public void enqueue(T element) {
        maxHeap.addEleMethod2(element);
    }

    /**
     * 出队(删除元素)
     * 删除优先级高的节点
     */
    @Override
    public T dequeue() {
        return maxHeap.pollMaxPriorityMethod2();
    }

    /**
     * 获取队首元素
     */
    @Override
    public T getFront() {
        return maxHeap.getFrontNode();
    }
}
