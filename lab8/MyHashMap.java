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

    /**
     * 哈希取模
     * */
    public int hash(K key) {
        return Math.floorMod(key.hashCode(), initialSize);
    }

    // 如果此映射包含指定键的映射，返回true
    @Override
    public boolean containsKey(K key) {
        int h = hash(key);
        if(buckets == null) {
            return false;
        }
        Entry cur = buckets[h];
        while(cur != null) {
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int h = hash(key);
        if(buckets == null) {
            return null;
        }
        for(Entry e = buckets[h]; e != null; e = e.next) {
            if(e.key.equals(key)) {
                return (V) e.val;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    // 使用现有key更新value
    @Override
    public void put(K key, V value) {
        int h = hash(key);
        // 找到存在现有哈希桶
        for (Entry e = buckets[h]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.val = value;
                return;
            }
        }
        // 不存在现有的 new一个
        buckets[h] = new Entry(key, value, buckets[h]);
        size += 1;
        keys.add(key);
        // 考虑扩容
        if ((double) size / initialSize > loadFactor) {
            resize();
        }
    }

    public void resize() {
        int updateSize = initialSize * 2;
        MyHashMap<K, V> hm = new MyHashMap<>(updateSize, loadFactor);
        hm.putAll(this);
        copyFrom(hm);
    }

    public void putAll(MyHashMap<K, V> old) {
        for(Entry e : old.buckets) {
            if(e == null) continue;
            while (e != null) {
                put((K)e.key, (V)e.val);
                e = e.next;
            }
        }
    }

    public void copyFrom(MyHashMap<K, V> newMap) {
        size = newMap.size;
        buckets = newMap.buckets;
        loadFactor = newMap.loadFactor;
        initialSize = newMap.initialSize;
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
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}