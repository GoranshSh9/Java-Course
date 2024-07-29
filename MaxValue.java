
public class MaxValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(max(arr)); //specify the index number here to find the max in range
    }
    static int max(int[] arr){ //for finding maximum value in range just add int start and int end here and run the for loop from i=start; i<=end
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}
