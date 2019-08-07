# Hash Table 구현하기

> 알고리즘 문제를 풀기위해 필수적으로 알아야 할 개념

브루트 포스(완전 탐색)으로는 시간초과에 빠지게 되는 문제에서는 해시를 적용시켜야 한다.

<br>

[연습 문제 링크](<https://codeforces.com/contest/4/problem/C>)

<br>

N(1~100000)의 값만큼 문자열이 입력된다.

처음 입력되는 문자열은 "OK", 들어온 적이 있던 문자열은 "문자열+index"로 출력하면 된다.

ex)

##### Input

```
5
abcd
abc
abcd
abcd
ab
```

##### Output

```
OK
OK
abcd1
abcd2
OK
```

<br>

문제를 이해하는 건 쉽다. 똑같은 문자열이 들어왔는지 체크해보고, 들어온 문자열은 인덱스 번호를 부여해서 출력해주면 된다.

<br>

하지만, 현재 N값은 최대 10만이다. 브루트 포스로 접근하면 N^2이 되므로 100억번의 연산이 필요해서 시간초과에 빠질 것이다. 따라서 **'해시 테이블'**을 이용해 해결해야 한다. 

<br>

입력된 문자열 값을 해시 키로 변환시켜 저장하면서 최대한 시간을 줄여나가도록 구현해야 한다.

이 문제는 해시 테이블을 알고리즘에서 적용시켜보기 위해 연습하기에 아주 좋은 문제 같다. 특히 삼성 상시 SW역량테스트 B형을 준비하는 사람들에게 추천하고 싶은 문제다. 해시 테이블 구현을 연습하기 딱 좋다.

<br>

<br>

#### **해시 테이블 구현**

해시 테이블은 탐색을 최대한 줄여주기 위해, input에 대한 key 값을 얻어내서 관리하는 방식이다.

현재 최대 N 값은 10만이다. 이차원 배열로 1000/100으로 나누어 관리하면, 더 효율적일 것이다.

충돌 값이 들어오는 것을 감안해 최대한 고려해서, 나는 두번째 배열 값에 4를 곱해서 선언한다.

<br>

```

key 값을 얻어서 저장할 때, 서로다른 문자열이라도 같은 key 값으로 들어올 수 있다. 
(이것이 해시에 대한 이론을 배울 때 나오는 충돌 현상이다.)

충돌이 일어나는 것을 최대한 피해야하지만, 무조건 피할 수 있다는 보장은 없다. 그래서 두번째 배열 값을 조금 넉넉히 선언해두는 것이다.

```

이를 고려해 final 값으로 선언한 해시 값은 아래와 같다.

```java
static final int HASH_SIZE = 1000;
static final int HASH_LEN = 400;
static final int HASH_VAL = 17; // 소수로 할 것
```

HASH_VAL 값은 우리가 input 값을 받았을 때 해당하는 key 값을 얻을 때 활용한다.

최대한 input 값들마다 key 값이 겹치지 않기 위해 하기 위해서는 소수로 선언해야한다. (그래서 보통 17, 19, 23으로 선언하는 것 같다.)

<br>

key 값을 얻는 메소드 구현 방법은 아래와 같다. ( 각자 사람마다 다르므로 꼭 이게 정답은 아니다 )

```java
public static int getHashKey(String str) {
    
    int key = 0;
    
    for (int i = 0; i < str.length(); i++) {
        key = (key * HASH_VAL) + str.charAt(i);
    }
    
    if(key < 0) key = -key; // 만약 key 값이 음수면 양수로 바꿔주기
    
    return key % HASH_SIZE;
    
}
```

input 값을 매개변수로 받는다. 만약 string 값으로 들어온다고 가정해보자.

string 값의 한글자(character)마다 int형 값을 얻어낼 수 있다. 이를 활용해 string 값의 length만큼 반복문을 돌면서, 그 문자열만의 key 값을 만들어내는 것이 가능하다.

우리는 이 key 값을 배열 인덱스로 활용할 것이기 때문에 음수면 안된다. 만약 key 값의 결과가 음수면 양수로 바꿔주는 조건문이 필요하다.

<br>

