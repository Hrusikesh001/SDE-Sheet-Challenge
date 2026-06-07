// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100

// Example 3:
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25


public class Pow_x_and_n_02 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Pow_x_and_n_02 solution = new Pow_x_and_n_02();
        double x1 = 2.00000;
        int n1 = 10;
        double x2 = 2.10000;
        int n2 = 3;
        double x3 = 2.00000;
        int n3 = -2;

        System.out.println("myPow(" + x1 + ", " + n1 + ") = " + solution.myPow(x1, n1));
        System.out.println("myPow(" + x2 + ", " + n2 + ") = " + solution.myPow(x2, n2));
        System.out.println("myPow(" + x3 + ", " + n3 + ") = " + solution.myPow(x3, n3));
    }
}