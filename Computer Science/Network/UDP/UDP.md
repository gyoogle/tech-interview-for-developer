#### UDP

---

UDP (User Datagram Protocol)

Transport layer에서 사용하는 프로토콜.

----

<기문>

왜 IP로만 안되나? / ICMP - 오류를 알려줄 뿐 제어를 못함.

----



0. UDP의 정의

   인터넷 상에서 서로 정보를 주고 받을 때, 보내거나 받는다는 신호 절차를 거치지 않고, 보내는 쪽에서 일방적으로 데이터를 전달하는 통신 프로토콜.

   송신자는 수신자가 데이터를 받았는지 아닌지 확인할 수 없고, 확인할 필요도 없다.

1. UDP 특징

   - Unreliability

     UDP로 전송된 패킷의 순서가 바뀌었는지, 중간에 손실이 일어났는지 확인할 방법이 없음.

     따라서, datagram 위주의 통신을 하므로, datagram 지향 프로토콜이라 불림.

   실시간 스트리밍 서비스에서는 UDP가 사용되는데, 신뢰성을 보장하기 위한 방식의 TCP를 사용하는 경우, 조금의 데이터 확보가 없더라도, 버퍼링이 생기고, 혼잡제어를 위해 보내는 양도 존재하므로, 영상 데이터의 퀄리티가 바뀜. / 온라인 게임에 쓰임.

   TCP의 신뢰성 매커니즘 기능이 없다.

----

UDP Header

<img src="https://seolhun.github.io/images/contents/20180426/network/udp-header.png">

1. source port
2. destination port
3. length
4. **<u>checksum</u>**
5. data

이렇게 간단하므로, TCP 보다 용량이 가볍고 송신 속도가 빠르게 작동됨.

그러나 확인 응답을 못하므로, TCP보다 신뢰도가 떨어짐.

UDP는 비연결성, TCP는 연결성으로 정의할 수 있음.

---

#### DNS과 UDP 통신 프로토콜을 사용함.

DNS는 데이터를 교환하는 경우임

이때, TCP를 사용하게 되면, 데이터를 송신할 때까지 세션 확립을 위한 처리를 하고, 송신한 데이터가 수신되었는지 점검하는 과정이 필요하므로, Protocol overhead가 UDP에 비해서 큼.

----

DNS는 Application layer protocol임.

모든 Application layer protocol은 TCP, UDP 중 하나의 Transport layer protocol을 사용해야 함.

(TCP는 reliable, UDP는 not reliable임) / DNS는 reliable해야할 것 같은데 왜 UDP를 사용할까?



사용하는 이유 

1. TCP가 3-way handshake를 사용하는 반면, UDP는 connection 을 유지할 필요가 없음.

2. DNS request는 UDP segment에 꼭 들어갈 정도로 작음.

   DNS query는 single UDP request와 server로부터의 single UDP reply로 구성되어 있음.

3. UDP는 not reliable이나, reliability는 application layer에 추가될 수 있음.
   (Timeout 추가나, resend 작업을 통해)

DNS는 UDP를 53번 port에서 사용함.

---

그러나 TCP를 사용하는 경우가 있음.

Zone transfer 을 사용해야하는 경우에는 TCP를 사용해야 함.

(Zone Transfer : DNS 서버 간의 요청을 주고 받을 떄 사용하는 transfer)

만약에 데이터가 512 bytes를 넘거나, 응답을 못받은 경우 TCP로 함.



<https://www.geeksforgeeks.org/why-does-dns-use-udp-and-not-tcp/>

<https://support.microsoft.com/en-us/help/556000>

-----

