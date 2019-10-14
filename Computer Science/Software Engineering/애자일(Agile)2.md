Agile이란 무엇인가.

> 이 글의 목표는 Agile을 이해하는 것이다.
> 아래의 내용을 종합하여, Agile이 무엇인지 한 문장으로 정의할 수 있어야 한다.



---



### #0 Software Development Life Cycle (SDLC)

> 책 한권이 나오기 위해서는 집필 -> 디자인 -> 인쇄 -> 마케팅 의 과정이 필요하다.
> 소프트웨어 또한 개발 과정이 존재한다.
> 각 과정 (=단계 = task) 을 정의한 framework가 SDLC이다. 

여기서 당신은 반드시 SDLC와 Approach를 구분할 수 있어야 한다.
SDLC는 구체적인 방법과 방법론 (개발 과정의 단계와 순서를 명확히 구분) 을 의미하고,
Approach는 그런 SDLC를 유사한 개념적 특징에 따라 그룹지은 것을 의미한다.

Agile은 Approach이다.
Aglie에 속하는 방법론이 Scrum, XP이다. 

결론 1 : Agile은 SW Development Approach 중의 하나이다.





---



### #1 Agile이 될 조건 (Agile Manifesto)

> 모든 법은 헌법이 수호하는 가치를 위반해서는 안된다.
> 마찬가지로, Agile 또한 Agile이기 위해 헌법과 같은 4 Value와 12 Principle이 존재한다.

4 Value

- **<u>Individuals and interactions</u>** over Process and tools
  (프로세스나 도구보다 **<u>개인과 상호 작용</u>**)
- **<u>Working software</u>** over Comprehensive documentation
  (포괄적인 문서보다 **<u>작동 소프트웨어</u>**)
- **<u>Customer collaboration</u>** over Contract negotiation
  (계약 협상보다 **<u>고객과의 협력</u>**)
- **<u>Responding to change</u>** over Following a plan
  (계획 고수보다 **<u>변화에 대응</u>**)



> 4 value 모두, 뛰어넘어야 하는 대상을 명시하고 있다.
> 비교 대상은 기존의 개발 방법론에서 거쳤던 과정이다.
> 우리는 이를 통해, Agile 방법론이, 기존 프로젝트 개발 방법론의 문제점을 극복하기 위해 탄생한 것임을 알 수 있다.



결론 2 : Agile은 다른 SW Development Approach의 한계를 극복하기 위해 탄생하였다.

---



### #2 기존 Approach (접근법)

> Agile의 핵심 가치들이 모두 기존 개발 접근법의 한계를 극복하기 위해 탄생하였다.
> 그러므로, 기존의 접근법을 알아야 한다.

핵심 접근법 4가지

- Predictive (SDLC : Waterfall)
  분석, 디자인, 빌드, 테스트, deliver로 이어지는 전형적인 방식

- Iterative (SDLC : Spiral)
  요구 사항과 일치할 때까지 분석과 디자인 반복 이후 빌드와 테스트 마찬가지 반복 
- Incremental
  분석, 디자인, 빌드, 테스트, deliver을 조금씩 추가.
- Agile
  `중요` Timebox의 단위로 제품을 만들고, 동시에 피드백 받음

|             |                  |                                |                             |                                              |
| ----------- | ---------------- | ------------------------------ | --------------------------- | -------------------------------------------- |
| Approach    | 고객의 요구 사항 | 시행                           | Delivery                    | 목표                                         |
| Predictive  | Fixed            | 전체 프로젝트에서 한 번만 시행 | Single Delivery             | 비용 관리                                    |
| Iterative   | Dynamic          | 옳을 때까지 반복               | Single Delivery             | 해결책의 정확성                              |
| Incremental | Dynamic          | 주어진 수행 횟수에서 한번 실행 | Frequent smaller deliveries | 속도                                         |
| Agile       | Dynamic          | 옳을 때까지 반복               | Frequent small deliveries   | 잦은 피드백과 delivery를 통한 고객 가치 제공 |

* Iterative와 Incremental의 차이는 Delivery에 있음.
* Agile과 Iterative, Incremental의 차이는 Goal에 있음.



결론 3 : Agile의 목표는 고객 가치 제공이며, 이를 가능케하는 가장 큰 특징은 Timeboxing이라는 개념이다.
(Agile 개발 접근법을 통해, 비용, 품질, 생산성이 증가한다고 말하는 것은 무리이며, 애초에 Agile의 목표도 아니다.)

----



### #3 Scrum을 통해 이해하는 Agile 핵심 개념

![Scrum procesì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://cdn-8a82.kxcdn.com/wp-content/uploads/2017/02/scrum_process_afa_5000.jpg)

> 이 그림을 통해 3가지를 이해해야한다.
>
> 1. Scrum 의 구성 단계 이해 : Product Backlog, Sprint Backlog 등
> 2. Scrum에서 정의하는 2가지 Role : Product Owner, Scrum Maste
> 3. Project 진행 상황을 파악하는 tool : Burn Down chart 등

1.
Product Backlog : 제품에 대한 요구 사항 목록
Sprint : 반복적인 개발 주기
Sprint Backlog : 개발 주기에 맞게 수행할 작업의 목록 및 목표
Shippable Product (그림에 없음) :  Sprint 후 개발된 실행 가능한 결과물

2.
Product Owner : Backlog 정의 후 우선순위를 세우는 역할
Scrum Master : 전통적인 프로젝트 관리자와 유사하나, Servant leadership이 요구됨

3.
BurnDown Chart :  남은 일 (Y축) - 시간 (X축) 그래프를 통해, 진행 사항 확인
-> 이런 tool은 Project Owner가 프로젝트 예상 진행 상황과, 실제 진행 상황을 비교함으로써, 프로젝트 기간을 연장할 것인지, 추가 Resource를 투입할 것인지, 아니면 마무리 할 것인지를 결정하는 데 근거 자료가 되므로 중요하다.



결론 4 : 일정한 주기 (Scrum에서는 Sprint)로 Shippable Product를 만들고,
고객의 요구를 더하고 수정하는 과정을 반복한다.



----

### #4 Agile의 5가지 Top Techniques

> Scrum을 통해 Agile의 기본 과정을 이해했다면,
> 그 세부 내용을 구성하는 Iteration (= Sprint) 및 반복의 과정에서 어떤 technique이 쓰이는지 이해해야한다.

- Daily Standup :  매일 아침 15분 정도 아래와 같은 형식으로 진행 상황을 공유한다.

```
어제 ~을 했고, 오늘 ~을 할 것이며, 현재 ~ 어려움이 있습니다.
```

- Retrospective : 고객이 없는 상황에서, Iteration이 끝난 후, 팀에서 어떤 것이 문제였고, 무엇을 고칠 수 있는지 이야기한다.
- Iteration Review : 고객이 함께 있는 상황에서 Iteration의 결과물로 나온 Shippable Product에 대한 피드백, 평가를 받는다.



결론 5 : Agile 접근법의 성공을 위해서는 세부적인 Technique을 전체 process에서 실행해야한다.