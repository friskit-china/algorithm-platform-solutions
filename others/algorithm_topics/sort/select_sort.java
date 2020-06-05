package others.algorithm_topics.sort;

public class select_sort {
    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; ++i){
            int max_pos = i;
            for (int j = i + 1; j < arr.length; ++j){
                if (arr[j] < arr[max_pos]){
                    max_pos = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[max_pos];
            arr[max_pos] = t;
        }
    }


    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 7, 2 , 8, 6, 4, 1, 9, 0};
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        selectionSort(arr);

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}