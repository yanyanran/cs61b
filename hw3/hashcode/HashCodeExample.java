package hashcode;

import java.util.HashSet;
import java.util.Set;

/**
 *  Set 正常使用
 * */
public class HashCodeExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet();
        set.add("Java");
        set.add("Java");
        set.add("MySQL");
        set.add("MySQL");
        set.add("Redis");
        System.out.println("Set 集合长度:" + set.size());
        System.out.println();
        // 打印 Set 中的所有元素
        set.forEach(d -> System.out.println(d));
    }
}