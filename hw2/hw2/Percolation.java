package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.EventListenerProxy;

/**
 * 这项任务的部分目标是学习如何根据已经解决的问题（不相交集，又称联合查找）来解决一个问题（渗透）。
 * */
public class Percolation {
    private boolean[][] grid;   // 网格
    private int openNum;   // 打开站点数
    private int len;       // 每行长度
    private int top;       // 顶部
    private int bottom;    // 底部
    private WeightedQuickUnionUF uf;  // 加权快速联合

    /**
     * 创建N乘N网格，最初阻止所有站点
     * */
    public Percolation(int N) {
        grid = new boolean[N][N];
        // 虚拟顶部和虚拟底部站点
        uf = new WeightedQuickUnionUF(N * N + 2);
        openNum = 0;
        len = N;
        top = N * N;
        bottom = N * N + 1;
    }

    /**
     * 如果站点尚未打开，请打开该站点（行、列）
     * */
    public void open(int row, int col) {
        if(row < 0 || col < 0 || row >= len || col >= len) {
            throw new IndexOutOfBoundsException();
        }
        if(!grid[row][col]) {
            grid[row][col] = true;
            openNum += 1;
        } else {
            return;
        }

        openHelper(row, col);
        if(row == 0) {
            uf.union(xToy(row, col), top);
        }
        if(row == len - 1) {
            uf.union(xToy(row, col), bottom);
        }
    }

    // 下
    public int xToy (int row, int col) {
        return row * len + col;
    }

    public void openHelper(int row, int col) {
        int cur = xToy(row, col);

        // 左
        if(col > 0) {
            int left = xToy(row, col - 1);
            if(grid[row][col - 1]) {
                uf.union(left, cur);
            }
        }

        // 右
        if(col < len - 1) {
            int right = xToy(row, col + 1);
            if(grid[row][col + 1]) {
                uf.union(cur, right);
            }
        }

        if(row > 0) {
            int top = xToy(row - 1, col);
            if(grid[row - 1][col]) {
                uf.union(top, cur);
            }
        }

        if(row < len - 1) {
            int bottom = xToy(row + 1, col);
            if(grid[row + 1][col]) {
                uf.union(cur, bottom);
            }
        }
    }

    // 站点（行、列）是否打开？
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // 站点（行、列）满了吗？
    public boolean isFull(int row, int col) {
        return uf.connected(top, xToy(row, col));
    }

    // 开放站点数量
    public int numberOfOpenSites() {
        return openNum;
    }

    // 系统是否渗透？
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

/*    // 用于单元测试（不需要，但请将其保存在此处以供签名者使用）
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
    }*/
}
