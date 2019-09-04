#### Comparison Sort

------

> N개 원소의 배열이 있을 때, 이를 모두 정렬하는 가짓수는 N!임
>
> 따라서, Comparison Sort를 통해 생기는 <u>트리의 말단 노드</u>가 N! 이상의 노드 갯수를 갖기 위해서는, 2^h >= N! 를 만족하는 h를 가져야 하고, 이 식을 h > O(nlgn)을 가져야 한다. (h는 트리의 높이,,, 즉 Comparison sort의 시간 복잡도임)

이런 O(nlgn)을 줄일 수 있는 방법은 Comparison을 하지 않는 것



#### Counting Sort 과정

----

시간 복잡도 : O(n + k) -> k는 배열에서 등장하는 최대값

공간 복잡도 : O(k) -> k만큼의 배열을 만들어야 함.

Counting이 필요 : 각 숫자가 몇 번 등장했는지 센다.

```c
int arr[5]; 		// [5, 4, 3, 2, 1]
int sorted_arr[5];
// 과정 1 - counting 배열의 사이즈를 최대값 5가 담기도록 크게 잡기
int counting[6];	// 단점 : counting 배열의 사이즈의 범위를 가능한 값의 범위만큼 크게 잡아야 하므로, 비효율적이 됨.

// 과정 2 - counting 배열의 값을 증가해주기.
for (int i = 0; i < arr.length; i++) {
    counting[arr[i]]++;
}
// 과정 3 - counting 배열을 누적합으로 만들어주기.
for (int i = 1; i < arr.length; i++) {
    counting[i] += counting[i - 1];
}
// 과정 4 - 뒤에서부터 배열을 돌면서, 해당하는 값의 인덱스에 값을 넣어주기.
for (int i = arr.length - 1; i >= 0; i--) {
    sorted_arr[counting[arr[i]]] = arr[i];
    counting[arr[i]]--;
}
```

* 사용 : 정렬하는 숫자가 특정한 범위 내에 있을 때 사용

  (Suffix Array 를 얻을 때, 시간복잡도 O(nlgn)으로 얻을 수 있음.)

* 장점 : O(n) 의 시간복잡도

* 단점 : 배열 사이즈 N 만큼 돌 때, 증가시켜주는 Counting 배열의 크기가 큼.

  (메모리 낭비가 심함)