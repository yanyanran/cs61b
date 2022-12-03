// 没构造函数。目标是模拟在其中一个数据文件中指定的宇宙
public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        double radius = in.readDouble();
        return radius;
    }
}