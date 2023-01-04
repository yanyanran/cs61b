package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 如果N≤0 或T≤0 ，构造函数应该抛出一个java.lang.IllegalArgumentException
 * */
public class PercolationStats {
    private Percolation p;
    private int repeat;
    private int[] openNum;
    private int size;

    // 在N乘N网格上执行T个独立实验
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if(N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N和T应大于0!");
        }
        p = pf.make(N);
        repeat = T;
        openNum = new int[T];   // 渗透时OpenSites的数量
        size = N * N;
        while(repeat > 0) {
            while(!p.percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                p.open(row, col);
            }
            openNum[repeat - 1] = p.numberOfOpenSites();
            repeat -= 1;
            p = pf.make(N);
        }
    }

    // 逾渗阈值的样本均值
    public double mean() {
        int sum = 0;
        for(int i = 0; i < openNum.length; i++) {
            sum += openNum[i];
        }
        return ((double) sum/openNum.length) / size;
    }

    // 渗滤阈值的样本标准差
    public double stddev() {
        double[] fractionOpen = new double[openNum.length];
        for(int i = 0; i < openNum.length; i++) {
            fractionOpen[i] = (double)openNum[i]/size;
        }
        return StdStats.stddev(fractionOpen);
    }

    // 95%置信区间的低终点
    public double confidenceLow() {
        return mean() - stddev();
    }

    // 95%置信区间的高终点
    public double confidenceHigh() {
        return mean() + stddev();
    }

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        Stopwatch timer1 = new Stopwatch();
        PercolationStats ps = new PercolationStats(10, 100, pf);
        System.out.println("N = 10: " + timer1.elapsedTime());

        Stopwatch timer2 = new Stopwatch();
        PercolationStats ps2 = new PercolationStats(20, 100, pf);
        System.out.println("N = 20: " + timer2.elapsedTime());

//        System.out.println(ps.mean());
//        System.out.println(ps.stddev());
//        System.out.println(ps.confidenceLow());
//        System.out.println(ps.confidenceHigh());
    }
}
