public class arrayTest {
    public static void main(String[] args) {
        int[][] x = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // copy point
        int[][] z = new int[3][];
        z[0] = x[0];
        z[1] = x[1];
        z[2] = x[2];
        z[0][0] = -z[0][0];

        // copy value
        int[][] w = new int[3][3];
        System.arraycopy(x[0], 0, w[0], 0, 3);
        System.arraycopy(x[1], 0, w[1], 0, 3);
        System.arraycopy(x[2], 0, w[2], 0, 3);
        w[0][0] = -w[0][0];

        System.out.println(x[0][0]);    // -1
        System.out.println(w[0][0]);    // 1

        int[] a = {1,2,3};
        int[] b = new int[3];

        b[0] = a[0];
        b[0] = -b[0];
        System.out.println(a[0]);   // 1

        b = a;
        b[0] = -b[0];
        System.out.println(a[0]);   // -1
    }
}