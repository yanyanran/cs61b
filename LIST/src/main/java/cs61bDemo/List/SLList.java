package cs61bDemo.List;

import edu.princeton.cs.algs4.In;

/**
 * SLList充当列表用户和裸递归数据结构之间的中间人
 * */
public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int x, Object o) {
        }

        public void IntLNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    // 同一文件内的代码访问
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        // 虚拟哨兵节点
        sentinel = new IntNode(63, null);
        // 第一个结点(first
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p =  sentinel;     // add ptr p

        // 哨兵永远不可能为空，所以可以去掉
        /*if(first == null) {
            first = new IntNode(x, null);
            return ;
        }*/

        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    // 创建一个与底层裸递归数据结构交互的私有辅助方法
    private static int size(IntNode p) {
        if(p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    // 重载
    public int size() {
        return size(first);
    }

    public static void main(String[] args) {
        // Text
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        int x = L.getFirst();
        System.out.println(x);

        // =
        IntNode L0 = new IntNode(10, L);
        L0 = new IntNode(5, L);
        int x0 = L0.item;
        System.out.println(x0);
    }
}