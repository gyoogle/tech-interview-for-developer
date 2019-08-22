#### TCP

---

TCP는 기본적으로 unreliable network에서, reliable network를 보장할 수 있도록 하는 프로토콜

reliable network를 보장한다는 것은...

- 손실 : packet이 손실될 수 있는 문제
- 순서 바뀜 : packet의 순서가 바뀌는 문제
- Congestion : 네트워크가 혼잡한 문제
- Overload : receiver가 overload 되는 문제

등 약 4가지의 문제점이 있다.

---

#### stop & wait / Sliding Window ( gobackN는 sliding window의 하나의 예) / SR

---

#### Flow Control (endsystem 대 endsystem)

---

Flow Control은 receiver가 packet을 지나치게 많이 받지 않도록 조절하는 것

기본 개념은 receiver가 sender에게 현재 자신의 상태를 feedback 한다는 점.

----

#### 전송의 전체 과정

Application layer : sender application layer가 socket에 data를 씀.

Transport layer : data를 segment에 감싼다. 그리고 network layer에 넘겨줌.

그러면 아랫단에서 어쨋든 receiving node로 전송이 됨.

이 때,  sender의 send buffer에 data를 저장하고, receiver는 receive buffer에 data를 저장함.

application에서 준비가 되면 이 buffer에 있는 것을 읽기 시작함.

따라서 flow control의 핵심은 이 receiver buffer가 넘치지 않게 하는 것임.

따라서 receiver는 RWND(Receive WiNDow) : receive buffer의 남은 공간을 홍보함

---

#### Sliding window

목적 : 전송은 되었지만, acked를 받지 못한 byte의 숫자를 파악하기 위해 사용하는 protocol

LastByteSent - LastByteAcked <= ReceivecWindowAdvertised

(마지막에 보내진 바이트 - 마지막에 확인된 바이트 <= 남아있는 공간) ==

(현재 공중에 떠있는 패킷 수 <= sliding window)

---

<https://www.brianstorti.com/tcp-flow-control/>

#### Stop ANd Wait

Go back N / SR





I referred to <https://www.brianstorti.com/tcp-flow-control/>