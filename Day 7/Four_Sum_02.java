// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

 

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

import java.util.*;

public class Four_Sum_02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i =0; i<n;i++){
            for(int j = i+1;j<n; j++){
                long target2=(long)target-(long)nums[i]-nums[j];
                int left=j+1;
                int right=n-1;
                while(left<right){
                    int s =nums[left]+nums[right];
                    if(s<target2){
                        left++;
                    }else if(s>target2){
                        right--;
                    }else{
                        List<Integer> list=Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        ans.add(list);
                        while(left<right && nums[left]==list.get(2)){
                            left++;
                        }
                        while(left<right && nums[right]==list.get(3)){
                            right--;
                        }
                    }
                }
                while(j+1<n && nums[j]==nums[j+1]){
                    j++;
                }
            }
            while(i+1<n && nums[i]==nums[i+1]){
                i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Four_Sum_02 obj = new Four_Sum_02();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ans = obj.fourSum(nums, target);
        System.out.println(ans);
    }
}
