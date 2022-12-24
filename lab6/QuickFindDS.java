/**
 * 快速查找:
 * 数组的索引(id)代表我们集合的元素
 * 索引处的值(id[i])是它所属的集合编号
 * */
public class QuickFindDS implements DisjointSets {
    private int[] id;

    /*  O(n) */
    public QuickFindDS(int num) {
        id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }
    }

    /*  O(n) */
    // 修改id[i]
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /* Θ(1) */
    public boolean isConnected(int p, int q) {
        return (id[p] == id[q]);
    }
}
