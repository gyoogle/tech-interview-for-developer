### 가상 함수(virtual function)

---

> C++에서 자식 클래스에서 재정의(오버라이딩)할 것으로 기대하는 멤버 함수를 의미함
>
> 멤버 함수 앞에 `virtual` 키워드를 사용하여 선언함 → 실행시간에 함수의 다형성을 구현할 때 사용

<br>

##### 선언 규칙

- 클래스의 public 영역에 선언해야 한다.
- 가상 함수는 static일 수 없다.
- 실행시간 다형성을 얻기 위해, 기본 클래스의 포인터 또는 참조를 통해 접근해야 한다.
- 가상 함수는 반환형과 매개변수가 자식 클래스에서도 일치해야 한다.

```c++
class parent {
public :
    virtual void v_print() {
        cout << "parent" << "\n";
    }
    void print() {
        cout << "parent" << "\n";
    }
};
 
class child : public parent {
public :
    void v_print() {
        cout << "child" << "\n";
    }
    void print() {
        cout << "child" << "\n";
    }
};
 
int main() {
    parent* p;
    child c;
    p = &c;
 
    p->v_print();
    p->print();
 
    return 0;
}
// 출력 결과
// child
// parent
```

parent 클래스를 가리키는 포인터 p를 선언하고 child 클래스의 객체 c를 선언한 상태

포인터 p가 c 객체를 가리키고 있음 (몸체는 parent 클래스지만, 현재 실제 객체는 child 클래스)

포인터 p를 활용해 `virtual`을 활용한 가상 함수인 `v_print()`와 오버라이딩된 함수 `print()`의 출력은 다르게 나오는 것을 확인할 수 있다.

> 가상 함수는 실행시간에 값이 결정됨 (후기 바인딩)

print()는 컴파일 시간에 이미 결정되어 parent가 호출되는 것으로 결정이 끝남