package others.algorithm_topics.sort;

public class insert_sort {
    private static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; ++i){
            for (int j = i; j > 0; --j){
                if (arr[j] < arr[j - 1]){
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }


    public static void main(String[] argv){
        int[] arr = new int[]{3, 5, 7, 2 , 8, 6, 4, 1, 9, 0};
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        insertSort(arr);

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}