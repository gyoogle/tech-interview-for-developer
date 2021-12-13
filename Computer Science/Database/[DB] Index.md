# Index(인덱스)

<br>

#### 목적

```
추가적인 쓰기 작업과 저장 공간을 활용하여 데이터베이스 테이블의 검색 속도를 향상시키기 위한 자료구조
```

테이블의 칼럼을 색인화한다.

> 마치, 두꺼운 책의 목차와 같다고 생각하면 편하다.

데이터베이스 안의 레코드를 처음부터 풀스캔하지 않고, B+ Tree로 구성된 구조에서 Index 파일 검색으로 속도를 향상시키는 기술이다.

<br>

<br>

#### 파일 구성

테이블 생성 시, 3가지 파일이 생성된다.

- FRM : 테이블 구조 저장 파일
- MYD : 실제 데이터 파일
- MYI : Index 정보 파일 (Index 사용 시 생성)

<br>

사용자가 쿼리를 통해 Index를 사용하는 칼럼을 검색하게 되면, 이때 MYI 파일의 내용을 활용한다.

<BR>

#### 단점 

* Index 생성시, .mdb 파일 크기가 증가한다.
* **한 페이지를 동시에 수정할 수 있는 병행성**이 줄어든다.
* 인덱스 된 Field에서 Data를 업데이트하거나, **Record를 추가 또는 삭제시 성능이 떨어진다.**
* 데이터 변경 작업이 자주 일어나는 경우, **Index를 재작성**해야 하므로 성능에 영향을 미친다.

<br>

#### 상황 분석

* ##### 사용하면 좋은 경우

  (1) Where 절에서 자주 사용되는 Column

  (2) 외래키가 사용되는 Column

  (3) Join에 자주 사용되는 Column

  <br>

* ##### Index 사용을 피해야 하는 경우

  (1) Data 중복도가 높은 Column

  (2) DML이 자주 일어나는 Column

<br>

#### DML이 일어났을 때의 상황

* ##### INSERT

  기존 Block에 여유가 없을 때, 새로운 Data가 입력된다.

  → 새로운 Block을 할당 받은 후, Key를 옮기는 작업을 수행한다.

  → Index split 작업 동안, 해당 Block의 Key 값에 대해서 DML이 블로킹 된다. (대기 이벤트 발생)

* ##### DELETE

  <Table과 Index 상황 비교>

  Table에서 data가 delete 되는 경우 : Data가 지워지고, 다른 Data가 그 공간을 사용 가능하다.

  Index에서 Data가 delete 되는 경우 : Data가 지워지지 않고, 사용 안 됨 표시만 해둔다.

  → **Table의 Data 수와 Index의 Data 수가 다를 수 있음**

* ##### UPDATE

  Table에서 update가 발생하면 → Index는 Update 할 수 없다.

  Index에서는 **Delete가 발생한 후, 새로운 작업의 Insert 작업** / 2배의 작업이 소요되어 힘들다.

<br>

<br>

##### [참고사항]

- [링크](https://lalwr.blogspot.com/2016/02/db-index.html)
