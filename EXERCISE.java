package PACKAGE_NAME;

class Circle {   // Circle类
    public double radius; // 半径
    public final double PI = 3.14;

    // 得半径
    public double getRadius() {
        return radius;
    }
    // 求面积
    public double getArea() {
        return radius * radius * PI;
    }
    // 有参构造
    public Circle(double radius) {
        this.radius = radius;
    }
}

public class EXERCISE {
        public static void main(String[] args)
        {
            Circle[] circleArray = createCircleArray();
           printCircleArray(circleArray);
        }

        public static Circle[] createCircleArray()
        {
            Circle[] circleArray = new Circle[5];

            for(int i = 0;i < circleArray.length; i++)
            {
                circleArray[i] = new Circle(Math.random() * 100);
            }
            return circleArray;
        }

        public static void printCircleArray(Circle[] circleArray)
        {
            System.out.printf("%-30s%-15s\n","Radius","Area");
            for(int i = 0; i<circleArray.length; i++)
            {
                System.out.printf("%-30s%-15s\n", circleArray[i].getRadius(), circleArray[i].getArea());
            }
            System.out.println("-----------------------------------");

            System.out.printf("%-30s%-15f\n","The total area of circles is", sum(circleArray));
        }

        public static double sum(Circle[] circleArray)
        {
            double sum = 0;
            for(int i = 0; i <circleArray.length; i++)
            {
                sum += circleArray[i].getArea();
            }
            return sum;
        }
    }