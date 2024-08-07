import java.util.Arrays;

public class Search2DArrays {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {12, 23, 34, 45},
            {56, 67, 78},
            {22, 33}
        };
        int target = 67;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] search(int[][] arr, int target){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col<arr[row].length; col++){
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
//qweertyuiopasdfghjkl