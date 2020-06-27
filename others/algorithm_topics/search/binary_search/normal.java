package others.algorithm_topics.search.binary_search;

public class normal {
    public static int binary_search(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (arr[mid] == target){
                return mid;
            }

            if (target < arr[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] argv){
        int[] arr = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println(binary_search(arr, 8));
        System.out.println(binary_search(arr, 9));
    }
}