#### Comparison Sort

---

> N개 원소의 배열이 있을 때, 이를 모두 정렬하는 가짓수는 N!임
>
> 따라서, Comparison Sort를 통해 생기는 <u>트리의 말단 노드</u>가 N! 이상의 노드 갯수를 갖기 위해서는, 2^h >= N! 를 만족하는 h를 가져야 하고, 이 식을 h > O(nlgn)을 가져야 한다. (h는 트리의 높이,,, 즉 Comparison sort의 시간 복잡도임)

이런 O(nlgn)을 줄일 수 있는 방법은 Comparison을 하지 않는 것



#### Radix sort

----

데이터를 구성하는 기본 요소 (Radix) 를 이용하여 정렬을 진행하는 방식

> 입력 데이터의 최대값에 따라서 Counting Sort의 비효율성을 개선하기 위해서, Radix Sort를 사용할 수 있음.
>
> 자릿수의 값 별로 (예) 둘째 자리, 첫째 자리) 정렬을 하므로, 나올 수 있는 값의 최대 사이즈는 9임 (범위 : 0 ~ 9)

* 시간 복잡도 : O(d * (n + b))  

  -> d는 정렬할 숫자의 자릿수, b는 10 (k와 같으나 10으로 고정되어 있다.)

  ( Counting Sort의 경우 : O(n + k) 로 배열의 최댓값 k에 영향을 받음 )

* 장점 : 문자열, 정수 정렬 가능

* 단점 : 자릿수가 없는 것은 정렬할 수 없음. (부동 소숫점)

  중간 결과를 저장할 bucket 공간이 필요함.

#### 소스 코드

```c
void countSort(int arr[], int n, int exp) {
	int buffer[n];
    int i, count[10] = {0};
    
    // exp의 자릿수에 해당하는 count 증가
    for (i = 0; i < n; i++){
        count[(arr[i] / exp) % 10]++;
    }
    // 누적합 구하기
    for (i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }
    // 일반적인 Counting sort 과정
    for (i = n - 1; i >= 0; i--) {
        buffer[count[(arr[i]/exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    for (i = 0; i < n; i++){
        arr[i] = buffer[i];
    }
}

void radixsort(int arr[], int n) {
     // 최댓값 자리만큼 돌기
    int m = getMax(arr, n);
    
    // 최댓값을 나눴을 때, 0이 나오면 모든 숫자가 exp의 아래
    for (int exp = 1; m / exp > 0; exp *= 10) {
        countSort(arr, n, exp);
    }
}
int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);			// 좋은 습관
    radixsort(arr, n);
    
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    return 0;
}
```



#### 질문

---

Q1) 왜 낮은 자리수부터 정렬을 합니까?

MSD (Most-Significant-Digit) 과 LSD (Least-Significant-Digit)을 비교하라는 질문

MSD는 가장 큰 자리수부터 Counting sort 하는 것을 의미하고, LSD는 가장 낮은 자리수부터 Counting sort 하는 것을 의미함. (즉, 둘 다 할 수 있음)

* LSD의 경우 1600000 과 1을 비교할 때, Digit의 갯수만큼 따져야하는 단점이 있음.
  그에 반해 MSD는 마지막 자리수까지 확인해 볼 필요가 없음.
* LSD는 중간에 정렬 결과를 알 수 없음. (예) 10004와 70002의 비교)
  반면, MSD는 중간에 중요한 숫자를 알 수 있음. 따라서 시간을 줄일 수 있음. 그러나, 정렬이 되었는지 확인하는 과정이 필요하고, 이 때문에 메모리를 더 사용
* LSD는 알고리즘이 일관됨 (Branch Free algorithm)
  그러나 MSD는 일관되지 못함. --> 따라서 Radix sort는 주로 LSD를 언급함.
* LSD는 자릿수가 정해진 경우 좀 더 빠를 수 있음.