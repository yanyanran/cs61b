/**
 * 一个用于 off-by-1 比较器的类
 * */
public class OffByOne implements CharacterComparator {

    // 相差一个字符 --> TRUE
    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x-y)==1)
            return true;
        return false;
    }

/*    public static void main(String[] args) {
        OffByOne a = new OffByOne();
        System.out.println(a.equalChars('a', 'b'));
        System.out.println(a.equalChars('r', 'q'));
        System.out.println(a.equalChars('a', 'e'));
        System.out.println(a.equalChars('z', 'a'));
        System.out.println(a.equalChars('a', 'a'));
        System.out.println(a.equalChars('&', '%'));
        *//*
        * true
        * true
        * false
        * false
        * false
        * true
        * *//*
    }*/
}