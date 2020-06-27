package others.algorithm_topics.sort;

public class merge_sort {
    private static void mergeSort(int[] arr){
        __mergeSort(arr, 0, arr.length - 1);
    }

    private static void __mergeSort(int[] arr, int from, int to){
        if(from < to){
            int mid = (from + to) / 2;
            __mergeSort(arr, from, mid);
            __mergeSort(arr, mid + 1, to);
            __merge(arr, from, mid, mid + 1, to);
        }
    }

    private static void __merge(int[] arr, int from_1, int to_1, int from_2, int to_2){
        int[] tmp_arr = new int[to_2 - from_1 + 1];
        int i = from_1;
        int j = from_2;
        int pos = 0;
        while(i <= to_1 + 1 || j <= to_2 + 1){
            if (i == to_1 + 1){
                while(j != to_2 + 1){
                    tmp_arr[pos] = arr[j];
                    pos += 1;
                    j += 1;
                }
                break;
            }else if(j == to_2 + 1){
                while(i != to_1 + 1){
                    tmp_arr[pos] = arr[i];
                    pos += 1;
                    i += 1;
                }
                break;
            }else{
                if(arr[i] < arr[j]){
                    tmp_arr[pos] = arr[i];
                    pos += 1;
                    i += 1;
                }else{
                    tmp_arr[pos] = arr[j];
                    pos += 1;
                    j += 1;
                }
            }
        }
        for (int k = 0; k < tmp_arr.length; ++k){
            arr[from_1 + k] = tmp_arr[k];
        }
    }



    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 7, 2 , 8, 6, 4, 1, 9, 0};
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        mergeSort(arr);

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}