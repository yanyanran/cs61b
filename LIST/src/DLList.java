public class DLList<AHH> {
    public class StuffNode {
        public AHH item;
        public StuffNode next;
        public StuffNode(AHH i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode first;
    private int size;

    public DLList() {
        first = null;
        size = 0;
    }

    public DLList(AHH x) {
        first = new StuffNode(x, null);
        size = 1;
    }

    public void addFirst(AHH x) {
        first = new StuffNode(x, first);
        size += 1;
    }

    public AHH getFirst() {
        return first.item;
    }

    public int size() {
        return size;
    }

    public void addLast(AHH x) {
        StuffNode p = first;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    public static void main(String[] args) {
        DLList<String> s1 = new DLList<>("string 1");
        s1.addFirst("string 2");
        System.out.println(s1);
    }
}