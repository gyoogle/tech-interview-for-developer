#### TCP (Transmission Control Protocol)

---

TCP에서 congestion은 일정 시간 안까지 acknowledgement를 받지 못했을 때를 의미한다.

TCP는 network congestion avoidance algorithm을 사용함.

algorithm은 대부분 AIMD(Additive Increase Multiplicative Decrease)를 기본 관점으로 한다.

slow start와 Cogestion Window 등이 있다.

---

Congestion Control (Router와 endsystem 사이의 차이)

#### Congestion Window

(TCP의 flow control을 위한 sliding window와 유사한 개념이나, Congestion Window는 sender에게, sliding window는 receiver에게 있음??)

TCP는 congestion을 피하기 위해 sender side의 congestion window를 활용한다.

Router에서 한다.

---

Congestion Window는 처음에 Maximum Segment Size(MSS) 몇 개의 사이즈만큼 있다.

#### Congestion Window의 사이즈가 바뀐다.

> Timeout 이 발생하는 경우, congestion window의 사이즈가 one maximum segment size(MSS)로 바뀐다.  Timeout이 발생하지 않는 경우 congestion window size는 1 MSS만큼 커진다 (= RTT(round-trip time)마다 두 배가 된다)

- Congestion Window Threshold

  Congestion Window Size의 절반이 됨.

- Congestion Window Size가 ssthresh (slow-start-threshold) 를 넘는 경우 algorithm은 새로운 상태, congestion avoidance 상태로 접어들게 되는데, 이때는 1MSS 만큼 커진다.

---

- Congestion : packet에 대한 acknowledgement를 timeout안에 받지 못한 경우 congestion. timeout이 생긴 segment에 대해서는 retransmit를 한다.
- Congestion Window : congestion을 피하기 위해 Sender Side에 존재, congestion window는 acknowledge 없이 보낼 수 있는 최대한의 데이터 양.



---

#### Network Congestion의 가정

가정 : 기본적으로 ack의 부족은 Network Congestion으로 인한 것으로 가정한다.

그러나, 다른 이유로 ack가 부족하다면, 매번 timer를 기다리는 것을 낭비가 될 수 있다.

따라서, TCP performance를 증가시키기 위해서는, timer를 기다리기 전에 재전송하는 것이 필요하다. 그래서 등장한 개념이 아래의 2가지이다.

---

#### AIMD, slowstart, Fast Retransmit, Fast Recovery algorithms..







<https://jwprogramming.tistory.com/37>