package others.algorithm_topics.sort;

public class quick_sort_1 {

    private static void __quickSort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }

        int p = __partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);

        
    }

    private static int __partition(int[] arr, int l, int r){
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; ++i){
            if (arr[i] > v){
                continue;
            }else if(arr[i] < v){
                int t = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = t;
                ++j;
            }
        }
        int t = arr[l];
        arr[l] = arr[j];
        arr[j] = t;

        return j;
    }

    public static void quickSort(int[] arr){
        __quickSort(arr, 0, arr.length - 1);
    }
    

    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 7, 2 , 8, 6, 4, 1, 9, 0};
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        quickSort(arr);

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}