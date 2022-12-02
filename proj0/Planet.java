// no static
public class Planet {
    private static final double gravConstant = 6.67e-11;

    public double xxPos = 1.0;  // 当前的 x 位置
    public double yyPos = 2.0;  // 当前的 y 位置
    public double xxVel = 3.0;  // 在 x 方向上的当前速度
    public double yyVel = 4.0;  // 在 y 方向上的当前速度
    public double mass = 5.0;  // 质量
    public String imgFileName = "jupiter.gif";  // 与描绘行星的图像对应的文件的名称

    // 构造函数1
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    // 构造函数2
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    // 计算距离
    public double calcDistance(Planet p) {
        double distanceX = p.xxPos - xxPos;
        double distanceY = p.yyPos - yyPos;
        // 开方：Math.sqrt()
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    // 返回一个给定行星对该行星施加的力值(总力)
    public double calcForceExertedBy(Planet p) {
        double dis = calcDistance(p);
        return gravConstant * mass * p.mass / (dis * dis);
    }

    // 返回在X和Y方向上施加的力
    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    // 接收一个行星数组，并计算该数组中所有行星对当前行星施加的净X和净Y力
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceX = 0.0;
        for (Planet planet : allPlanets) {
            if (!(this.equals(planet))) {   // 行星无法对自身施加引力
                netForceX += this.calcForceExertedByX(planet);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceY = 0.0;
        for (Planet planet : allPlanets) {
            if (!(this.equals(planet))) {
                netForceY += this.calcForceExertedByY(planet);
            }
        }
        return netForceY;
    }
}