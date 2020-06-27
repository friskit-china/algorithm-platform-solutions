package others.algorithm_topics.sort;

public class quick_sort_3 {
    static void quickSort(int[] arr){
        __quickSort(arr, 0, arr.length - 1);
    }

    static void __quickSort(int[] arr, int from, int to){
        if (to <= from){
            return;
        }
        
        int v = arr[from];
        int i = from;
        int j = to;
        int e = from + 1;
        while (e <= j){
            if(arr[e] < v){
                int t = arr[i + 1];
                arr[i + 1] = arr[e];
                arr[e] = t;

                e += 1;
                i += 1;
            }else if (arr[e] == v){
                e += 1;
            }else{
                int t = arr[j];
                arr[j] = arr[e];
                arr[e] = t;
                j -= 1;
            }
        }
        int t = arr[from];
        arr[from] = arr[i];
        arr[i] = t;
        __quickSort(arr, from, i - 1);
        __quickSort(arr, j + 1, to);
    }

    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 2, 3, 5, 7, 2, 8, 6, 4, 1, 9, 0};
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