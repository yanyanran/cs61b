/**
 * 一个用于 off-by-N 比较器的类
 * */
public class OffByN implements CharacterComparator {
    private int N;

    // 构造函数
    public OffByN(int n){
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == N) {
            return true;
        }
        return false;
    }
}