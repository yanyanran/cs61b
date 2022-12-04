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
        // 收集需要的输入
        // make StringToDouble方法--> Double.parseDouble
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // 设置比例 使其与宇宙的半径相匹配
        // 图像starfield.jpg作背景
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0, "images/starfield.jpg");
        StdDraw.show();
        StdDraw.pause(20);

        // use Planet.draw to build
        for (Planet planet : planets) {
            planet.draw();
        }
    }
}