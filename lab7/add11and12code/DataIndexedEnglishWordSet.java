package add11and12code;

public class DataIndexedEnglishWordSet {
    private boolean[] present;
    private String s;

    public DataIndexedEnglishWordSet() {
        present = new boolean[2000000000];
    }

    public void add(String s) {
        present[englishToInt(s)] = true;
        this.s = s;
    }

    public boolean contains(int i) {
        return present[englishToInt(s)];
    }

    /** 将字符串的第i个字符转换为字母数字
     * e.g. 'a' -> 1, 'b' -> 2, 'z' -> 26
     * */
    public static int letterNum(String s, int i) {
        int ithChar = s.charAt(i);
        if ((ithChar < 'a') || (ithChar > 'z')) {
            throw new IllegalArgumentException();
        }
        return ithChar - 'a' + 1;
    }

    public static int englishToInt(String s) {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1) {
            intRep = intRep * 26;
            intRep += letterNum(s, i);
        }
        return intRep;
    }

    /**
     * 在单个英语单词之外插入字符串
     * */
    public static int asciiToInt(String s) {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1) {
            intRep = intRep * 126;
            intRep = intRep + s.charAt(i);
        }
        return intRep;
    }
}