public class SearchinRange {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 5, 60};
        int target = 30;
        System.out.println(linearSearch(arr, target, 1, 3));
    }
    static int linearSearch(int[] arr, int target, int start, int end){
        if (arr.length == 0) {
            return -1;
        }
        for(int index = start; index <= end; index++){
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;
    }
}