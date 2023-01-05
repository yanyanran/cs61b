import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private int size;
    private Node root;
    public class Node {
        public Node left, right;
        public K key;
        public V val;

        public Node(K k, V v) {
            key = k;
            val = v;
            left = null;
            right = null;
        }
    }

    public BSTMap() {
        size = 0;
        root = null;
    }

    /** 从此映射中删除所有映射。 */
    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    /* 如果此映射包含指定键的映射，则返回 true。 */
    @Override
    public boolean containsKey(K key) {
        Node cur = root;
        while(cur != null) {
            if(cur.key.compareTo(key) == 0) {
              return true;
            }
            // 包含探到底
            if(cur.key.compareTo(key) > 0) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return false;
    }

    /* 返回指定键映射到的值，如果是，则返回 null
     * 映射不包含键的映射。
     */
    @Override
    public V get(K key) {
        Node cur = null;
        while(cur != null) {
            if(cur.key.compareTo(key) == 0) {
                return cur.val;
            }
            if(cur.key.compareTo(key) > 0) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }

    /* 返回此映射中键值映射的数量。 */
    @Override
    public int size() {
        return size;
    }

    /* 将指定值与此映射中的指定键相关联。 */
    @Override
    public void put(K key, V value) {
        if(containsKey(key)) {
            return;
        }
        // 当前树为空
        if(root == null) {
            root = new Node(key, value);
            size += 1;
            return;
        }

        Node cur = root;
        while (root != null) {
            // 比当前节点小
            if(cur.key.compareTo(key) > 0) {
                if(cur.left == null) {
                    cur.left = new Node(key, value);
                    size += 1;
                    return;
                } else {
                    cur = cur.left;
                }
            }
            // 比当前节点大
            if(cur.key.compareTo(key) < 0) {
                if (cur.right == null) {
                    cur.right = new Node(key, value);
                    size += 1;
                    return;
                } else {
                    cur = cur.right;
                }
            }
        }
    }

    /* 返回此映射中包含的键的 Set 视图。 */
    /**
     * 集合不是一个类，它是一个接口。
     * 只能实例化实现Set（HashSet、LinkedHashSet或TreeSet）的类
     * */
    private void keySetHelper(Set<K> keySet, Node node) {
        if(node == null) {
            return;
        }
        keySet.add(node.key);
        if(node.left != null) {
            keySetHelper(keySet, node.left);
        }
        if(node.right != null) {
            keySetHelper(keySet, node.right);
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        keySetHelper(set, root);
        return set;
    }

    /* 从此映射中删除指定键的映射（如果存在）。
     * 实验 8 不需要。如果你不实现这个，抛出一个UnsupportedOperationException
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* 仅当指定键当前映射到指定值时才删除该条目。
   实验 8 不需要。如果您不执行此操作，请抛出 UnsupportedOperationException。
 */
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    /**
     * 按增加键的顺序打印出您的BSTMap
     * */
    public void printInOrder() {
        printHelper(root);
    }

    private void printHelper(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(root.val);
        if(node.left != null) {
            printHelper( node.left);
        }
        if(node.right != null) {
            printHelper(node.right);
        }
    }
}