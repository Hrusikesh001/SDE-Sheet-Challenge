import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_02 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    row.add(1);
                } else {
                    int val = 
                    result.get(i-1).get(j-1) 
                    + result.get(i-1).get(j);

                    row.add(val);
                }
            }
            result.add(row);
        }
        return result;
    }
    public static void main(String[] args) {
        Pascals_Triangle_02 solution = new Pascals_Triangle_02();
        int numRows = 5;
        List<List<Integer>> triangle = solution.generate(numRows);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
