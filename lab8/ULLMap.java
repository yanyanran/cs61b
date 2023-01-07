import java.util.Iterator;
import java.util.Set;

/** 一种使用链表存储键值对的数据结构。
    任何键在字典中最多只能出现一次，但值可以出现多次。
    关键操作是 get(key)、put(key, value) 和 contains(key) 方法。
    与键关联的值是最后一次使用该键调用 put 时的值。 */
public class ULLMap<K, V>  implements Map61B<K, V> {
    int size = 0;

    /** 返回对应于 KEY 的值，如果不存在这样的值，则返回 null。 */
    public V get(K key) {
        if (list == null) {
            return null;
        }
        Entry lookup = list.get(key);
        if (lookup == null) {
            return null;
        }
        return lookup.val;
    }

    @Override
    public int size() {
        return size;
    }

    /** 从此映射中删除所有映射。 */
    @Override
    public void clear() {
        size = 0;
        list = null;
    }

    /** 将 KEY 和 VALUE 的键值对插入此字典，替换与 KEY 关联的先前值（如果有）。 */
    public void put(K key, V val) {
        if (list != null) {
            Entry lookup = list.get(key);
            if (lookup == null) {
                list = new Entry(key, val, list);
            } else {
                lookup.val = val;
            }
        } else {
            list = new Entry(key, val, list);
            size = size + 1;
        }
    }

    /** 当且仅当此字典包含 KEY 作为某个键值对的键时才返回 true。 */
    public boolean containsKey(K key) {
        if (list == null) {
            return false;
        }
        return list.get(key) != null;
    }

    @Override
    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    /** 键和值存储在 Entry 对象的链接列表中。
     * 此变量存储此链表中的第一对。 */
    private Entry list;

    /** 表示存储字典中键值对的链表中的一个节点。 */
    private class Entry {

        /** 将KEY作为这个键值对中的键，VAL作为值，NEXT作为链表的下一个节点。 */
        Entry(K k, V v, Entry n) {
            key = k;
            val = v;
            next = n;
        }

        /** 返回此键值对链表中键等于 KEY 的 Entry，如果不存在这样的 Entry，则返回 null。 */
        Entry get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(key);
        }

        /** 存储该节点在列表中的键值对的值。 */
        K key;
        /** 存储该节点在列表中的键值对的值。 */
        V val;
        /** 将下一个条目存储在链表中。 */
        Entry next;

    }

    /**迭代字典键的迭代器。 */
    private class ULLMapIter implements Iterator<K> {

        /** 通过将 cur 设置为链表中存储键值对的第一个节点来创建一个新的 ULLMapIter。 */
        public ULLMapIter() {
            cur = list;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public K next() {
            K ret = cur.key;
            cur = cur.next;
            return ret;
        }


        /** 存储当前的键值对。 */
        private Entry cur;

    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

}