import java.util.HashSet;

public class Find_the_repeating_and_missing_number_02 {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                ans[0] = nums[i];
            }
            set.add(nums[i]);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Find_the_repeating_and_missing_number_02 solution = new Find_the_repeating_and_missing_number_02();
        int[] nums = {3, 1, 2, 5, 3};
        int[] result = solution.findMissingRepeatingNumbers(nums);
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
        
    }
}
