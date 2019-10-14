#### [DB] Anomaly

---

> 정규화를 해야하는 이유는 잘못된 테이블 설계로 인해 Anomaly (이상 현상)가 나타나기 때문이다.
>
> 이 페이지에서는 Anomaly가 무엇인지 살펴본다.

예) {Student ID, Course ID, Department, Course ID, Grade}

1. 삽입 이상 (Insertion Anomaly)

   기본키가 {Student ID, Course ID} 인 경우 -> Course를 수강하지 않은 학생은 Course ID가 없는 현상이 발생함. 결국 Course ID를 Null로 할 수밖에 없는데, 기본키는 Null이 될 수 없으므로, Table에 추가될 수 없음.

   굳이 삽입하기 위해서는 '미수강'과 같은 Course ID를 만들어야 함.

   > 불필요한 데이터를 추가해야지, 삽입할 수 있는 상황 = Insertion Anomaly

   

2. 갱신 이상 (Update Anomaly)

   만약 어떤 학생의 전공 (Department) 이 "컴퓨터에서 음악"으로 바뀌는 경우.

   모든 Department를 "음악"으로 바꾸어야 함. 그러나 일부를 깜빡하고 바꾸지 못하는 경우, 제대로 파악 못함.

   > 일부만 변경하여, 데이터가 불일치 하는 모순의 문제 = Update Anomaly

   

3. 삭제 이상 (Deletion Anomaly)

   만약 어떤 학생이 수강을 철회하는 경우, {Student ID, Course ID, Department, Course ID, Grade}의 정보 중

   Student ID, Department 와 같은 학생에 대한 정보도 함께 삭제됨.

   > 튜플 삭제로 인해 꼭 필요한 데이터까지 함께 삭제되는 문제 = Deletion Anomaly



