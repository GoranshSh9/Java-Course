public class MinimumArr {
    public static void main(String[] args) {
        int[] arr = {18, 1, 4, -7, -25, 30};
        System.out.println(min(arr));
    }
    static int min(int[] arr){
        int ans = arr[0];
        for(int i = 1; i<arr.length; i++){
            if (arr[i]<ans) { //for finding maximum in arrays just change arr[i]<ans to arr[i]>ans
                ans = arr[i];
            }
        }
        return ans;
    }
}
