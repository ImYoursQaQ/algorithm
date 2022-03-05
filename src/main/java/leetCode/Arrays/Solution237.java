package leetCode.Arrays;



import java.util.*;

/**
 * 237.删除链表中的节点
 * 删除指定节点，这里修改当前节点的值，然后在修改指针即可
 */
class Solution237 {

    public static void main(String[] args) {
        String str = "ab_a";
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome);
    }

    public void deleteNode(ListNode head,ListNode node) {
        //将后面的节点的值赋予当前节点
        node.val = node.next.val;
        //修改节点的指针使之跳过next节点
        node.next = node.next.next;
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        int low = 0,high = s.length-1;
        while (low < high){
            char tar = s[low];
            s[low] = s[high];
            s[high] = tar;
            low++;
            high--;
        }
        System.out.println(s);
    }

    public static int titleToNumber(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int res = 0,j = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i]-64) * Math.pow(26,j);
            j++;
        }
        return res;
    }

    public static List<String> fizzBuzz(int n) {
        if (n<1) return Collections.EMPTY_LIST;
        List<String> res  = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0){
                if (i % 5 == 0){
                    res.add("FizzBuzz");
                    continue;
                }
                else {
                    res.add("Fizz");
                    continue;
                }
            }

            if (i % 5 == 0){
                if (i % 3 == 0){
                    res.add("FizzBuzz");
                    continue;
                }
                else {
                    res.add("Buzz");
                    continue;
                }
            }
            res.add(String.valueOf(i));

        }
        return res;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (l1 !=null || l2 !=null){
            if (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
                continue;
            }
            if (l1 == null){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if (l2 == null){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
                continue;
            }


        }
        return pre.next;
    }

    /**
     * 移动0
     * 类冒泡排序
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int length = nums.length;
        for (int i = 0; i < length - 1;i++ ) {
            while (nums[i] == 0){
                for (int j = i; j < length - 2; j++) {
                    if (nums[j+1] == 0){
                        continue;
                    }
                    nums[j] = nums[j+1];
                }
                nums[length-1] = 0;
            }
        }

    }

    /**
     * 118。杨辉三角
     * @param numRows
     * @return
     */
    public  static List<List<Integer>> generate(int numRows) {
        if (numRows < 1){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list.add(j,1);
                }else {
                    list.add(j,res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 202. 快乐数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        if (n == 1)return Boolean.TRUE;
        Set set = new HashSet();
        while (n != 1){
            if (set.contains(n)){
                return false;
            }else {
                set.add(n);
            }
            n = changeN(n);
        }
        return true;
    }

    private static int changeN(int n) {
        int res = 0;
       while (n != 0){
           int yu = n % 10;
           res += yu * yu;
           n = n / 10;
       }
        return res;
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length){
                return i;
            }
            if (nums[i] != i){
                return i;
            }
        }
        return -1;
    }

    /**
     * 125 验证回文串
     * @param s
     * @return
     */
    public  static boolean isPalindrome(String s) {
        String regEx = "[^0-9a-zA-Z]";
        String s1 = s.replaceAll(regEx, "").trim().toUpperCase();
        int low = 0,high = s1.length()-1;
        char[] chars = s1.toCharArray();
        while (low < high){
            if (chars[low] != chars[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    /**
     * 371. 两整数之和
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return a + b;
    }

    /**
     * 198. 打家劫舍
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0)return 0;
        if (nums.length == 1) return nums[0];
        int tmp1 = 0,tmp2 = 0;
        for (int i = 0; i < nums.length; i = i+2) {
            tmp1 += nums[i];
        }
        for (int i = 0; i < nums.length; i = i+2) {
            tmp2 += nums[i];
        }
        return Math.max(tmp1,tmp2);
    }

    private void swap(int num, int num1) {
        int tmp = num;
        num = num1;
        num1 = tmp;
    }
}

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }