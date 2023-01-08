import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightSolverTest {
    /**
     * 构造一个航班数组列表
     * 其中第 i 个航班在 startTimes 中具有第 i 个开始时间，在 endTimes 中具有第 i 个结束时间，在 passengerCounts 中具有第 i 个计数
     * 参数必须具有相同的长度
     */
    ArrayList<Flight> makeFlights(int[] startTimes, int[] endTimes, int[] passengerCounts) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            flights.add(new Flight(startTimes[i], endTimes[i], passengerCounts[i]));
        }
        return flights;
    }

    /**
     * 在没有重叠航班的情况下进行测试
     */
    @Test
    public void naiveTest() {
        int[] startTimes = {10, 20, 30, 40};
        int[] endTimes = {19, 29, 39, 49};
        int[] passengerCounts = {1, 2, 3, 4};
        FlightSolver solver = new FlightSolver(makeFlights(startTimes, endTimes, passengerCounts));
        assertEquals(4, solver.solve());
    }

    /**
     * 测试一次重叠飞行
     */
    @Test
    public void smallTest() {
        int[] startTimes = {10, 20, 40};
        int[] endTimes = {25, 35, 49};
        int[] passengerCounts = {1, 4, 3};
        FlightSolver solver = new FlightSolver(makeFlights(startTimes, endTimes, passengerCounts));
        assertEquals(5, solver.solve());
    }

    /**
     * 测试一些重叠的航班
     */
    @Test
    public void mediumTest() {
        int[] startTimes = {15, 23, 18, 42, 55, 75, 78};
        int[] endTimes = {27, 45, 44, 65, 90, 95, 85};
        int[] passengerCounts = {20, 30, 10, 25, 5, 10, 15};
        FlightSolver solver = new FlightSolver(makeFlights(startTimes, endTimes, passengerCounts));
        assertEquals(65, solver.solve());
    }
}