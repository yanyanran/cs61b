// 基于快查 提升connect的速度
/**
 * 快速联合:
 * 数组的索引(id)代表 集合的元素
 * 索引处的值(id[i])是 其父项的索引，没有父项就是一个“根”，为它分配一个负值(-1)
 * */
public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    // nice:O(1) / bad:O(n)
    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}