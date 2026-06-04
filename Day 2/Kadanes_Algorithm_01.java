

public class Kadanes_Algorithm_01 {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < nums.length; i++) {
            cs = cs + nums[i];

            ms = Math.max(cs, ms);

            if (cs < 0) {
                cs = 0;
            }
        }
        return ms;
    }
    public static void main(String[] args) {
        Kadanes_Algorithm_01 solution = new Kadanes_Algorithm_01();
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums1);
        System.out.println(result); 
    }
}
