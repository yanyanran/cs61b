public class LinkedListDeque<T> {
    private class Node {
        private Node next;
        private Node prev;
        private T item;

        private Node(Node prev, Node next, T item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private int size;
    private Node sentinel;

    /**
     * 创建一个空链表双端队列(无参)
     * */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * 创建一链表双端队列(全参)
     * */
    /*public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        Node node = new Node(null,null, x);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }*/

    /**
     * 创建的深拷贝other
     * */
    // 创建深拷贝意味着您创建一个全新的LinkedListDeque，具有与other. 但是，它们应该是不同的对象，
    // 如果您更改other，您创建的新对象LinkedListDeque也不应更改
    /*public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = other.size();

        for(int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }*/

    // add和remove操作不得涉及任何循环或递归
    /**
     * 添加一个类型的项目T到双端队列的前面
     * */
    public void addFirst(T item) {
        Node node = new Node(sentinel, sentinel.next, item);
        (sentinel.next).prev = node;
        sentinel.next = node;
        size++;
    }

    /**
     * 添加一个类型的项目T到双端队列的后面
     * */
    public void addLast(T item) {
        Node node = new Node(sentinel.prev, sentinel, item);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    /**
     * 如果双端队列为空，则返回 true，否则返回 false
     * */
    public boolean isEmpty() {
        /*if(size == 0) {
            return true;
        }
        return false;*/
        // 更聪明版本
        return size == 0;
    }

    /**
     * 返回双端队列中的项目数
     * */
    public int size() {
        return size;
    }

    /**
     * 从头到尾打印双端队列中的项目，以空格分隔。打印完所有项目后，打印出新的一行
     * */
    public void printDeque() {
        Node node = sentinel.next;
        // not null
        while (node != sentinel) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        // Enter
        System.out.println();
    }

    /**
     * 删除并返回双端队列前面的项目。如果不存在这样的项目，则返回 null
     * */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T item = (sentinel.next).item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
    }

    /**
     * 删除并返回双端队列后面的项目。如果不存在这样的项目，则返回 null
     * */
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return item;
    }

    /**
     * 获取给定索引处的项目，其中 0 是前面的项目，1 是下一个项目，依此类推。如果不存在这样的项目，则返回 null。不能改变双端队列
     * */
    // 迭代 不得递归
    public T get(int index) {
        Node p = sentinel.next;
        int cur = 0;

        if (index >= size) {
            return null;
        }
        while (index != cur) {
            p = p.next;
            cur++;
        }
        return p.item;
    }

    /**
     * 与get相同，但使用递归
     * */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursivePro(sentinel, index).item;
    }

    private Node getRecursivePro(Node node, int index) {
        if (index == 0) {
            return node.next;
        }
        return getRecursivePro(node.next, --index);
    }
}
