import java.security.Key;

public class Structure {
    // 树表示
    // 固定数量的链接
    public class Tree1A {
        Key k;
        Tree1A left;
        Tree1A middle;
        Tree1A right;
    }

    // 子链接数组
    public class Tree1B<Key> {
        Key k;
        Tree1B[] children;
    }

    // 长子/兄弟链接
    public class Tree1C<Key> {
        Key k;
        Tree1C favoredChild;
        Tree1C sibling;
    }

    // 不相交集Disjoint Sets
    public class Tree2<Key> {
        Key[] keys;
        int[] parents;
    }

    // 数组
    public class TreeC<Key> {
        Key[] keys;
    }
}