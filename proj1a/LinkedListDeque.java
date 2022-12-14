class LinkedListDeque<T> {
    private class Node {
        public Node next;
        public Node prev;
        public T item;

        private Node(Node prev, Node next, T item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private int size;
    private Node sentinel;

    /**
     * 创建一个空链表双端队列
     * */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * 创建的深拷贝other
     * */
    // 创建深拷贝意味着您创建一个全新的LinkedListDeque，具有与other. 但是，它们应该是不同的对象，即如果您更改other，您创建的新对象LinkedListDeque也不应更改
    public LinkedListDeque(LinkedListDeque other) {

    }

    // add和remove操作不得涉及任何循环或递归
    /**
     * 添加一个类型的项目T到双端队列的前面
     * */
    public void addFirst(T item) {

    }

    /**
     * 添加一个类型的项目T到双端队列的后面
     * */
    public void addLast(T item) {

    }

    /**
     * 如果双端队列为空，则返回 true，否则返回 false
     * */
    public boolean isEmpty() {

    }

    /**
     * 返回双端队列中的项目数
     * */
    public int size() {

    }

    /**
     * 从头到尾打印双端队列中的项目，以空格分隔。打印完所有项目后，打印出新的一行
     * */
    public void printDeque() {

    }

    /**
     * 删除并返回双端队列前面的项目。如果不存在这样的项目，则返回 null
     * */
    public T removeFirst() {

    }

    /**
     * 删除并返回双端队列后面的项目。如果不存在这样的项目，则返回 null
     * */
    public T removeLast() {

    }

    /**
     * 获取给定索引处的项目，其中 0 是前面的项目，1 是下一个项目，依此类推。如果不存在这样的项目，则返回 null。不能改变双端队列
     * */
    // 不得递归
    public T get(int index) {

    }

    /**
     * 与get相同，但使用递归
     * */
    public T getRecursive(int index) {

    }
}