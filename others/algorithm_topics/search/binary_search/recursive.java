package others.algorithm_topics.search.binary_search;

public class recursive {
    public static int binary_search(int[] arr, int l, int r, int target){
        if (l > r){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target){
            return mid;
        }

        if (target < arr[mid]){
            return binary_search(arr, l, mid - 1, target);
        }else{
            return binary_search(arr, mid + 1, r, target);
        }
    }
    public static void main(String[] argv){
        int[] arr = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println(binary_search(arr, 0, arr.length - 1, 8));
        System.out.println(binary_search(arr, 0, arr.length - 1, 9));
    }
}