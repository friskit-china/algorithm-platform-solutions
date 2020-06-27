package others.algorithm_topics.sort;

public class heap_sort {
    private static void shiftDown(int[] arr, int length, int position){
        while (2 * position + 1 < length){
            int j = 2 * position + 1;
            if (j + 1 < length && arr[j + 1] > arr[j]){
                j = j + 1;
            }

            if (arr[position] >= arr[j]){
                break;
            }

            int t = arr[position];
            arr[position] = arr[j];
            arr[j] = t;
            position = j;
        }
    }
    public static void heapSort(int[] arr){
        for (int i = (arr.length - 1) / 2; i >= 0; --i){
            shiftDown(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; --i){
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            shiftDown(arr, i, 0);
        }
    }
    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 7, 2 , 8, 6, 4, 1, 9, 0};
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        heapSort(arr);

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}