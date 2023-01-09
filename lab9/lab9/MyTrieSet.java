package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trie 是 Sets 和 Maps 的特定实现，专门用于字符串
 *
 * 每个节点只存储一个字母
 * 由于要共享节点，我们必须想出一些方法来表示哪些字符串属于我们的集合，哪些不属于。
 * 我们将通过将每个字符串的最后一个字符的颜色标记为蓝色来解决这个问题
 * */
public class MyTrieSet implements TrieSet61B{
    private class Node {
        char val;
        Boolean isKey;  // true为蓝色(end)
        // Character类用于对单个字符进行操作
        Map<Character, Node> next;

        public Node() {
            isKey = false;
        }
    }
    private Node root;

    public MyTrieSet() {
        root = new Node();
        root.isKey = false;
        root.next = new HashMap<>();
    }

    @Override
    public void clear() {
        root = new Node();
        root.isKey = false;
        root.next = new HashMap<>();
    }

    @Override
    public boolean contains(String key) {
        if(key == null) {
            throw new IllegalArgumentException("error: key不能为空!");
        }
        Node cur = root;
        for(int i = 0; i < key.length(); i++) {
            char k = key.charAt(i);
            /** 如果Trie包含KEY，则返回true，否则返回false */
            if(cur.next.containsKey(k)) {
                cur = cur.next.get(k);
            } else {
                return false;
            }
        }
        if(!cur.isKey) {
            return false;
        }
        return true;
    }

    @Override
    public void add(String key) {
        Node cur = root;
        for(int i = 0; i < key.length(); i++) {
            if(cur.next == null) {
                Node n = new Node();
                n.val = key.charAt(i);
                // 标记end位
                if(i == key.length() - 1) {
                    n.isKey = true;
                }
                cur.next = new HashMap<>();
                cur.next.put(key.charAt(i), n);
                cur = n;
                continue;
            }

            char k = key.charAt(i);
            if(cur.next.containsKey(k)) {
                cur = cur.next.get(k);
                if(i == key.length() - 1) {
                    cur.isKey = true;
                }
            } else {
                Node n = new Node();
                n.val = k;
                if(i == key.length() - 1) {
                    n.isKey = true;
                }
                cur.next.put(n.val, n);
                cur = n;
            }
        }
    }

    /** 返回以prefix开头的所有单词的列表 */
    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            if(cur.next == null) {
                return null;
            }
            char k = prefix.charAt(i);
            if(cur.next.containsKey(k)) {
                cur = cur.next.get(k);
            } else {
                return null;
            }
        }
        res = prefixHelper(res, prefix, cur);
        return res;
    }

    // helper
    private List<String> prefixHelper(List<String> res, String s, Node n) {
        if(n.next == null) {
            return null;
        }
        for(Map.Entry<Character, Node> cur : n.next.entrySet()) {
            if(cur.getValue().isKey) {
                res.add(s + cur.getKey());
            }
            if(cur.getValue().next != null) {
                // 递归
                prefixHelper(res, s + cur.getKey(), cur.getValue());
            }
        }
        return res;
    }

    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }
}