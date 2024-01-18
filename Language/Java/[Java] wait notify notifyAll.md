#### Object 클래스 wait, notify, notifyAll

----

Java의 최상위 클래스 = Object 클래스

Object Class 가 갖고 있는 메서드

* toString()

* hashCode()

* wait()

  갖고 있던 **<u>고유 lock 해제, Thread를 잠들게 함</u>**

* notify()

  **<u>잠들던 Thread</u>** 중 임의의 **<u>하나를 깨움</u>**.

* notifyAll()

  잠들어 있던 Thread 를 **<u>모두 깨움</u>**.

  

  

*wait, notify, notifyAll : 호출하는 스레드가 반드시 고유 락을 갖고 있어야 함.*

=> Synchronized 블록 내에서 실행되어야 함.

=> 그 블록 안에서 호출하는 경우 IllegalMonitorStateException 발생.



