public class RabinKarpAlgorithm {
    /**
     * 此算法返回匹配子字符串的起始索引。
     * 如果找不到匹配的子字符串，或者输入无效，则此方法将返回-1。
     * */
    // TODO
    public static int rabinKarp(String input, String pattern) {
        int p = hashPattern(pattern);
        int m = pattern.length();
        String sub = input.substring(0, m);
        RollingString rs = new RollingString(sub, m);
        for(int i = 0; i < input.length() - m + 1; i++) {
            if(rs.hashCode() == p) {
                if(rs.toString().equals(pattern)) {
                    return i;
                }
            } else {
                rs.addChar(input.charAt(m + i));
            }
        }
        return -1;
    }

    public static int hashPattern(String pattern) {
        int p = 0;
        for(int i = 0; i < pattern.length(); i ++) {
            p = (128 * p + (int)pattern.charAt(i)) % 6113;
        }
        return p;
    }
}