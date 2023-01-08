/**
 * 表示飞行问题中的飞行
 * */
public class Flight {
    // TODO
    public int startTime;
    public int endTime;
    public int personNum;

    public Flight(int start, int end, int p) {
        startTime = start;
        endTime = end;
        personNum = p;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPersonNum() {
        return personNum;
    }
}