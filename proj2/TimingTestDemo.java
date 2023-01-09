import edu.princeton.cs.algs4.Stopwatch;
import java.util.Random;

/**
 * Created by hug.
 * 演示如何使用 System.currentTimeMillis 或 Princeton Stopwatch 类对时间代码进行计时。
 */
public class TimingTestDemo {
    Random rand = new Random();

    public void naivePQTime() {
        NaiveMinPQ<String> naive = new NaiveMinPQ<String>();
        for(int i = 0; i < 100000; i++) {
            naive.add("item" + i, rand.nextInt());
        }
        for(int i = 0; i < 1000; i++) {
            naive.changePriority("item" + i, rand.nextDouble());
        }
        for(int i = 0; i < 1000; i++) {
            naive.getSmallest();
            naive.removeSmallest();
        }


    }
    public void arrayPQTime() {

        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>(16);
        for(int i = 0; i < 100000; i++) {
            pq.add("item" + i, rand.nextInt());
        }
        for(int i = 0; i < 1000; i++) {
            pq.changePriority("item" + i, rand.nextDouble());
        }
        for(int i = 0; i < 1000; i++) {
            pq.getSmallest();
            pq.removeSmallest();
        }

    }
    public static void main(String[] args) {
        TimingTestDemo pqTest = new TimingTestDemo();
        Stopwatch sw2 = new Stopwatch();
        pqTest.arrayPQTime();
        System.out.println("ArrayHeapMinPQ " + sw2.elapsedTime());
        Stopwatch sw = new Stopwatch();
        pqTest.naivePQTime();
        System.out.println("NaiveMinPQ " + sw.elapsedTime());



//        long start = System.currentTimeMillis();
//        int sum = 0;
//        for (int i = 0; i < 100000; i += 1) {
//            for (int j = 0; j < 10000; j += 1) {
//                sum = sum + i + j;
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("Total time elapsed: " + (end - start)/1000.0 +  " seconds.");
//
//        Stopwatch sw = new Stopwatch();
//        for (int i = 0; i < 100000; i += 1) {
//            for (int j = 0; j < 10000; j += 1) {
//                sum = sum + i + j;
//            }
//        }
//        System.out.println("Total time elapsed: " + sw.elapsedTime() +  " seconds.");
    }
}