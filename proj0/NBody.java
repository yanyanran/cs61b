// 没构造函数。目标是模拟在其中一个数据文件中指定的宇宙
public class NBody {
    // 返回文件中的宇宙半径
    public static double readRadius(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    // 返回与文件中的行星相对应的行星数组
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[num];

        // input
        for(int i = 0; i < num;i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    // main
    public static void main(String[] args) {

    }
}