## 퍼미션(Permisson) 활용

<br>

리눅스의 모든 파일과 디렉토리는 퍼미션들의 집합으로 구성되어있다.

이러한 Permission은 시스템에 대한 읽기, 쓰기, 실행에 대한 접근 여부를 결정한다. (`ls -l`로 확인 가능)

퍼미션은, 다중 사용자 환경을 제공하는 리눅스에서는 가장 기초적인 보안 방법이다.

<br>

1. #### 접근 통제 기법

   - ##### DAC (Discretionary Access Control)

     객체에 대한 접근을 사용자 개인 or 그룹의 식별자를 기반으로 제어하는 방법

     > 운영체제 (윈도우, 리눅스)

   - ##### MAC (Mandotory Access Control)

     모든 접근 제어를 관리자가 설정한대로 제어되는 방법

     > 관리자에 의한 강제적 접근 제어

   - ##### RBAC (Role Based Access Control)

     관리자가 사용자에게는 특정한 역할을 부여하고, 각 역할마다 권리와 권한을 설정

     > 역할 기반 접근 제어

   <br>

2. #### 퍼미션 카테고리

   <img src="https://2.bp.blogspot.com/-oXS71qsqrlI/Wm7IDvD3SeI/AAAAAAAAFK8/LaKdTgnzOy8-zrPiLQwNKNW1THu6BLy-gCK4BGAYYCw/s640/2.jpg">

   > r : 읽기 / w : 쓰기 / x : 실행 / - : 권한 없음

   ex) `-rwxrw-r--. 1 root root 2104 1월 20 06:30 passwd`

   - `-rwx` : 소유자
   - `rw-` : 관리 그룹
   - `r--.` : 나머지
   - `1` : 링크 수
   - `root` : 소유자
   - `root` : 관리 그룹
   - `2104` : 파일크기
   - `1월 20 06:30` : 마지막 변경 날짜/시간
   - `passwd` : 파일 이름

   <br>

3. #### 퍼미션 모드

   ##### 1) 심볼릭 모드

   <img src="https://2.bp.blogspot.com/-KdFFNWoGqUY/Wm7IeG-pfkI/AAAAAAAAFLE/Owuy7AdISD04hr3qopYkyRp4x4FQtEcLQCK4BGAYYCw/s640/%25EB%25A6%25AC%25EB%2588%2585%25EC%258A%25A4%2Bchmod%2B%25EA%25B6%258C%25ED%2595%259C%2B%25EB%25B3%2580%25EA%25B2%25BD%2B002.png">

   <img src="https://1.bp.blogspot.com/-Hz-ZGGXFs_w/Wm7IjYOfYDI/AAAAAAAAFLM/LRXvFu1CbrQslwOy2LTCyQ8SHv7t-IDzwCK4BGAYYCw/s640/%25EB%25A6%25AC%25EB%2588%2585%25EC%258A%25A4%2Bchmod%2B%25EA%25B6%258C%25ED%2595%259C%2B%25EB%25B3%2580%25EA%25B2%25BD%2B001.png">

   명령어 : `chmod [권한] [파일 이름]`

   > 그룹(g)에게 실행 권한(x)를 더할 경우
   >
   > `chmod g+x`

   <br>

   ##### 2) 8진수 모드

   chmod 숫자 표기법은, 0~7까지의 8진수 조합을 사용자(u), 그룹(g), 기타(o)에 맞춰 숫자로 표기하는 것이다.

   > r = 4 / w = 2 / x = 1 / - = 0

   <img src="https://2.bp.blogspot.com/-BbQd6F9-8gA/Wm7I6zN-GQI/AAAAAAAAFLY/hVzeMS3JodsrpzLGPom8dav27RDfLfFVQCK4BGAYYCw/s320/15.jpg">

   <br>
   
   <br>
   
   ##### [참고 자료]
   
   - [링크](http://cocotp10.blogspot.com/2018/01/linux-centos7.html)

