/* 气泡是否掉落可以通俗为“是否两两粘在一起”
   第一行的泡泡不会掉落，因为粘在天花板上
*/
public class BubbleGrid extends UnionFind{
    private int[][] grid;

    // 构造函数初始化网格（1为泡泡、0为空地）
    public BubbleGrid(int[][] grid) {
        super(grid[0].length * grid.length);
        this.grid = grid;
        int row = grid.length; // 行
        int column = grid[0].length; // 列
        int num = 0;

        /* 初始化parent数组 */
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == 1) {
                    p[num] = -1;
                } else {
                    p[num] = -2;
                }
                num += 1;
            }
        }
        /* 垂直联合气泡 */
        for (int i = 1; i < row; i++) {
            for(int j = i * column; j < (i + 1) * column; j++) {
                if(p[j] == -2) { // 0跳过
                    continue;
                }
                if(p[j] == -1 && p[j - column] == -1) { // 上下联合
                    connect(j - column, j);
                }
            }
        }
        /* 水平联合气泡 */
        for (int i = 1; i < row; i++) {
            for(int j = i * column + 1; j < (i + 1) * column; j++) {
                if(p[j] == -1 && p[j - 1] != -2) {  // 不能j+1 会越界
                    connect(j - 1, j);
                    size[j - 1] += 1;
                }
            }
        }
    }

    // 传参传投飞镖的网格位置
    // 返回一个数组，其中第i个元素是第i个飞镖投掷后掉落的气泡数（pop出的气泡不会掉落
    /*
    * 例子:鉴于grid
    [[1, 1, 0],
     [1, 0, 0],
     [1, 1, 0],
     [1, 1, 1]]
    和darts
    [[2, 2], [2, 0]]
    popBubbles()应返回[0, 4]
    * */
    public int[] popBubbles(int[][] darts) {
        int[] result = new int[darts.length];
        int col = grid[0].length;

        for(int i = 0; i < darts.length; i++) {
            if(p[darts[i][0] * col + darts[i][1]] != -2) {
                result[i] = size[darts[i][0] * col + darts[i][1]] - 1;  // pop出的气泡不会掉落
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}