public class Sort {
     /** Sorts strings destructively. */
     public static void sort(String[] s) {
          // find the smallest item
          // move it to the front
          // selection sort the rest (using recursion?)

/*          int smallest = findSmallest(s);
          swap(s, 0, smallest);  // need index
*/
          sort(s, 0);
     }

     /** Sorts strings destructively starting from item start. */
     // 辅助方法
     private static void sort(String[] x, int start) {
          // TODO
          if (start == x.length) {
               return;
          }
          int smallestIndex = findSmallest(x, start);
          swap(x, start, smallestIndex);
          sort(x, start + 1);
     }

     /** Returns the smallest string in s. */
     public static int findSmallest(String[] s, int start) {
          int smallestIndex = start;
          for (int i = start; i < s.length; i++) {
               // str1 < str2
               // str1.compareTo(str2)返回一个负数
               int cmp = s[i].compareTo(s[smallestIndex]);
               if(cmp < 0) {
                    smallestIndex = i;
               }
          }
          return smallestIndex;
     }

     public static void swap(String[] s, int a, int b) {
          String temp = s[a];
          s[a] = s[b];
          s[b] = temp;
     }
}