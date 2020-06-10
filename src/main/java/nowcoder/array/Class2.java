package nowcoder.array;

/**
 * @author hubo
 * @date 2020-06-10
 * @description:
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 二维数组中的查找
 * 条件：有序
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Class2 {

    public static void main(String[] args) {

        int[][] a = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target = 8;
        boolean b = Find2(target, a);
        System.out.println(b);
    }

    public static boolean Find(int target, int[][] array) {


        Set mySet = new HashSet();
        for (int[] is : array) {
            for (int i : is) {
                // System.out.print(i + ",");
                mySet.add(i);
            }
        }
        boolean add = mySet.add(target);
        return !add;
    }

    public static boolean Find2(int target, int[][] array) {
        for (int[] a : array) {
            for (int i = a.length - 1; i > -1; i--) {
                if (target == a[i]) {
                    return true;
                }
                if (target > a[i]) {
                    break;
                }
                if (target < a[i]) {
                    continue;
                }
            }
        }
        return false;
    }
}
