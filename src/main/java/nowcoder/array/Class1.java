package nowcoder.array;

/**
 * @author hubo
 * @date 2020-06-10
 * @description:
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找数组中重复的数字
 *
 * 请找出数组中任意一个重复的数字
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */
public class Class1 {


    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,0,1,5};
        int duplicate = duplicate(a, a.length);
        System.out.println(duplicate);
    }


    /**
     * 请找出数组中任意一个重复的数字
     * @param numbers
     * @param length
     * @return
     */
    public  static int duplicate(int numbers[],int length) {

        Set set = new HashSet();
        for (int i = 0; i < length; i++) {
            set.add(numbers[i]);
            if (set.size() < i + 1){
                return numbers[i];
            }
        }
        return -1;
    }
}
