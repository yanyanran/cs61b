/**
 * 一个用于 off-by-1 比较器的类
 * */
public class OffByOne implements CharacterComparator {

    // 相差一个字符 --> TRUE
    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x-y) == 1)
            return true;
        return false;
    }
}
