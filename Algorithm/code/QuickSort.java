import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {
	
	static int[] input;
	static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, N-1);
		
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int a, int b) { 
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	
	public static void quickSort(int first, int last) {
		
		if(first < last) {
			
			int pivot = (first+last)/2;
			int i = first;
			int j = last;
			
			while( i < j ) {
				while (input[i] <= input[pivot] && i < last) {
					i++;
				}
				
				while (input[j] > input[pivot]) {
					j--;
				}
				
				if (i < j) {
					swap(i, j);
				}
			}
			
			swap(pivot, j);
			
			quickSort(first, j - 1);
			quickSort(j+1, last);
		}
		
	}

}
