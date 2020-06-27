package others.algorithm_topics.sort;

public class heap {
    public static class MaxHeap{
        private int[] data;
        private int capacity;
        private int count = 0;
        public MaxHeap(int capacity){
            this.capacity = capacity;
            this.data = new int[capacity + 1];
        }

        public MaxHeap(int[] arr){
            this.capacity = arr.length;
            this.count = arr.length;
            this.data = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; ++i){
                this.data[i] = arr[i - 1];
            }

            for (int i = count / 2; i >= 1; --i){
                shiftDown(i);
            }
        }

        public int size(){
            return count;
        }

        public boolean is_empty(){
            return count == 0;
        }

        public void insert(int val){
            this.data[count + 1] = val;
            count += 1;
            shiftUp(count);
        }

        private void shiftUp(int position){
            if (position == 1){
                return;
            }
            assert(count + 1 <= this.capacity);
            while(position > 1 && data[position / 2] < data[position]){
                int t = data[position / 2];
                data[position / 2] = data[position];
                data[position] = t;
                position /= 2;
            }
        }

        public int pop(){
            assert (count >= 1);

            int val = this.data[1];
            this.data[1] = this.data[count];
            count -= 1;
            shiftDown(1);
            return val;
        }

        private void shiftDown(int position){
            while(position * 2 <= count){
                int j = 2 * position;
                if (j + 1 <= count && data[j + 1] > data[j]){
                    j += 1;
                }
                if (data[position] >= data[j]){
                    break;
                }
                
                int t = data[j];
                data[j] = data[position];
                data[position] = t;
                position = j;
            }
        }
    }
    private static void heapSort(int[] arr){
        // MaxHeap heap = new MaxHeap(arr.length);
        // for (int i = 0; i < arr.length; ++i){
        //     heap.insert(arr[i]);
        // }
        // int i = 0;
        // while(heap.is_empty() == false){
        //     arr[i++] = heap.pop();
        // }

        MaxHeap heap = new MaxHeap(arr);
        int i = 0;
        while(heap.is_empty() == false){
            arr[i++] = heap.pop();
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