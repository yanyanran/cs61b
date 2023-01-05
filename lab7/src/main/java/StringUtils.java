import java.util.regex.Pattern;
import java.util.Random;

/** hw6 字符串的效用函数。
 *  @author Josh Hug
 */
public class StringUtils {
    /** o get the style checker to be quiet. */
    private static final int ALPHABET_SIZE = 26;

    /** 此类的随机数生成器。. */
    private static Random r = new Random();

    /** 将随机种子设置为 L，以便 randomString 的结果是可预测的.*/
    public static void setSeed(long l) {
        r = new Random(l);
    }

    /** 返回下一个长度为 LENGTH 的随机字符串。 */
    public static String randomString(int length) {
        char[] someChars = new char[length];
        for (int i = 0; i < length; i++) {
            someChars[i] = (char) (r.nextInt(ALPHABET_SIZE) + 'a');
        }
        return new String(someChars);
    }

    /** 如果字符串 S 仅由 'a' 和 'z' 之间的字符组成，则返回 true。不允许使用空格、数字、大写或任何其他字符。
     */
    public static boolean isLowerCase(String s) {
        return Pattern.matches("[a-z]*", s);
    }

    /** 返回按字母顺序紧跟在 S 之后的字符串。
     * 例如，如果 s 是 'potato'，此方法将返回 'potatp'。如果最后一个字符是 z，那么我们添加到下一个位置，依此类推
     */
    public static String nextString(String s) {
        /* Handle all zs as a special case to keep helper method simple. */
        if (isAllzs(s)) {
            return allAs(s.length() + 1);
        }
        char[] charVersion = s.toCharArray();
        incrementCharArray(charVersion, charVersion.length - 1);
        return new String(charVersion);
    }

    /** nextString 的辅助函数。
     * 将 X 的第 Pth 位置递增 1，如果 p == 'z' 则环绕到 'a'。
     * 如果发生回绕，那么我们需要携带一个，并且我们增加位置 P - 1。
     * 对于仅包含 zs 的字符数组将失败。
     */
    private static void incrementCharArray(char [] x, int p) {
        if (x[p] != 'z') {
            x[p] += 1;
        } else {
            x[p] = 'a';
            incrementCharArray(x, p - 1);
        }
    }

    /** 返回长度为 LEN 的所有 'a' 的字符串。 */
    private static String allAs(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    /** 如果 S 全部为 'z'，则返回 true。空字符串为假 */
    public static boolean isAllzs(String s) {
        return Pattern.matches("[z]+", s);
    }

}