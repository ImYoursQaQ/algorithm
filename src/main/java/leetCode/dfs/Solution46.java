package leetCode.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution46 {

    /**
     * 求全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int length = nums.length;
        int[] used = new int[length];
        dfs(res,tmp,used,nums,0,length);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] used,int[] nums, int level,int length) {
        if (level == length){
            //这里做一次拷贝即可
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] != 1){
                tmp.add(nums[i]);
                used[i] = 1;
                dfs(res, tmp, used, nums, level +1,length);
                tmp.remove(tmp.size()-1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution46 solution46 = new Solution46();
        List<List<Integer>> permute = solution46.permute(nums);
        System.out.println(permute);
    }
}