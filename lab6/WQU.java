// 基于快联，发现无论何时调用find，都必须爬到树的根部 --> 树越短，速度越快
// 为了避免每次 谁合并谁 通过传参顺序决定（如果遇到了 小树在前大树在后 的情况就只能大合小，find很费时间不灵活）
/**
 * 加权快速联合（WQU）：
 * 数组存放的依旧是父节点下标
 * 改动在于：将root节点存放的-1改为-size（找的时候只需对比然后让size小的合并）
 *
 * runtimes: O(log N)
 * */

/* 应正确处理错误输入，例如:如果将无效顶点传递给上述函数，则抛出 IllegalArgumentException */
public class WQU {
    // 创建一个包含顶点的 UnionFind 数据结构n。最初，所有顶点都在不相交的集合中
    public UnionFind(int n) {

    }

    // v1如果不是有效索引，则抛出异常
    public void validate(int v1) {

    }

    // 返回集合v1所属的大小
    public int sizeOf(int v1) {

    }

    // 返回v1的父级。如果v1是树的根，则返回树的负大小v1是根
    public int parent(int v1) {

    }

    // 如果节点v1和v2已连接，则返回 true
    public boolean connected(int v1, int v2) {

    }

    // 将两个元素v1和v2连接在一起。v1和v2可以是任何有效元素，并使用大小联合启发式。如果集合的大小相等，则通过将v1的根连接到v2的根来打破平局。将顶点与其自身或已连接的顶点统一不应改变集合，但可能会改变数据结构的内部结构
    public void union(int v1, int v2) {

    }

    // 返回v1所属的集合的根。采用路径压缩，允许快速搜索时间
    public int find(int v1) {

    }
}