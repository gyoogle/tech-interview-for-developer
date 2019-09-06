public class InsertionSort {
    
    static int[] arr = {10, 2, 6, 4, 3, 7, 5};
    
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i]; // 기준
            int aux = i - 1; // 비교대상
            
            while(aux >= 0 && num < arr[aux]) {
                arr[aux+1] = arr[aux];
                aux--;
            }
            arr[aux+1] = num;
        }
    }
    
    public static void main(String[] args) {
        
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
