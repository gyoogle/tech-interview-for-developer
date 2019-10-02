public class Heap {
	
	static int N, heapSize;
	static int[] arr;
	
	static void init(int n) {
		N = n;
		arr = new int[N+1];
		heapSize = 0;
	}
	
	static void add(int n) {
		arr[++heapSize] = n;
		
		for (int i = heapSize; i > 1; i/=2) {
			if(arr[i] < arr[i/2]) {
				swap(i/2, i);
			}
			else break;
		}
	}
	static int remove(int[] arr) {
		if(heapSize == 0) return 0;
		
		int rm = arr[1];
		arr[1] = arr[heapSize];
		arr[heapSize--] = 0;
		
		for (int i = 1; i*2 <= heapSize;) {
			
			if(i*2+1 <= heapSize) {
			
				if(arr[i] < arr[i*2] && arr[i] < arr[i*2+1]) break;
				
				else if(arr[i*2] < arr[i*2+1]) {
					swap(i, i*2);
					i = i*2;
				}
				else {
					swap(i, i*2+1);
					i = i*2+1;
				}
			}
			else {
				if(arr[i] > arr[i*2]) {
					swap(i, i*2);
					i = i*2;
				}
				else
					break;
			}
		}
		
		return rm;
	}
	
	static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
