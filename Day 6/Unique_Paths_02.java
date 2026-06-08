// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down


import java.util.*;
public class Unique_Paths_02 {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1);

        long ans = 1;

        for(int i = 1; i <= r; i++) {
            ans = ans * (N - r + i) / i;
        }

        return (int)ans;
    }
    public static void main(String[] args) {
        Unique_Paths_02 solution = new Unique_Paths_02();
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;

        System.out.println("Unique paths from top-left to bottom-right in a " + m1 + "x" + n1 + " grid: " + solution.uniquePaths(m1, n1));
        System.out.println("Unique paths from top-left to bottom-right in a " + m2 + "x" + n2 + " grid: " + solution.uniquePaths(m2, n2));
    }
}
