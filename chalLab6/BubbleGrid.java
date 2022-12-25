/* 气泡是否掉落可以通俗为“是否两两粘在一起”
   第一行的泡泡不会掉落，因为粘在天花板上
*/
public class BubbleGrid extends UnionFind{
    // 构造函数初始化网格（1为泡泡、0为空地）
    public BubbleGrid(int[][] grid) {
        super();

    }

    // 传参传投飞镖的网格位置
    // 返回一个数组，其中第i个元素是第i个飞镖投掷后掉落的气泡数（pop出的气泡不会掉落
    public int[] popBubbles(int[][] darts) {

    }
}