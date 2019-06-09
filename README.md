# Dev_BasicKnowledge
개발자(Developer)가 갖춰야 할 기본 지식 정리

<br>

<br>

### Concept

- [객체지향 프로그래밍](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Concept/Object-Oriented%20Programming.md)
- [클린코드 & 리팩토링](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Concept/Clean%20Code%20%26%20Refactoring.md)
- [TDD(Test Driven Development)](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Concept/TDD(Test%20Driven%20Development).md)

### Data Structure

- [스택 & 큐](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Data%20Structure/Stack%20%26%20Queue.md)

### Algorithm

- [퀵소트](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Algorithm/QuickSort.md)
- [머지소트](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Algorithm/MergeSort.md)
- [힙소트](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Algorithm/HeapSort.md)
- 카운팅소트
- Radix소트
- 

### Operation System

- [프로세스 vs 스레드](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/Process%20vs%20Thread.md)
- [데드락](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/DeadLock.md)
- [페이징 & 세그먼테이션](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/Paging%20and%20Segmentation.md) ([PDF](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/Paging%20and%20Segmentation.pdf))
- [페이지 교체 알고리즘](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/Page%20Replacement%20Algorithm.md)
- [메모리](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Operation%20System/Memory.md)

### Database

- [트랜잭션](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Database/Transaction.md)

### Design Pattern

- [어댑터 패턴](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Design%20Pattern/Adapter%20Pattern.md)
- [싱글톤 패턴](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Design%20Pattern/Singleton%20Pattern.md)

<br>
<br><br>
<br>



### 면접 준비하기

---

기술면접을 준비할 때는 절대 문제와 답을 읽는 식으로 하지 말 것

문제를 직접 푸는 훈련을 해야함

<br>

<br>

1. ##### 직접 문제를 풀수 있도록 노력하자

   > 포기하지말고, 최대한 힌트를 보지말고 답을 찾자

2. ##### 코드를 종이에 적자

   > 컴퓨터를 이용하면 코드 문법 강조나, 자동완성 기능으로 도움 받을 수 있기 때문에 손으로 먼저 적는 연습

3. ##### 코드를 테스트하자

   > 기본 조건, 오류 발생 조건 등을 테스트 하자. 왜냐하면 면접에서는 이 부분이 필수이기 때문

4. ##### 종이에 적은 코드를 그대로 컴퓨터로 옮기고 실행해보자

   > 종이로 적었을 때 실수를 많이 했을 것이다. 컴퓨터로 옮기면서 실수 목록을 적고 다음부터 저지르지 않도록 유의하자

<br>

<br>

#### 기술면접에서 필수로 알아야 할 것들

자료구조와 알고리즘은 코딩테스트와 기술면접에서 필수적인 부분

아래 나열된 영역은 모두 대비해야한다,

<br>

##### 자료구조

> 연결리스트(Linked Lists)
>
> 트리, 트라이(Tries), 그래프
>
> 스택 & 큐
>
> 힙(Heaps)
>
> Vector / ArrayList
>
> 해시테이블

<br>

##### 알고리즘

> BFS (너비 우선 탐색)
>
> DFS (깊이 우선 탐색)
>
> 이진 탐색
>
> 병합 정렬(Merge Sort)
>
> 퀵 정렬

<br>

##### 개념

> 비트 조작(Bit Manipulation)
>
> 메모리 (스택 vs 힙)
>
> 재귀
>
> DP (다이나믹 프로그래밍)
>
> big-O (시간과 공간 개념)

<br>

<br>

####  

#### 면접에서 문제가 주어지면 해야할 순서

1. 듣기

   > 문제 설명 관련 정보는 집중해서 듣자. 중요한 부분이 있을 수 있음

2. 예제

   > 직접 예제를 만들어서 디버깅하고 확인하기

3. 무식하게 풀기

   > 처음에는 최적의 알고리즘을 생각하지말고 무식하게 풀어보기

4. 최적화

   > BUD (병목현상, 불필요 작업, 중복 작업)을 최적화 시키며 개선하기

5. 검토하기

   > 다시 처음부터 실수가 없는지 검토하기

6. 구현하기

   > 모듈화된 코드 사용하기
   >
   > 에러를 검증하기
   >
   > 필요시, 다른 클래스나 구조체 사용하기
   >
   > 좋은 변수명 사용하기

7. 테스트

   > 개념적 테스트 - 코드 리뷰
   >
   > 특이한 코드들 확인
   >
   > 산술연산이나 NULL 노드 부분 실수 없나 확인
   >
   > 작은 크기의 테스트들 확인

<br>

면접관은 우리가 문제를 어떻게 풀었는 지, 과정을 알고 싶어하기 때문에 끊임없이 설명해야한다!

<br>

<br>

####  



#### 오답 대처법

---

면접에서 모든 문제의 정답을 맞춰야 할 필요는 없다.

면접관들은 답을 평가할 때 맞춤, 틀림으로 평가하지 않음

<br>

##### 중요하게 여기는 부분

- 얼마나 최종 답안이 최적 해법에 근접한가
- 최종 답안을 내는데 시간이 얼마나 걸렸나
- 얼마나 힌트를 필요로 했는가
- 얼마나 코드가 깔끔한가

<br>

또한 면접은 '상대평가'임. 즉, 문제가 어렵다면 다른 사람도 마찬가지이므로 너무 두려워하지 말 것

<br>

> 면접 기술문제는 보통 2~30분 안에 풀 수 있는 문제를 출제