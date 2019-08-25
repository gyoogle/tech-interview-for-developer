## LCA(Lowest Common Ancestor) 알고리즘

> 최소 공통 조상 찾는 알고리즘
>
> → 두 정점이 만나는 최초 부모 정점을 찾는 것!

트리 형식이 아래와 같이 주어졌다고 하자

<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/lca.png" width=400>

4와 5의 LCA는? → 4와 5의 첫 부모 정점은 '2'

4와 6의 LCA는? → 첫 부모 정점은 root인 '1'

***어떻게 찾죠?***

해당 정점의 depth와 parent를 저장해두는 방식이다. 현재 그림에서의 depth는 아래와 같을 것이다.

```
[depth : 정점]
0 → 1(root 정점)
1 → 2, 3
2 → 4, 5, 6, 7
```

<br>

parent는 정점마다 가지는 부모 정점을 저장해둔다. 위의 예시에서 저장된 parent 배열은 아래와 같다.

```java
// 1 ~ 7번 정점 (root는 부모가 없기 때문에 0)
int parent[] = {0, 1, 1, 2, 2, 3, 3}
```

이제

이 두 배열을 활용해서 두 정점이 주어졌을 때 LCA를 찾을 수 있다. 과정은 아래와 같다.

```java
// 두 정점의 depth 확인하기
while(true){
	if(depth가 일치)
		if(두 정점의 parent 일치?) LCA 찾음(종료)
        else 두 정점을 자신의 parent 정점 값으로 변경
    else // depth 불일치
        더 depth가 깊은 정점을 해당 정점의 parent 정점으로 변경(depth가 감소됨)
}
```

<br>

트리 문제에서 공통 조상을 찾아야하는 문제나, 정점과 정점 사이의 이동거리 또는 방문경로를 저장해야 할 경우 사용하면 된다. 