import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V> {
    private int initialSize = 16;
    private double loadFactor = 0.75;
    private int size;
    // 哈希桶实现（利于解决哈希冲突）
    private Entry[] buckets = new Entry[initialSize];
    private HashSet<K> keys = new HashSet<>();

    // 桶链表节点类
    private static class Entry {
        public Object key;
        public Object val;
        public Entry next;

        public Entry(Object k, Object v, Entry n) {
            key = k;
            val = v;
            next = n;
        }
    }

    // 构造函数*3
    public MyHashMap() {
        buckets = new Entry[initialSize];
        size = 0;
    }

    public MyHashMap(int initialSize) {
        this.initialSize = initialSize;
        buckets = new Entry[initialSize];
        size = 0;
    }

    public MyHashMap(int initialSize, double loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        buckets = new Entry[initialSize];
        size = 0;
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new Entry[initialSize];
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(Object key, Object value) {

    }

    /*
    * 返回此映射中包含的关键点的Set视图
    * */
    @Override
    public Set<K> keySet() {
        return keys;
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}