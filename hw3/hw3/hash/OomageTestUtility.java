package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * 编写一个实用函数，如果给定的 oomages 具有可以将它们相当均匀地分布在 M 个桶中的 hashCodes，则该函数返回 true。
         * 为此，请以与可视化器中相同的方式转换每个 oomage 的哈希码，即 (& 0x7FFFFFFF) % M。
         * 并确保没有桶的 Oomage 少于 N / 50，并且没有桶的 Oomage 超过 N / 2.5。
         */
        int bucketNum = 0;
        int[] hash = new int[M];
        int N = oomages.size();

        for(Oomage o : oomages) {
            /**k & 0x7FFFFFFF 是做什么的？
             它返回一个等于 k 的整数，但最高位设置为零。*/
            bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            hash[bucketNum] += 1;
        }
        for(int i = 0; i < M; i ++) {
            if(hash[i] < N / 50 || hash[i] > N / 2.5) {
                return false;
            }
        }
        return true;
    }
}
