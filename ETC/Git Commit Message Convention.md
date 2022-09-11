# Git Commit Message Convention

<br>

Git은 컴퓨터 파일의 변경사항을 추적하고 여러 명의 사용자들 간에 해당 파일들의 작업을 조율하기 위한 분산 버전 관리 시스템이다. 따라서, 커밋 메시지를 작성할 때 사용자 간 원활한 소통을 위해 일관된 형식을 사용하면 많은 도움이 된다.

기업마다 다양한 컨벤션이 존재하므로, 소속된 곳의 규칙에 따르면 되며 아래 예시는 'Udacity'의 커밋 메시지 스타일로 작성되었다.

<br>

### 커밋 메시지 형식

```bash
type: Subject

body

footer
```

기본적으로 3가지 영역(제목, 본문, 꼬리말)으로 나누어졌다.

메시지 type은 아래와 같이 분류된다. 아래와 같이 소문자로 작성한다.

- `feat` : 새로운 기능 추가
- `fix` : 버그 수정
- `docs` : 문서 내용 변경
- `style` : 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 등
- `refactor` : 코드 리팩토링
- `test` : 테스트 코드 작성
- `chore` : 빌드 수정, 패키지 매니저 설정, 운영 코드 변경이 없는 경우 등

<br>

#### Subject (제목)

`Subject(제목)`은  최대 50글자가 넘지 않고, 마침표와 특수기호는 사용하지 않는다.

영문 표기 시, 첫글자는 대문자로 표기하며 과거시제를 사용하지 않는다. 그리고 간결하고 요점만 서술해야 한다.

> Added (X) → Add (O)

<br>

#### Body (본문)

`Body (본문)`은 최대한 상세히 적고, `무엇`을 `왜` 진행했는 지 설명해야 한다. 만약 한 줄이 72자가 넘어가면 다음 문단으로 나눠 작성하도록 한다.

<br>

#### Footer (꼬리말)

`Footer (꼬리말)`은 이슈 트래커의 ID를 작성한다.

어떤 이슈와 관련된 커밋인지(Resolves), 그 외 참고할 사항이 있는지(See also)로 작성하면 좋다.

<br>

### 커밋 메시지 예시

위 내용을 작성한 커밋 메시지 예시다.

```markdown
feat: Summarize changes in around 50 characters or less

More detailed explanatory text, if necessary. Wrap it to about 72
characters or so. In some contexts, the first line is treated as the
subject of the commit and the rest of the text as the body. The
blank line separating the summary from the body is critical (unless
you omit the body entirely); various tools like `log`, `shortlog`
and `rebase` can get confused if you run the two together.

Explain the problem that this commit is solving. Focus on why you
are making this change as opposed to how (the code explains that).
Are there side effects or other unintuitive consequences of this
change? Here's the place to explain them.

Further paragraphs come after blank lines.

 - Bullet points are okay, too

 - Typically a hyphen or asterisk is used for the bullet, preceded
   by a single space, with blank lines in between, but conventions
   vary here

If you use an issue tracker, put references to them at the bottom,
like this:

Resolves: #123
See also: #456, #789
```

<br>

<br>

#### [참고 자료]

- [링크](https://udacity.github.io/git-styleguide/)