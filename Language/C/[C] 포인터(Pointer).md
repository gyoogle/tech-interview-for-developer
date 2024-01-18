## [C] 포인터(Pointer)

<br>

***포인터*** : 특정 변수를 가리키는 역할을 하는 변수

<br>

main에서 한번 만들어둔 변수 값을 다른 함수에서 그대로 사용하거나, 변경하고 싶은 경우가 있다.

같은 지역에 있는 변수라면 사용 및 변경이 간단하지만, 다른 지역인 경우에는 해당 값을 임시 변수로 받아 반환하는 식으로 처리한다.

이때 효율적으로 처리할 수 있도록 **포인터**를 사용하는 것!

포인터는 **메모리를 할당받고 해당 공간을 기억하는 것이 가능**하다.

<br>

아래와 같은 코드가 있을 때를 확인해보자

```c
#include<stdio.h>

int ReturnPlusOne(int n) {
    printf("%d\n", n+1);
	return n + 1;
}

int main(void) {

	int number = 3;
	printf("%d\n", number);

	number = 5;
	printf("%d\n", number);

	ReturnPlusOne(number);
	printf("%d\n", number);

	return 0;
}
```

```
[출력 결과]
3
5
6
5
```

main의 number와 function의 n은 다른 변수다.

이제 포인터로 문제를 접근해보면?

```c
#include<stdio.h>

int ReturnPlusOne(int *n) {
	*n += 1;
}

int main(void) {

	int number = 3;
	printf("%d\n", number);

	number = 5;
	printf("%d\n", number);

	ReturnPlusOne(&number);
	printf("%d\n", number);

	return 0;
}
```

```
[출력 결과]
3
5
6
```

포인터를 활용해서 우리가 기존에 원했던 결과를 가져올 수 있는 것을 확인할 수 있다.

<br>

`int* p;` : int형 포인터로 p라는 이름의 변수를 선언

`p = &num;` : p의 값에 num 변수의 주소값 대입

`printf("%d", *p);` : p에 *를 붙이면 p에 가리키는 주소에 있는 값을 나타냄

`printf("%d", p);` : p가 가리키고 있는 주소를 나타냄

<br>

```c
#include<stdio.h>

int main(void) {
	
    int number = 5;
    int* p;
    p = &number;
    
    printf("%d\n", number);
    printf("%d\n", *p);
    printf("%d\n", p);
    printf("%d\n", &number);

	return 0;
}
```

```
[출력 결과]
5
5
주소값
주소값
```

**가리키는 주소** - **가리키는 주소에 있는 값의 차이**다.

<br>

<br>

#### 이중 포인터

포인터의 포인터, 즉 포인터의 메모리 주소를 저장하는 것을 말한다.

```c
#include <stdio.h>

int main()
{
    int *numPtr1;     // 단일 포인터 선언
    int **numPtr2;    // 이중 포인터 선언
    int num1 = 10;

    numPtr1 = &num1;    // num1의 메모리 주소 저장 

    numPtr2 = &numPtr1; // numPtr1의 메모리 주소 저장

    printf("%d\n", **numPtr2);    // 20: 포인터를 두 번 역참조하여 num1의 메모리 주소에 접근

    return 0;
}
```

```
[출력 결과]
10
```

포인터의 메모리 주소를 저장할 때는, 이중 포인터를 활용해야 한다.

실제 값을 가져오기 위해 `**numPtr2`처럼 역참조 과정을 두번하여 가져올 수 있다.

<img src="https://dojang.io/pluginfile.php/342/mod_page/content/18/unit34-25.png">

<br>

<br>

##### [참고사항]

[링크](<https://prosto.tistory.com/253>)

[링크](<https://dojang.io/mod/page/view.php?id=279>)