# 파이썬 매크로

<br>

### 설치

```
pip install pyautogui

import pyautogui as pag
```

<br>

### 마우스 명령

마우스 커서 위치 좌표 추출

```python
x, y = pag.position()
print(x, y)

pos = pag.position()
print(pos) # Point(x=?, y=?)
```

<br>

마우스 위치 이동 (좌측 상단 0,0 기준)

```
pag.moveTo(0,0)
```

현재 마우스 커서 위치 기준 이동

```python
pag.moveRel(1,0) # x방향으로 1픽셀만큼 움직임
```

<br>

마우스 클릭

```python
pag.click((100,100))
pag.click(x=100,y=100) # (100,100) 클릭

pag.rightClick() # 우클릭
pag.doubleClick() # 더블클릭
```

<br>

마우스 드래그

```python
pag.dragTo(x=100, y=100, duration=2) 
# 현재 커서 위치에서 좌표(100,100)까지 2초간 드래그하겠다
```

> duration 값이 없으면 드래그가 잘 안되는 경우도 있으므로 설정하기

<br>

### 키보드 명령

글자 타이핑

```python
pag.typewrite("ABC", interval=1)
# interval은 천천히 글자를 입력할때 사용하기
```

<br>

글자 아닌 다른 키보드 누르기

```python
pag.press('enter') # 엔터키
```

> press 키 네임 모음 : [링크](https://pyautogui.readthedocs.io/en/latest/keyboard.html)

<br>

보조키 누른 상태 유지 & 떼기

```python
pag.keyDown('shift') # shift 누른 상태 유지
pag.keyUp('shift') # 누르고 있는 shift 떼기
```

<br>

많이 쓰는 명령어 함수 사용

```python
pag.hotkey('ctrl', 'c') # ctrl+c
```

<br>

<br>

#### [참고 자료]

- [링크](https://m.blog.naver.com/jsk6824/221765884364)