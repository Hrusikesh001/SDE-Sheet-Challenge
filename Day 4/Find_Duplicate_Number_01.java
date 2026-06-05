// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.

 

// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

// Example 3:
// Input: nums = [3,3,3,3,3]
// Output: 3

public class Find_Duplicate_Number_01 {
    public int findDuplicate(int[] nums) {
        int s = 0, f = 0;
        while (true) {
            int val = nums[f];
            f = nums[val];
            s = nums[s];
            if (f == s)
                break;
        }
        s = 0;
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
    public static void main(String[] args) {
        Find_Duplicate_Number_01 solution = new Find_Duplicate_Number_01();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}
