## TDD(Test Driven Development)


##### TDD : 테스트 주도 개발

'테스트가 개발을 이끌어 나간다.'

<br>
<br>
우리는 보통 개발할 때, 설계(디자인)를 한 이후 코드 개발과 테스트 과정을 거치게 된다.
<br>


![img](https://mblogthumb-phinf.pstatic.net/MjAxNzA2MjhfMTU0/MDAxNDk4NjA2NTAyNjU2.zKGh5ZuYgToTz6p1lWgMC_Xb30i7uU86Yh00N2XrpMwg.8b3X9cCS6_ijzWyXEiQFombsWM1J8FlU9LhQ2j0nanog.PNG.suresofttech/image.png?type=w800)


<br>
하지만 TDD는 기존 방법과는 다르게, 테스트케이스를 먼저 작성한 이후에 실제 코드를 개발하는 리팩토링 절차를 밟는다.
<br>


![img](https://mblogthumb-phinf.pstatic.net/MjAxNzA2MjhfMjE3/MDAxNDk4NjA2NTExNDgw.fp8XF9y__Kz75n86xknIPDthTHj9a8Q08ocIJIqMR6Ag.24jJa_8_T0Qj04P62FZbchqt8oTNXGFSLUItzMP95s8g.PNG.suresofttech/image.png?type=w800)
<br>
```
작가가 책을 쓰는 과정에 대해서 생각해보자.

책을 쓰기 전, 목차를 먼저 구성한다.
이후 목차에 맞는 내용을 먼저 구상한 뒤, 초안을 작성하고 고쳐쓰기를 반복한다.

목차 구성 : 테스트 코드 작성
초안 작성 : 코드 개발
고쳐 쓰기 : 코드 수정(리팩토링)
```
<br>


반복적인 '검토'와 '고쳐쓰기'를 통해 좋은 글이 완성된다. 이런 방법을 소프트웨어에 적용한 것이 TDD!

> 소프트웨어 또한 반복적인 테스트와 수정을 통해 고품질의 소프트웨어를 탄생시킬 수 있다.


##### 장점

작업과 동시에 테스트를 진행하면서 실시간으로 오류 파악이 가능함 ( 시스템 결함 방지 )

짧은 개발 주기를 통해 고객의 요구사항 빠르게 수용 가능. 피드백이 가능하고 진행 상황 파악이 쉬움

자동화 도구를 이용한 TDD 테스트케이스를 단위 테스트로 사용이 가능함

(자바는 JUnit, C와 C++은 CppUnit 등)

##### 단점

기존 개발 프로세스에 테스트케이스 설계가 추가되므로 생산 비용 증가

테스트의 방향성, 프로젝트 성격에 따른 테스트 프레임워크 선택 등 추가로 고려할 부분의 증가

<br>
<br>
<br>

#### 점수 계산 프로그램을 통한 TDD 예제 진행

---

중간고사, 기말고사, 과제 점수를 통한 성적을 내는 간단한 프로그램을 만들어보자

점수 총합 90점 이상은 A, 80점 이상은 B, 70점 이상은 C, 60점 이상은 D, 나머지는 F다.

<br>

TDD 테스트케이스를 먼저 작성한다.

35 + 25 + 25 = 85점이므로 등급이 B가 나와야 한다.

따라서 assertEquals의 인자값을 "B"로 주고, 테스트 결과가 일치하는지 확인하는 과정을 진행해보자
<br>
```java
public class GradeTest {
    
    @Test
    public void scoreResult() {
        
        Score score = new Score(35, 25, 25); // Score 클래스 생성
        SimpleScoreStrategy scores = new SimpleScoreStrategy();
        
        String resultGrade = scores.computeGrade(score); // 점수 계산
        
        assertEquals("B", resultGrade); // 확인
    }
    
}
```
<br>
<br>

현재는 **Score 클래스와 computeGrade() 메소드가 구현되지 않은 상태**다. (테스트 코드로만 존재)

테스트 코드에 맞춰서 코드 개발을 진행하자
<br>
<br>

우선 점수를 저장할 Score 클래스를 생성한다
<br>
````java
public class Score {
    
    private int middleScore = 0;
    private int finalScore = 0;
    private int homeworkScore = 0;
    
    public Score(int middleScore, int finalScore, int homeworkScore) {
        this.middleScore = middleScore;
        this.finalScore = finalScore;
        this.homeworkScore = homeworkScore;
    }
    
    public int getMiddleScore(){
        return middleScore;
    }
    
    public int getFinalScore(){
        return finalScore;
    }
    
    public int getHomeworkScore(){
        return homeworkScore;
    }
    
}
````
<br>
<br>

이제 점수 계산을 통해 성적을 뿌려줄 computeGrade() 메소드를 가진 클래스를 만든다.

<br>

우선 인터페이스를 구현하자
<br>
```java
public interface ScoreStrategy {
    
    public String computeGrade(Score score);
    
}
```

<br>

인터페이스를 가져와 오버라이딩한 클래스를 구현한다
<br>
```java
public class SimpleScoreStrategy implements ScoreStrategy {
    
    public String computeGrade(Score score) {
        
        int totalScore = score.getMiddleScore() + score.getFinalScore() + score.getHomeworkScore(); // 점수 총합
        
        String gradeResult = null; // 학점 저장할 String 변수
        
        if(totalScore >= 90) {
            gradeResult = "A";
        } else if(totalScore >= 80) {
            gradeResult = "B";
        } else if(totalScore >= 70) {
            gradeResult = "C";
        } else if(totalScore >= 60) {
            gradeResult = "D";
        } else {
            gradeResult = "F";
        }
        
        return gradeResult;
    }
    
}
```
<br>
<br>

이제 테스트 코드로 돌아가서, 실제로 통과할 정보를 입력해본 뒤 결과를 확인해보자

이때 예외 처리, 중복 제거, 추가 기능을 통한 리팩토링 작업을 통해 완성도 높은 프로젝트를 구현할 수 있도록 노력하자!

<br>

통과가 가능한 정보를 넣고 실행하면, 아래와 같이 에러 없이 제대로 실행되는 모습을 볼 수 있다.
<br>
<br>

![img](https://mblogthumb-phinf.pstatic.net/MjAxNzA2MjhfMjQx/MDAxNDk4NjA2NjM0MzIw.LGPVpvam5De7ibWipMqiGHZPjRcKWQKYhLbKgnL6i78g.8vplllDO1pfKFs5Wua9ZLl7b6g6kHbjG-6M--HmDRCwg.PNG.suresofttech/image.png?type=w800)

<br>
<br>


***굳이 필요하나요?***

딱봐도 귀찮아 보인다. 저렇게 확인 안해도 결과물을 알 수 있지 않냐고 반문할 수도 있다.

하지만 예시는 간단하게 보였을 뿐, 실제 실무 프로젝트에서는 다양한 출력 결과물이 필요하고, 원하는 테스트 결과가 나오는 지 확인하는 과정은 필수적인 부분이다.



TDD를 활용하면, 처음 시작하는 단계에서 테스트케이스를 설계하기 위한 초기 비용이 확실히 더 들게 된다. 하지만 개발 과정에 있어서 '초기 비용'보다 '유지보수 비용'이 더 클 수 있다는 것을 명심하자

또한 안전성이 필요한 소프트웨어 프로젝트에서는 개발 초기 단계부터 확실하게 다져놓고 가는 것이 중요하다. 

유지보수 비용이 더 크거나 비행기, 기차에 필요한 소프트웨어 등 안전성이 중요한 프로젝트의 경우 현재 실무에서도 TDD를 활용한 개발을 통해 이루어지고 있다.



