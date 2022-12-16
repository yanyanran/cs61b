/** Array based list.
 *  @author Josh Hug
 */

public class AList<BOOM> {
    private BOOM[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        // java不允许使用泛型数组
        // items = new BOOM[100];
        items = (BOOM[])new Object[100];
        size = 0;
    }

    // 添加扩容判断
    private void resize(int capacity) {
        BOOM[] a =(BOOM[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(BOOM x) {
        if(size == items.length) {
            resize(size * 1000);    // * make run time more quick
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public BOOM getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public BOOM get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public BOOM removeLast() {
        BOOM x = getLast();
        /** 将“删除”的所有项目清空 */
        items[size - 1] = null; // 微妙的性能错误--不注意可能会导致内存的严重浪费
        size = size - 1;
        return x;
    }
} 