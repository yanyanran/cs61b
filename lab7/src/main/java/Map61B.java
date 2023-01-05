import java.util.Set;
/* 你的实现 BSTMap 应该实现这个接口。
    为此，请将“implements Map61B<K,V>”附加到“public class...”声明的末尾，但如果您愿意，也可以使用其他正式类型参数。
 */
public interface Map61B<K, V> extends Iterable<K> {
    void clear();
    boolean containsKey(K key);
    V get(K key);
    int size();
    void put(K key, V value);
    Set<K> keySet();
    V remove(K key);
    V remove(K key, V value);
}