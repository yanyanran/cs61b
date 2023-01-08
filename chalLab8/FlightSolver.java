import java.util.*;

/**
 * * CS 61B 2019 年春季中期 2 的飞行问题求解器（#9）
 * 实施一种算法，找出曾经同时飞行的最多人数
 *
 * 假设输入有效，即所有飞行开始时间 >= 结束时间
 * 如果航班的开始时间与航班的结束时间同时开始，则它们被视为同时在空中。
 *
 * 您的算法可以使用我们迄今为止介绍的任何数据结构，但我们建议使用java.util.PriorityQueue
 * */

public class FlightSolver {
    PriorityQueue<Flight> startPQ;
    Map<Flight, Integer> timeToPerson;  // 乘客到达时间map

    public FlightSolver(ArrayList<Flight> flights) {
        // TODO
        // 比较器比较对象
        //startPQ = new PriorityQueue<>((f1, f2) -> f1.getStartTime() - f2.getStartTime());
        startPQ = new PriorityQueue<>(Comparator.comparingInt(Flight::getStartTime));
        timeToPerson = new HashMap<>();

        for(Flight f : flights) {
            startPQ.add(f);
            timeToPerson.put(f, f.getPersonNum());
        }
    }

    public int solve() {
        // TODO
        int sum = 0;
        int i = 0;
        int max = 0;    // return
        int[] sums = new int[startPQ.size()];

        // 遍历pq中的每个项目
        while(startPQ.size() > 0) {
            // poll方法检索并移除队列的头
            Flight cur = startPQ.poll();
            sum = cur.getEndTime();
            for(Map.Entry<Flight, Integer> f : timeToPerson.entrySet()) {
                if(cur.getEndTime() > f.getKey().getStartTime() && f.getKey().startTime > cur.getStartTime()) {
                    sum += f.getValue();
                }
            }
            sums[i] = sum;
            i += 1;
        }
        for(int n : sums) {
            max = Math.max(max, n);
        }
        return max;
    }
}