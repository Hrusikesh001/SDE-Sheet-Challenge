// Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.

// Example 1
// Input : nums = [4, 2, 2, 6, 4], k = 6
// Output : 4
// Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

// Example 2
// Input :nums = [5, 6, 7, 8, 9], k = 5
// Output : 2
// Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

import java.util.HashMap;

public class Count_subarrays_with_given_xor_K_02 {
    public int subarraysWithXorK(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        int count = 0;
        map.put(0, 1);
        for(int num : nums) {
            xr ^= num;
            int x = xr ^ k;
            if(map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Count_subarrays_with_given_xor_K_02 obj = new Count_subarrays_with_given_xor_K_02();
        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = obj.subarraysWithXorK(nums, k);
        System.out.println(ans);
    }
}
