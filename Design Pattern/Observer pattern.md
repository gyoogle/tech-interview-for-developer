## 옵저버 패턴(Observer pattern)

> 상태를 가지고 있는 주체 객체 & 상태의 변경을 알아야 하는 관찰 객체

(1 대 1 or 1 대 N 관계)

서로의 정보를 주고받는 과정에서 정보의 단위가 클수록, 객체들의 규모가 클수록 복잡성이 증가하게 된다. 이때 가이드라인을 제시해줄 수 있는 것이 '옵저버 패턴'

<br>

##### 주체 객체와 관찰 객체의 예는?

```
잡지사 : 구독자
우유배달업체 : 고객
```

구독자, 고객들은 정보를 얻거나 받아야 하는 주체와 관계를 형성하게 된다. 관계가 지속되다가 정보를 원하지 않으면 해제할 수도 있다. (잡지 구독을 취소하거나 우유 배달을 중지하는 것처럼)

> 이때, 객체와의 관계를 맺고 끊는 상태 변경 정보를 Observer에 알려줘서 관리하는 것을 말한다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile9.uf.tistory.com%2Fimage%2F2214233B56A4D98611449A">

- ##### Publisher 인터페이스

  > Observer들을 관리하는 메소드를 가지고 있음
  >
  > 옵저버 등록(add), 제외(delete), 옵저버들에게 정보를 알려줌(notifyObserver)

  ```java
  public interface Publisher { 
      public void add(Observer observer); 
      public void delete(Observer observer); 
      public void notifyObserver(); 
  }
  ```

  <br>

- ##### Observer 인터페이스

  > 정보를 업데이트(update)

  ```java
  public interface Observer { 
      public void update(String title, String news); }
  ```

  <br>

- ##### NewsMachine 클래스

  > Publisher를 구현한 클래스로, 정보를 제공해주는 퍼블리셔가 됨

  ```java
  public class NewsMachine implements Publisher {
      private ArrayList<Observer> observers; 
      private String title; 
      private String news; 
  
      public NewsMachine() {
          observers = new ArrayList<>(); 
      }
      
      @Override public void add(Observer observer) {
          observers.add(observer);
      }
      
      @Override public void delete(Observer observer) 	{ 
          int index = observers.indexOf(observer);
          observers.remove(index); 
      }
      
      @Override public void notifyObserver() {
          for(Observer observer : observers) {
             observer.update(title, news); 
          }
      } 
      
      public void setNewsInfo(String title, String news) { 
          this.title = title; 
          this.news = news; 
          notifyObserver(); 
      } 
      
      public String getTitle() { return title; } 		public String getNews() { return news; }
  }
  ```

  <br>

- ##### AnnualSubscriber, EventSubscriber 클래스

  > Observer를 구현한 클래스들로, notifyObserver()를 호출하면서 알려줄 때마다 Update가 호출됨

  ```java
  public class EventSubscriber implements Observer {
      
      private String newsString;
      private Publisher publisher;
      
      public EventSubscriber(Publisher publisher) {
          this.publisher = publisher;
          publisher.add(this);
      }
      
      @Override
      public void update(String title, String news) {
          newsString = title + " " + news;
          display();
      }
      
      public void withdraw() {
          publisher.delete(this);
      }
      
      public void display() {
          System.out.println("이벤트 유저");
          System.out.println(newsString);
      }
      
  }
  ```

  <br>

<br>

Java에는 옵저버 패턴을 적용한 것들을 기본적으로 제공해줌

> Observer 인터페이스, Observable 클래스

하지만 Observable은 클래스로 구현되어 있기 때문에 사용하려면 상속을 해야 함. 따라서 다른 상속을 함께 이용할 수 없는 단점 존재

<br>

<br>

#### 정리

> 옵저버 패턴은, 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들에게 연락이 가고, 자동으로 정보가 갱신되는 1:N 관계(혹은 1대1)를 정의한다.
>
> 인터페이스를 통해 연결하여 느슨한 결합성을 유지하며, Publisher와 Observer 인터페이스를 적용한다.
>
> 안드로이드 개발시, OnClickListener와 같은 것들이 옵저버 패턴이 적용된 것 (버튼(Publisher)을 클릭했을 때 상태 변화를 옵저버인 OnClickListener로 알려주로독 함)

<br>

##### [참고]

[링크](<https://flowarc.tistory.com/entry/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-%EC%98%B5%EC%A0%80%EB%B2%84-%ED%8C%A8%ED%84%B4Observer-Pattern>)
