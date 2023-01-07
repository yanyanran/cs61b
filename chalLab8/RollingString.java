import java.util.*;

/**
 * String类，允许用户在常数时间内在String中添加和删除字符，并具有常数时间散列函数。
 * 用于 Rabin-Karp 字符串匹配算法。
 */
class RollingString{
    /**
     * 一个角色可以接受的整数可能值的总数。
     * DO NOT CHANGE THIS.
     */
    static final int UNIQUECHARS = 128;

    /**
     * 我们用作模组空间的主要基地。恰好是61B。 :)
     * DO NOT CHANGE THIS.
     */
    static final int PRIMEBASE = 6113;

    public String s;
    public ArrayDeque<Character> chars = new ArrayDeque<>();
    int hs;
    int base = 1;
    /**
     * 使用当前值 String 初始化一个 RollingString。
     * s 必须与最大长度相同。
     */
    public RollingString(String s, int length) {
        assert(s.length() == length);
        this.s = s;
        for(int i = 0; i < length - 1; i++) {
            base = (base * UNIQUECHARS) % PRIMEBASE;
        }
        for(int i = 0; i < length; i ++) {
            chars.add(s.charAt(i));
        }
        for(char c : chars) {
            hs = (UNIQUECHARS * hs + c) % PRIMEBASE;
        }

    }

    /**
     * 在存储的“string”后面添加一个字符，去掉“string”的第一个字符。
     * 应该是一个恒定时间的操作。
     */
    public void addChar(char c) {
        hs = ((hs - (int) chars.removeFirst()* base % PRIMEBASE) * UNIQUECHARS + (int)c) % PRIMEBASE;
        hs = Math.floorMod(hs, PRIMEBASE);
        chars.add(c);
    }


    /**
     * 返回存储在此 RollingString 中的“字符串”，即具体化字符串。
     * 应该在字符串中的字符数上花费线性时间。
     */
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for(char c : chars) {
            strb.append(c);
        }
        return strb.toString();
    }

    /**
     * 返回存储的“字符串”的固定长度。
     * 应该是一个恒定时间的操作。
     */
    public int length() {
        return chars.size();
    }


    /**
     * 检查两个 RollingString 是否相等。
     * 如果两个 RollingString 具有相同顺序的相同字符，则它们是相等的，即它们的物化字符串相同。
     */
    @Override
    public boolean equals(Object o) {
        return toString().equals(o.toString());
    }

    /**
     * 返回存储的“字符串”的哈希码。
     * 应该花费固定的时间。
     */
    @Override
    public int hashCode() {
        return hs;
    }
}