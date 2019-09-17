import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 롤러코스터 {
	
	static final int k = 1000000007;

	static class Rail {
		int a;
		int b;

		Rail(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static int N;
	static Rail[] rails;

	public static void quickSort(Rail[] arr, int start, int end) {

		if (start >= end)
			return;

		if (start < end) {

			int i = start - 1;
			int j = end + 1;
			Rail pivot = arr[(start + end) / 2];

			while (true) {

				while (
						((double)(arr[++i].a-1)/(double)arr[i].b > (double)(pivot.a-1)/(double)pivot.b) 
					  ) {
				}
				while (
						((double)(arr[--j].a-1)/(double)arr[j].b < (double)(pivot.a-1)/(double)pivot.b) 
					  ) {
				}

				if (i >= j)
					break;

				Rail temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

			quickSort(arr, start, i - 1);
			quickSort(arr, j + 1, end);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testcase; t++) {

			N = Integer.parseInt(br.readLine());
			rails = new Rail[N];
			long result = 0;
			long v = 1;

			for (int i = 0; i < N; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				rails[i] = new Rail(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			quickSort(rails, 0, N-1);
			
			for (int i = 0; i < rails.length; i++) {
				int a = rails[i].a;
				int b = rails[i].b;
				
				result = ((v*a)%k+b)%k;
				v = result;
			}

			System.out.println("#" + t + " " + result);
		}

	}

}
