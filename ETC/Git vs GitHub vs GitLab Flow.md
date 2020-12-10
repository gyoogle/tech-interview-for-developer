# Git vs GitHub vs GitLab Flow

<br>

```
git-flow의 종류는 크게 3가지로 분리된다.
어떤 차이점이 있는지 간단히 알아보자
```

<br>

## 1. Git Flow

가장 최초로 제안된 Workflow 방식이며, 대규모 프로젝트 관리에 적합한 방식으로 평가받는다.

기본 브랜치는 5가지다.

- feature → develop → release → hotfix → master

<br>

<img src="http://nvie.com/img/git-model@2x.png" width="500">

<br>

### Master

> 릴리즈 시 사용하는 최종 단계 메인 브랜치

Tag를 통해 버전 관리를 한다.

<br>

### Develop

> 다음 릴리즈 버전 개발을 진행하는 브랜치

추가 기능 구현이 필요해지면, 해당 브랜치에서 다시 브랜치(Feature)를 내어 개발을 진행하고, 완료된 기능은 다시 Develop 브랜치로 Merge한다.

<br>

### Feature

> Develop 브랜치에서 기능 구현을 할 때 만드는 브랜치

한 기능 단위마다 Feature 브랜치를 생성하는게 원칙이다.

<br>

### Release

> Develop에서 파생된 브랜치

Master 브랜치로 현재 코드가 Merge 될 수 있는지 테스트하고, 이 과정에서 발생한 버그를 고치는 공간이다. 확인 결과 이상이 없다면, 해당 브랜치는 Master와 Merge한다.

<br>

### Hotfix

> Mater브랜치의 버그를 수정하는 브랜치

검수를 해도 릴리즈된 Master 브랜치에서 버그가 발견되는 경우가 존재한다. 이때 Hotfix 브랜치를 내어 버그 수정을 진행한다. 디버그가 완료되면 Master, Develop 브랜치에 Merge해주고 브랜치를 닫는다.

<br>

 `git-flow`에서 가장 중심이 되는 브랜치는 `master`와 `develop`이다. (무조건 필요)

> 이름을 변경할 수는 있지만, 통상적으로 사용하는 이름이므로 그대로 사용하도록 하자

진행 과정 중에 Merge된 `feature`, `release`, `hotfix` 브랜치는 닫아서 삭제하도록 한다.

이처럼 계획적인 릴리즈를 가지고 스케줄이 짜여진 대규모 프로젝트에는 git-flow가 적합하다. 하지만 대부분 일반적인 프로젝트에서는 불필요한 절차들이 많아 생산성을 떨어뜨린다는 의견도 많은 방식이다.

<br>

## 2. GitHub Flow

> git-flow를 개선하기 위해 나온 하나의 방식

흐름이 단순한 만큼, 역할도 단순하다. git flow의 `hotfix`나 `feature` 브랜치를 구분하지 않고, pull request를 권장한다.

<br>

<img src="https://miro.medium.com/max/1166/0*6pT5H4vnujVLcy0S.png" width="500">

<br>

Master 브랜치가 릴리즈에 있어 절대적 역할을 한다. 

Master 브랜치는 항상 최신으로 유지하며, Stable한 상태로 product에 배포되는 브랜치다.

따라서 Merge 전에 충분한 테스트 과정을 거쳐야 한다. (브랜치를 push하고 Jenkins로 테스트)

<br>

새로운 브랜치는 항상 `Master` 브랜치에서 만들며, 새로운 기능 추가나 버그 해결을 위한 브랜치는 해당 역할에 대한 이름을 명확하게 지어주고, 커밋 메시지 또한 알기 쉽도록 작성해야 한다.

그리고 Merge 전에는 `pull request`를 통해 공유하여 코드 리뷰를 진행한다. 이를 통해 피드백을 받고, Merge 준비가 완료되면 Master 브랜치로 요청하게 된다.

> 이 Merge는 바로 product에 반영되므로 충분한 논의가 필요하며 **CI**도 필수적이다.

Merge가 완료되면, push를 진행하고 자동으로 배포가 완료된다. (GitHub-flow의 핵심적인 부분)

<br>

#### CI (Continuous Integration)

- 형상관리 항목에 대한 선정과 형상관리 구성 방식 결정

- 빌드/배포 자동화 방식

- 단위테스트/통합테스트 방식

> 이 세가지를 모두 고려한 자동화된 프로세스를 구성하는 것

<br>

<br>

## 3. GitLab Flow

> github flow의 간단한 배포 이슈를 보완하기 위해 관련 내용을 추가로 덧붙인 flow 방식

<br>

<img src="https://about.gitlab.com/images/git_flow/environment_branches.png" width="400">

<br>

Production 브랜치가 존재하여 커밋 내용을 일방적으로 Deploy 하는 형태를 갖추고 있다.

Master 브랜치와 Production 브랜치 사이에 `pre-production` 브랜치를 두어 개발 내용을 바로 반영하지 않고, 시간을 두고 반영한다. 이를 통한 이점은, Production 브랜치에서 릴리즈된 코드가 항상 프로젝트의 최신 버전 상태를 유지할 필요가 없는 것이다.

즉, github-flow의 단점인 안정성과 배포 시기 조절에 대한 부분을 production이라는 추가 브랜치를 두어 보강하는 전력이라고 볼 수 있다.

<br>

<br>

## 정리

3가지 방법 중 무엇이 가장 나은 방식이라고 선택할 수 없다. 프로젝트, 개발자, 릴리즈 계획 등 상황에 따라 적합한 방법을 택해야 한다.

배달의 민족인 '우아한 형제들'이 github-flow에서 git-flow로 워크플로우를 변경한 것 처럼 ([해당 기사 링크](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)) 브랜칭과 배포에 대한 전략 상황에 따라 변경이 가능한 부분이다.

따라서 각자 팀의 상황에 맞게 적절한 워크플로우를 선택하여 생산성을 높이는 것이 중요할 것이다.

<br>

<br>

#### [참고 자료]

- [링크](https://ujuc.github.io/2015/12/16/git-flow-github-flow-gitlab-flow/)
- [링크](https://medium.com/extales/git을-다루는-workflow-gitflow-github-flow-gitlab-flow-849d4e4104d9)
- [링크](https://allroundplaying.tistory.com/49)

<br>

<br>
