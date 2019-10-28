## DBSCAN 클러스터링 알고리즘

> 여러 클러스터링 알고리즘 中 '밀도 방식'을 사용

K-Means나 Hierarchical 클러스터링처럼 군집간의 거리를 이용해 클러스터링하는 방법이 아닌, 점이 몰려있는 **밀도가 높은 부분으로 클러스터링 하는 방식**이다.

`반경과 점의 수`로 군집을 만든다.

<br>

<img src="https://3.bp.blogspot.com/-rDYuyg00Z0w/WXA-OQpkAfI/AAAAAAAAI_I/QshfNVNHD_wXJwXEipRIVzDSX5iOEAy2wCEwYBhgL/s320/DBSCAN_Points.PNG">

<br>

반경 Epsilon과 최소 점의 수인 minpts를 정한다.

하나의 점에서 Epsilon 안에 존재하는 점의 수를 센다. 이때, 반경 안에 속한 점이 minpts로 정한 수 이상이면 해당 점은 'core point'라고 부른다.

<img src="https://t1.daumcdn.net/cfile/tistory/9930A63359E057BA1A" height=200>

> 현재 점 P에서 4개 이상의 점이 속했기 때문에, P는 core point다.

<br>

Core point에 속한 점들부터 또 Epsilon을 확인하여 체크한다. (DFS 활용)

이때 4개 미만의 점이 속하게 되면, 해당 점은 'border point'라고 부른다.

<img src="https://t1.daumcdn.net/cfile/tistory/996B8A3359E057BA27" height=200>

> P2는 Epsilon 안에 3개의 점만 존재하므로 minpts = 4 미만이기 때문에 border point이다.

보통 이와 같은 border point는 군집화를 마쳤을 때 클러스터의 외곽에 해당한다. (해당 점에서는 확장되지 않게되기 때문)

<br>

마지막으로, 하나의 점에서 Epslion을 확인했을 때 어느 집군에도 속하지 않는 점들이 있을 것이다. 이러한 점들을 outlier라고 하고, 'noise point'에 해당한다.

<img src="https://t1.daumcdn.net/cfile/tistory/99D7893359E057B938" height=200>

> P4는 반경 안에 속하는 점이 아무도 없으므로 noise point다.

DBSCAN 알고리즘은 이와 같이 군집에 포함되지 않는 아웃라이어 검출에 효율적이다.

<br>

<br>

전체적으로 DBSCAN 알고리즘을 적용한 점들은 아래와 같이 구성된다.

<img src="https://t1.daumcdn.net/cfile/tistory/99CC563359E057BA25" height=200>

<br>

##### 정리

초반에 지정한 Epsilon 반경 안에 minpts 이상의 점으로 구성된다면, 해당 점을 중심으로 군집이 형성되고, core point로 지정한다. core point가 서로 다른 core point 군집의 일부가 되면 서로 연결되어 하나의 군집이 형성된다.

이때 군집에는 속해있지만 core point가 아닌 점들을 border point라고 하며, 아무곳에도 속하지 않는 점은 noise point가 된다.

<br>

<br>

#### DBSCAN 장점

- 클러스터의 수를 미리 정하지 않아도 된다.

  > K-Means 알고리즘처럼 미리 점을 지정해놓고 군집화를 하지 않아도 된다.

- 다양한 모양과 크기의 클러스터를 얻는 것이 가능하다.

- 모양이 기하학적인 분포라도, 밀도 여부에 따라 군집도를 찾을 수 있다.

- 아웃라이어 검출을 통해 필요하지 않은 noise 데이터를 검출하는 것이 가능하다.

<br>

#### DBSCAN 단점

- Epslion에 너무 민감하다.

  > 반경으로 설정한 값에 상당히 민감하게 작용된다. 따라서 DBSCAN 알고리즘을 사용하려면 적절한 Epsilon 값을 설정하는 것이 중요하다.

<br>

<br>

##### [참고 자료]

[링크](<https://bcho.tistory.com/1205?category=555440>)

[링크](<https://practice2code.blogspot.com/2017/07/dbscan-clustering-algorithm.html>)