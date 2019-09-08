import java.util.Arrays;
import java.util.Random;

public class mergeSort {
	// SIZE 십 만
	static int MAX_LEN = 100_000;

	public static void main(String[] args) {

		Random r = new Random(100);
		int merge_idx, collections_idx;
		int arr_merge[], arr_collections[];

		merge_idx = 0;
		collections_idx = 0;
		arr_merge = new int[MAX_LEN];
		arr_collections = new int[MAX_LEN];

		// 랜덤으로 배열을 생성하는 부분
		for (int i = 0; i < MAX_LEN; i++) {
			int temp = (r.nextInt() % 10000);
			arr_merge[merge_idx++] = temp;
			arr_collections[collections_idx++] = temp;
		}

		Arrays.sort(arr_collections);
		mergeSort(arr_merge, 0, MAX_LEN - 1);

		// 정렬이 제대로 되었는지 확인하는 부분.
		for (int i = 0; i < MAX_LEN; i++) {
			if (arr_collections[i] != arr_merge[i]) {
				System.out.println("MergeSort 실패!");
				return;
			}
		}
		System.out.println("MergeSort 성공");
		return;
	}

	private static void mergeSort(int[] arr, int left, int right) {

		// (1) 재귀 호출을 통해 더이상 쪼개지지 않을 때까지 쪼개야 된다.
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		int i = left;
		int j = mid+1;

		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);

		// (2) 배열을 인덱스를 통해서 절반으로 쪼개고, 한쪽이 다 쓸 때까지 반복문을 돌린다.
		int[] buffer = new int[right - left + 1];
		int bidx = 0;
		
		// 왼쪽이랑 오른쪽 각각 비교
		while (true) {
			if(arr[i] <= arr[j]) { // stable
				buffer[bidx++] = arr[i];
				i++;
			} else {
				buffer[bidx++] = arr[j];
				j++;
			}
			
			if(i > mid || j > right) 
				break;
		}

		// (3) 남은 것(오른쪽 or 왼쪽)을 전부 buffer에 넣어야 한다.
		// 왼쪽 전부 써버리기
		while(i <= mid) {
			buffer[bidx++] = arr[i++];
		}
		//오른쪽 전부 써버리기
		while(j <= right) {
			buffer[bidx++] = arr[j++];
		}

		// (4) buffer에 있는 것을 기존 배열의 인덱스 위에 덮어준다.
		for (int k = 0; k < bidx; k++) {
			arr[left+k] = buffer[k];
		}
	}
}
