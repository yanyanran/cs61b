package hw3.hash;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestComplexOomage {

    @Test
    public void testHashCodeDeterministic() {
        ComplexOomage so = ComplexOomage.randomComplexOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    /* 如果您的 OomageTestUtility.haveNiceHashCodeSpread 正确，这应该通过。
       即使我们给定的 ComplexOomage 类有一个有缺陷的 hashCode，也是如此。*/
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(ComplexOomage.randomComplexOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /* TODO: 创建名为 deadlyList 的 Complex Oomages 列表
     * 这显示了 hashCode 函数中的缺陷。
     */
    @Test
    public void testWithDeadlyParams() {
        List<Oomage> deadlyList = new ArrayList<>();

        // Your code here.
        int N = 100;
        while(N > 0) {
            List<Integer> params = new ArrayList<>();
            for(int n = 0; n < 4; n ++) {
                params.add(StdRandom.uniform(255));
            }

            for(int n = 0; n < 4; n ++) {
                params.add(n);
            }

            ComplexOomage complex = new ComplexOomage(params);
            for(int i : params) {
                System.out.print(i + " ");
            }
            System.out.println(complex.hashCode());
            deadlyList.add(complex);
            N -= 1;
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(deadlyList, 10));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestComplexOomage.class);
    }
}
