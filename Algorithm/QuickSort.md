안전 정렬 : 동일한 값에 기존 순서가 유지 (버블, 삽입)

불안정 정렬 : 동일한 값에 기존 순서가 유지X (선택,퀵)



#### 퀵소트

---

퀵소트는 최악의 경우 O(n^2), 평균적으로 O(nlogn)을 가짐



```java
public void quickSort(int[] array, int left, int right) {
    
    if(left >= right) return;
    
    int pi = partition();
    
    quickSort(array, left, pi-1);
    quickSort(array, pi+1, right);
    
}
```



피벗 선택 방식 : 첫번째, 중간, 마지막, 랜덤

(선택 방식에 따라 속도가 달라지므로 중요함)



```java
public int partition(int[] array, int left, int right) {
    int pivot = array[left];
    int i = left, j = right;
    
    while(i < j) {
        while(pivot < array[j]) {
            j--;
        }
        while(i<j && pivot >= array[i]){
            i++;
        }
        swap(array, i, j);
    }
    array[left] = array[i];
    array[i] = pivot;
    
    return i;
}
```

1. 피벗 선택
2. 오른쪽(j)에서 왼쪽으로 가면서 피벗보다 작은 수 찾음
3. 왼쪽(i)에서 오른쪽으로 가면서 피벗보다 큰 수 찾음
4. 각 인덱스 i, j에 대한 요소를 교환
5. 2,3,4번 과정 반복
6. 더이상 2,3번 진행이 불가능하면, 현재 피벗과 교환
7. 이제 교환된 피벗 기준으로 왼쪽엔 피벗보다 작은 값, 오른쪽엔 큰 값들만 존재함



---



버블정렬은 모든 배열의 요소에 대한 인덱스를 하나하나 증가하며 비교해나가는 O(n^2)

퀵정렬의 경우 인접한 것이 아닌 서로 먼 거리에 있는 요소를 교환하면서 속도를 줄일 수 있음

But, **피벗 값이 최소나 최대값으로 지정되어 파티션이 나누어지지 않았을 때** O(n^2)에 대한 시간복잡도를 가짐



#### 퀵소트 O(n^2) 해결 방법

---

이런 상황에서는 퀵소트 장점이 사라지므로, 피벗을 선택할 때 `중간 요소`로 선택하면 해결이 가능함



```java
public int partition(int[] array, int left, int right) {
    int mid = (left + right) / 2;
    swap(array, left, mid);
    ...
}
```

이는 다른 O(nlogn) 시간복잡도를 가진 소트들보다 빠르다고 알려져있음

> 먼거리 교환 처리 + 캐시 효율(한번 선택된 기준은 제외시킴)



```java
private void solve() {
    int[] array = { 80, 70, 60, 50, 40, 30, 20 };
    quicksort(array, 0, array.length - 1);
 
    for (int v : array) {
        System.out.println(v);
    }
}
 
public static int partition(int[] array, int left, int right) {
    int mid = (left + right) / 2;
    swap(array, left, mid);
 
    int pivot = array[left];
    int i = left, j = right;
 
    while (i < j) {
        while (pivot < array[j]) {
            j--;
        }
 
        while (i < j && pivot >= array[i]) {
            i++;
        }
        swap(array, i, j);
    }
    array[left] = array[i];
    array[i] = pivot;
    return i;
}
 
public static void swap(int[] array, int a, int b) {
    int temp = array[b];
    array[b] = array[a];
    array[a] = temp;
}
 
public static void quicksort(int[] array, int left, int right) {
    if (left >= right) {
        return;
    }
 
    int pi = partition(array, left, right);
 
    quicksort(array, left, pi - 1);
    quicksort(array, pi + 1, right);
}

```

