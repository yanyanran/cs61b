// 不相交集设计的四次迭代：快速查找 → 快速联合 → 加权快速联合 (WQU) → 带路径压缩的WQU
public interface DisjointSets {
    /** connects two items P and Q */
    void connect(int p, int q);
    /** checks to see if two items are connected */
    boolean isConnected(int p, int q);
}