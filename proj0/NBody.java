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
        // prt1.收集需要的输入
        // make StringToDouble方法--> Double.parseDouble
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // prt2.设置比例 使其与宇宙的半径相匹配
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

        StdDraw.enableDoubleBuffering();

        // prt3.创建一个时间变量，并将其设置为0。设置一个循环，循环直到这个时间变量为T
        double time = 0.0;
        while(time < T) {
            // 创建xForces数组和yForces数组
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            // 计算每个行星的净 x 和 y 力，分别将它们存储在 xForces和yForces数组中
            for(int i = 0; i < planets.length; i++)  {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            // 在每个行星上调用更新。这将更新每个行星的位置、速度和加速度
            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // 绘制背景图像
            StdDraw.clear();
            StdDraw.picture(0,0, "images/starfield.jpg");
            // 画出所有的行星
            for (Planet planet : planets) {
                planet.draw();
            }
            // 显示屏幕外缓冲区
            StdDraw.show();
            // 暂停动画 10 毫秒
            StdDraw.pause(10);
            // 将您的时间变量增加dt
            time += dt;
        }

        // prt4.打印宇宙
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}