마지막으로 return 값으로 key를 우리가 선언한 HASH_SIZE로 나눈 나머지 값을 얻도록 한다.

현재 계산된 key 값은 매우 크기 때문에 HASH_SIZE로 나눈 나머지 값으로 key를 활용할 것이다. (이 때문에 데이터가 많으면 많을수록 충돌되는 key값이 존재할 수 밖에 없다. - 우리는 최대한 충돌을 줄이면서 최적화시키기 위한 것..!)

<br>

이제 우리는 input으로 받은 string 값의 key 값을 얻었다.

해당 key 값의 배열에서 이 값이 들어온 적이 있는지 확인하는 과정이 필요하다.

<br>

이제 우리는 모든 곳을 탐색할 필요없이, 이 key에 해당하는 배열에서만 확인하면 되므로 시간이 엄~~청 절약된다.

<br>

```java
static int[][] data = new int[HASH_SIZE][HASH_LEN];

string str = "apple";

int key = getHashKey(str); // apple에 대한 key 값 얻음

data[key][index]; // 이곳에 apple을 저장해서 관리하면 찾는 시간을 줄일 수 있는 것
```

여기서 HASH_SIZE가 1000이었고, 우리가 key 값을 리턴할 때 1000으로 나눈 나머지로 저장했으므로 이 안에서만 key 값이 들어오게 된다는 것을 이해할 수 있다.

<br>

ArrayList로 2차원배열을 관리하면, 그냥 계속 추가해주면 되므로 구현이 간편하다.

하지만 삼성 sw 역량테스트 B형처럼 라이브러리를 사용하지 못하는 경우에는, 배열로 선언해서 추가해나가야 한다. 또한 ArrayList 활용보다 배열이 훨씬 시간을 줄일 수 있기 때문에 되도록이면 배열을 이용하도록 하자

<br>

여기서 끝은 아니다. 이제 우리는 단순히 key 값만 받아온 것 뿐이다.

해당 key 배열에서, apple이 들어온적이 있는지 없는지 체크해야한다. (문제에서 들어온적 있는건 숫자를 붙여서 출력해야 했기 때문이다.)

<br>

데이터의 수가 많으면 key 배열 안에서 다른 문자열이라도 같은 key로 저장되는 값들이 존재할 것이기 때문에 해당 key 배열을 돌면서 apple과 일치하는 문자열이 있는지 확인하는 과정이 필요하다.

<br>

따라서 key 값을 매개변수로 넣고 문자열이 들어왔던 적이 있는지 체크하는 함수를 구현하자

```java
public static int checking(int key) {
    
    int len = length[key]; // 현재 key에 담긴 수 (같은 key 값으로 들어오는 문자열이 있을 수 있다)
    
    if(len != 0) { // 이미 들어온 적 있음
        
        for (int i = 0; i < len; i++) { // 이미 들어온 문자열이 해당 key 배열에 있는지 확인
            if(str.equals(s_data[key][i])) {
                data[key][i]++;
                return data[key][i];
            }
        }
        
    }
    
    // 들어온 적이 없었으면 해당 key배열에서 문자열을 저장하고 길이 1 늘리기
    s_data[key][length[key]++] = str;

    return -1; // 처음으로 들어가는 경우 -1 리턴
}
```

length[] 배열은 HASH_SIZE만큼 선언된 것으로, key 값을 얻은 후, 처음 들어온 문자열일 때마다 숫자를 1씩 늘려서 해당 key 배열에 몇개의 데이터가 저장되어있는지 확인하는 공간이다.

<br>

**우리가 출력해야하는 조건은 처음 들어온건 "OK" 다시 또 들어온건 "data + 들어온 수"였다.**

<br>

- "OK"로 출력해야 하는 조건

  > 해당 key의 배열 length가 0일 때는 무조건 처음 들어오는 데이터다.
  >
  > 또한 1이상일 때, 그 key 배열 안에서 만약 apple을 찾지 못했다면 이 또한 처음 들어오는 데이터다.

<br>

- "data + 들어온 수"로 출력해야 하는 조건

  > 만약 1이상일 때 key 배열에서 apple 값을 찾았다면 이제 'apple+들어온 수'를 출력하도록 구현해야한다.

