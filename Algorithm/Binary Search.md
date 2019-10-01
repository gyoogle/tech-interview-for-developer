## 이분 탐색(Binary Search)

> 탐색 범위를 두 부분으로 분할하면서 찾는 방식

처음부터 끝까지 돌면서 탐색하는 것보다 훨~~~씬 빠른 장점을 지님

```
* 시간복잡도
전체 탐색 : O(N)
이분 탐색 : O(nlogn)
```

<br>

#### 진행 순서

- 우선 정렬을 해야 함
- left와 right로 mid 값 설정
- mid와 내가 구하고자 하는 값과 비교
- 구할 값이 mid보다 높으면 : left = mid+1
  구할 값이 mid보다 낮으면 : right = mid - 1
- left > right가 될 때까지 계속 반복하기

<br>

#### Code

```java
public static int solution(int[] arr, int M) { // arr 배열에서 M을 찾자
	
    Arrays.sort(arr); // 정렬
	
	int start = 0; // 시작
	int end = arr[arr.length-1]; // 끝
	
	while(start <= end) {
		
		int sum = 0;
		int mid = (start+end)/2; // 시작과 끝의 중간값
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > mid)
				sum+=mid;
			else
				sum+=arr[i];
		}
		
		if(sum > M)
			end = mid - 1;
		else
			start = mid + 1;
		
	}
    
	return end;
}
```

