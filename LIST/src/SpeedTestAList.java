//  ”time java SpeedTestAList“ to test it's run time
public class SpeedTestAList {
    public static void main(String[] args) {
        AList L = new AList();
        int i = 0;
        while(i < 100000) {
            L.addLast(i);
            i++;
        }
    }
}