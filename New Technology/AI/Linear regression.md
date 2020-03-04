### [딥러닝] Tensorflow로 간단한 Linear regression 알고리즘 구현

<br>

시험 점수를 예상해야 할 때 (0~100) > regression을 사용

regression을 사용하는 예제를 살펴보자

<br>

<br>

여러 x와 y 값을 가지고 그래프를 그리며 가장 근접하는 선형(Linear)을 찾아야 한다.

이 선형을 통해서 앞으로 사용자가 입력하는 x 값에 해당하는 가장 근접한 y 값을 출력해낼 수 있는 것이다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile21.uf.tistory.com%2Fimage%2F99A1B3365AF1362C106BFF">

<br>

현재 파란 선이 가설 H(x)에 해당한다.

실제 입력 값들 (1,1) (2,2) (3,3)과 선의 거리를 비교해서 근접할수록 좋은 가설을 했다고 말할 수 있다.

<br>

<br>

이를 찾기 위해서 Hypothesis(가설)을 세워 cost(비용)을 구해 W와 b의 값을 도출해야 한다.

<br>

#### **Linear regression 알고리즘의 최종 목적 : cost 값을 최소화하는 W와 b를 찾자**

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile25.uf.tistory.com%2Fimage%2F99FEFF355AF13568288AE8">

- H(x) : 가설

- cost(W,b) : 비용

- W : weight

- b : bias

- m : 데이터 개수

- H(x^(i)) : 예측 값

- y^(i) : 실제 값

<br>

**(예측값 - 실제값)의 제곱을 하는 이유는?**

> 양수가 나올 수도 있고, 음수가 나올 수도 있다. 또한 제곱을 하면, 거리가 더 먼 결과일 수록 값은 더욱 커지게 되어 패널티를 더 줄 수 있는 장점이 있다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile28.uf.tistory.com%2Fimage%2F99400A405AF13743173F87">

이제 실제로, 파이썬을 이용해서 Linear regression을 구현해보자

<br>

<br>

#### **미리 x와 y 값을 주었을 때**

```python
import tensorflow as tf
 
# X and Y data
x_train = [1, 2, 3]
y_train = [1, 2, 3]
 
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')
 
# Our hypothesis XW+b
hypothesis = x_train * W + b // 가설 정의
 
# cost/loss function
cost = tf.reduce_mean(tf.square(hypothesis - y_train))
 
#Minimize
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
train = optimizer.minimize(cost)
 
# Launch the graph in a session.
sess = tf.Session()
 
# Initializes global variables in the graph.
sess.run(tf.global_variables_initializer())
 
# Fit the line
for step in range(2001):
    sess.run(train)
    if step % 20 == 0:
        print(step, sess.run(cost), sess.run(W), sess.run(b))
```

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F9963B34B5AF131E022AF07">

```
x_train = [1, 2, 3]
y_train = [1, 2, 3]
```

<br>

2000번 돌린 결과, [W = 1, b = 0]으로 수렴해가고 있는 것을 알 수 있다.

따라서, `H(x) = (1)x + 0`로 표현이 가능하다.

<br>

<br>

```
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
```

<br>

**최소화 과정에서 나오는 learning_rate는 무엇인가?**

GradientDescent는 Cost function이 최소값이 되는 최적의 해를 찾는 과정을 나타낸다.

이때 다음 point를 어느 정도로 옮길 지 결정하는 것을 learning_rate라고 한다.

<br>

**learning rate를 너무 크게 잡으면?**

- 최적의 값으로 수렴하지 않고 발산해버리는 경우가 발생(Overshooting)

<br>

**learning rate를 너무 작게 잡으면?**

- 수렴하는 속도가 너무 느리고, local minimum에 빠질 확률 증가

<br>

> 보통 learning_rate는 0.01에서 0.5를 사용하는 것 같아보인다.

<br>

<br>

#### placeholder를 이용해서 실행되는 값을 나중에 던져줄 때

```python
import tensorflow as tf
 
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')
 
X = tf.placeholder(tf.float32, shape=[None])
Y = tf.placeholder(tf.float32, shape=[None])
 
# Our hypothesis XW+b
hypothesis = X * W + b
# cost/loss function
cost = tf.reduce_mean(tf.square(hypothesis - Y))
#Minimize
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
train = optimizer.minimize(cost)
 
# Launch the graph in a session.
sess = tf.Session()
# Initializes global variables in the graph.
sess.run(tf.global_variables_initializer())
 
# Fit the line
for step in range(2001):
    cost_val, W_val, b_val, _ = sess.run([cost, W, b, train],
                                         feed_dict = {X: [1, 2, 3, 4, 5],
                                                      Y: [2.1, 3.1, 4.1, 5.1, 6.1]})
    if step % 20 == 0:
        print(step, cost_val, W_val, b_val)
```

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F9966EB3E5AF134071A0326">

```
feed_dict = {X: [1, 2, 3, 4, 5],
            Y: [2.1, 3.1, 4.1, 5.1, 6.1]})
```

2000번 돌린 결과, [W = 1, b = 1.1]로 수렴해가고 있는 것을 알 수 있다.

즉, `H(x) = (1)x + 1.1`로 표현이 가능하다.

<br>

<br>

이 구현된 모델을 통해 x값을 입력해서 도출되는 y값을 아래와 같이 알아볼 수 있다.

 <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile1.uf.tistory.com%2Fimage%2F99E0674F5AF138C21C1D8B">