// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.


// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]


import java.util.*;
public class Majority_Element_II_01 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : map.keySet()) {
            if (map.get(x) > (nums.length / 3)) {
                list.add(x);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Majority_Element_II_01 solution = new Majority_Element_II_01();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};

        System.out.println("Majority elements in nums1: " + solution.majorityElement(nums1));
        System.out.println("Majority elements in nums2: " + solution.majorityElement(nums2));
        System.out.println("Majority elements in nums3: " + solution.majorityElement(nums3));
    }
}
