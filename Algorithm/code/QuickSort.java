import java.util.Arrays;

public class QuickSort {
	
	static int[] arr = {5, 1, 1, 2, 1, 4, 4, 4, 5, 5};
	
	public static void main(String[] args) throws Exception {
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		
		if(start >= end) return;
		
		if(start < end) {
			
			int i = start-1;
			int j = end+1;
			int pivot = arr[(start+end)/2];
			
			while(i < j) {
				
				while(arr[++i] < pivot) {}
				while(arr[--j] > pivot) {}
				
				if (i >= j) break;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			quickSort(arr, start, i-1);
			quickSort(arr, j+1, end);
		}
		
	}
}
