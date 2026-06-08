// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 

// Example 1:
// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

// Example 2:
// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1


public class Reverse_Pairs_03 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int count = 0;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    private int countPairs(int[] arr,
            int low,
            int mid,
            int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high &&
                    (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    private void merge(int[] arr,
            int low,
            int mid,
            int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
    public static void main(String[] args) {
        Reverse_Pairs_03 solution = new Reverse_Pairs_03();
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};

        System.out.println("Number of reverse pairs in nums1: " + solution.reversePairs(nums1));
        System.out.println("Number of reverse pairs in nums2: " + solution.reversePairs(nums2));
    }
}
