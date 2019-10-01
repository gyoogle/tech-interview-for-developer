1. ##### 일치하는 자료구조 작성하기

   > 1) 문자열이 주어지고 빠른 검색 ~~ : 해시
   >
   > 2) 운영체제 라운드 로빈에서 사용 ~~ : 연결리스트 
   >
   > 3) 우선순위로 뽑고 ~~~ : 힙
   >
   > 4) 후위연산하는 ~~ : 스택

2. ##### FCFS 스케줄링 평균반환시간, 평균대기시간 구하기

3. ##### 고객 - 주문 - 주문서의 (일대일, 일대다, 다대일, 다대다) 관계 구하기

4. ##### Binary Tree 수도코드

   > Tree node size 구하기 : left + right + 1
   >
   > Tree node depth 구하기 : max(left, right) + 1

5. ##### 배열 x와 배열 y의 일치값 찾는 시간복잡도의 최악과 최선은?

   ```java
   boolean chk = false;
   for(int i = 0; i < arr1.length i++) {
       for(int j = 0; j < arr2.length; j++) {
           if(arr1[i] == arr[j]) {
               chk = true;
               return;
           }
       }
   }
   ```

6. ##### BFS 수도코드

   ```
   1) queue 생성
   2) enqueue()
   while() {
       3) dequeue()
       
       if() {
           4) enqueue()
       }
   }
   ```

6. ##### Binary Search 수도코드

   > start와 end를 어떻게 바꿔가야하는 지 작성
   >
   > ```
   > if(arr[mid] < value) {
   >     1) start = mid + 1;
   > }
   > else(arr[mid] > value) {
   >     2) end = mid - 1;
   > }
   > ```

7. ##### 데드락 교착 상태 4가지 

8. ##### 제 2정규화 만들기

   > 1) 판매번호, 판매일자, 판매처 코드, 판매처명
   >
   > 2) 판매번호, 상품번호, 상품명, 단가, 수량
   >
   > 이 두개를 제2정규화 써서 다시 나누기

