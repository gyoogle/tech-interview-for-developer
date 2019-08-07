## LIS (Longest Increasing Sequence)

> 최장 증가 수열 : 가장 긴 증가하는 부분 수열

[ 7, **2**, **3**, 8, **4**, **5** ] → 해당 배열에서는 [2,3,4,5]가 LIS로 답은 4

<br>

##### 구현 방법 (시간복잡도)

1. DP : O(N^2)
2. Lower Bound : O(NlogN)

<br>

##### DP 활용 코드

```java
int arr[] = {7, 2, 3, 8, 4, 5};
int dp[] = new int[arr.length]; // LIS 저장 배열


for(int i = 1; i < dp.length; i++) {
    if(dp[i] == 0) dp[i] = 1;
    for(int j = i-1; j>=0; j--) {
        if(arr[i] > arr[i-1]) {
            dp[i] = (dp[i] < dp[j]+1) ? dp[j]+1 : dp[i];
        }
    }
}
// 저장된 dp 배열 값 : [0, 1, 2, 3, 1, 4]
// LIS : dp배열에 저장된 값 중 최대 값 
```

<br>

하지만, N^2으로 해결할 수 없는 문제라면? (ex. 배열의 길이가 최대 10만일 때..)

이때는 Lower Bound를 활용한 LIS 구현을 진행해야한다.

