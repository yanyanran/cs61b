import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 对三个不同的集合实现执行计时测试。
 * 出于 MyHashMap 的目的，假设 <K,V> 是 <String, Integer> 对
 * @author Josh Hug
 * @author Brendan Hu
 */
public class InsertInOrderSpeedTest {
    /**
     * 请求用户输入并执行三种不同集合实现的测试。 ARGS 未使用。
     */
    public static void main(String[] args) throws IOException {
        int N;
        Scanner input = new Scanner(System.in);

        // borrow waitForPositiveInt(Scanner input) from InsertRandomSpeedTest
        InsertRandomSpeedTest i = new InsertRandomSpeedTest();

        System.out.println("\n 该程序将按字典顺序递增的字符串作为 <String, Integer> 对插入到 Maps 中.");

        String repeat = "y";
        do {
            System.out.print("\nEnter # strings to insert into ULLMap: ");
            timeInOrderMap61B(new ULLMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nEnter # strings to insert into MyHashMap: ");
            timeInOrderMap61B(new MyHashMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nEnter # strings to insert into Java's HashMap: ");
            timeInOrderHashMap(new HashMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nWould you like to try more timed-tests? (y/n): ");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /**
     * 返回将 N 个字符串按递增顺序放入 Map61B 所需的时间。
     * 使用 StringUtils.nextString(String s)
     */
    public static double insertInOrder(Map61B<String, Integer> map61B, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            map61B.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 返回将 N 个字符串按递增顺序放入 HashMap 所需的时间。
     */
    public static double insertInOrder(HashMap<String, Integer> ts, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            ts.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 尝试将长度为 L 的 N 个有序字符串插入映射中，
     * 打印 N 次插入调用的时间，否则
     * 打印一条关于错误的好消息
     */
    public static void timeInOrderMap61B(Map61B<String, Integer> map, int N) {
        try {
            double mapTime = insertInOrder(map, N);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 尝试将 N 个长度为 L 的有序字符串插入到 HashMap 中，
     * 打印 N 次插入调用的时间，否则
     * 打印一条关于错误的好消息
     */
    public static void timeInOrderHashMap(HashMap<String, Integer> hashMap, int N) {
        try {
            double javaTime = insertInOrder(hashMap, N);
            System.out.printf("Java's Built-in HashMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* ------------------------------- Private methods ------------------------------- */

    /**
     * 捕获 StackOverflowError 后调用
     * 用相应的 N 和 L 打印错误
     */
    private static void printInfoOnStackOverflow(int N) {
        System.out.println("--Stack Overflow -- couldn't add " + N + " strings.");
    }
}