<br>

그래서 나는 3개의 배열을 선언해서 활용했다.

```java
static int[][] data = new int[HASH_SIZE][HASH_LEN];
static int[] length = new int[HASH_SIZE];
static String[][] s_data = new String[HASH_SIZE][HASH_LEN];
```

data[][] 배열 : input으로 받는 문자열이 들어온 수를 저장하는 곳

length[] 배열 : key 값마다 들어온 수를 저장하는 곳

s_data[][] 배열 : input으로 받은 문자열을 저장하는 곳 

<br>

진행 과정을 설명하면 아래와 같다. (apple - banana - abc - abc 순으로 입력되고, apple과 abc의 key값은 5로 같다고 가정하겠다.)

<br>

```
1. apple이 들어옴. key 값을 얻으니 5가 나옴. length[5]는 0이므로 처음 들어온 데이터임. length[5]++하고 "OK"출력

2. banana가 들어옴. key 값을 얻으니 3이 나옴. length[3]은 0이므로 처음 들어온 데이터임. length[3]++하고 "OK"출력

<< 중요 >>
3. abc가 들어옴. key 값을 얻으니 5가 나옴. length[5]는 0이 아님. 해당 key 값에 누가 들어온적이 있음. 
length[5]만큼 반복문을 돌면서 s_data[key]의 배열과 abc가 일치하는 값이 있는지 확인함. 현재 length[5]는 1이고, s_data[key][0] = "apple"이므로 일치하는 값이 없기 때문에 length[5]를 1 증가시키고 s_data[key][length[5]]에 abc를 넣고 "OK"출력

<< 중요 >>
4. abc가 들어옴. key 값을 얻으니 5가 나옴. length[5] = 2임.
s_data[key]를 2만큼 반복문을 돌면서 abc가 있는지 찾음. 1번째 인덱스 값에는 apple이 저장되어 있고 2번째 인덱스 값에서 abc가 일치함을 찾았음!!
따라서 해당 data[key][index] 값을 1 증가시키고 이 값을 return 해주면서 메소드를 끝냄
→ 메인함수에서 input으로 들어온 abc 값과 리턴값으로 나온 1을 붙여서 출력해주면 됨 (abc1)
```

<br>

진행과정을 통해 어떤 방식으로 구현되는지 충분히 이해할 수 있을 것이다.

<br>

#### 전체 소스코드

```java
package CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static final int HASH_SIZE = 1000;
	static final int HASH_LEN = 400;
	static final int HASH_VAL = 17; // 소수로 할 것
	
	static int[][] data = new int[HASH_SIZE][HASH_LEN];
	static int[] length = new int[HASH_SIZE];
	static String[][] s_data = new String[HASH_SIZE][HASH_LEN];
	static String str;
	static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 입력 수 (1~100000)
		
		for (int i = 0; i < N; i++) {
			
			str = br.readLine();
			
			int key = getHashKey(str);
			int cnt = checking(key);
			
			if(cnt != -1) { // 이미 들어왔던 문자열
				sb.append(str).append(cnt).append("\n");
			}
			else sb.append("OK").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int getHashKey(String str) {
		
		int key = 0;
		
		for (int i = 0; i < str.length(); i++) {
			key = (key * HASH_VAL) + str.charAt(i) + HASH_VAL;
		}
		
		if(key < 0) key = -key; // 만약 key 값이 음수면 양수로 바꿔주기
		
		return key % HASH_SIZE;
		
	}
	
	public static int checking(int key) {
		
		int len = length[key]; // 현재 key에 담긴 수 (같은 key 값으로 들어오는 문자열이 있을 수 있다)
		
		if(len != 0) { // 이미 들어온 적 있음
			
			for (int i = 0; i < len; i++) { // 이미 들어온 문자열이 해당 key 배열에 있는지 확인
				if(str.equals(s_data[key][i])) {
					data[key][i]++;
					return data[key][i];
				}
			}
			
		}
		
		// 들어온 적이 없었으면 해당 key배열에서 문자열을 저장하고 길이 1 늘리기
		s_data[key][length[key]++] = str;

		return -1; // 처음으로 들어가는 경우 -1 리턴
	}

}
```

