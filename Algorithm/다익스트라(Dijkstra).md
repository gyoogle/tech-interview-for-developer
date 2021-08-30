# 다익스트라(Dijkstra) 알고리즘

<br>

```
DP를 활용한 최단 경로 탐색 알고리즘
```

<br>



<img src="https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif">

<br>

다익스트라 알고리즘은 특정한 정점에서 다른 모든 정점으로 가는 최단 경로를 기록한다.

여기서 DP가 적용되는 이유는, 굳이 한 번 최단 거리를 구한 곳은 다시 구할 필요가 없기 때문이다. 이를 활용해 정점에서 정점까지 간선을 따라 이동할 때 최단 거리를 효율적으로 구할 수 있다.

<br>

다익스트라를 구현하기 위해 두 가지를 저장해야 한다.

- 해당 정점까지의 최단 거리를 저장

- 정점을 방문했는 지 저장

시작 정점으로부터 정점들의 최단 거리를 저장하는 배열과, 방문 여부를 저장하는 것이다.

<br>

다익스트라의 알고리즘 순서는 아래와 같다.

1. ##### 최단 거리 값은 무한대 값으로 초기화한다.

   ```java
   for(int i = 1; i <= n; i++){
       distance[i] = Integer.MAX_VALUE;
   }
   ```

2. ##### 시작 정점의 최단 거리는 0이다. 그리고 시작 정점을 방문 처리한다.

   ```java
   distance[start] = 0;
   visited[start] = true;
   ```

3. ##### 시작 정점과 연결된 정점들의 최단 거리 값을 갱신한다.

   ```java
   for(int i = 1; i <= n; i++){
       if(!visited[i] && map[start][i] != 0) {
       	distance[i] = map[start][i];
       }
   }
   ```

4. ##### 방문하지 않은 정점 중 최단 거리가 최소인 정점을 찾는다.

   ```java
   int min = Integer.MAX_VALUE;
   int midx = -1;
   
   for(int i = 1; i <= n; i++){
       if(!visited[i] && distance[i] != Integer.MAX_VALUE) {
       	if(distance[i] < min) {
               min = distance[i];
               midx = i;
           }
       }
   }
   ```

5. ##### 찾은 정점을 방문 체크로 변경 후, 해당 정점과 연결된 방문하지 않은 정점의 최단 거리 값을 갱신한다.

   ```java
   visited[midx] = true;
   for(int i = 1; i <= n; i++){
       if(!visited[i] && map[midx][i] != 0) {
       	if(distance[i] > distance[midx] + map[midx][i]) {
               distance[i] = distance[midx] + map[midx][i];
           }
       }
   }
   ```

6. ##### 모든 정점을 방문할 때까지 4~5번을 반복한다.

<br>

#### 다익스트라 적용 시 알아야할 점

- 인접 행렬로 구현하면 시간 복잡도는 O(N^2)이다.

- 인접 리스트로 구현하면 시간 복잡도는 O(N*logN)이다.

  > 선형 탐색으로 시간 초과가 나는 문제는 인접 리스트로 접근해야한다. (우선순위 큐)

- 간선의 값이 양수일 때만 가능하다.

<br>

<br>

#### [참고사항]

- [링크](https://ko.wikipedia.org/wiki/%EB%8D%B0%EC%9D%B4%ED%81%AC%EC%8A%A4%ED%8A%B8%EB%9D%BC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- [링크](https://bumbums.tistory.com/4)