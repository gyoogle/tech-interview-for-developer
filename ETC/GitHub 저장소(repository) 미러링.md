### GitHub 저장소(repository) 미러링

---

- ##### 미러링 : commit log를 유지하며 clone

##### <br>

1. #### 저장소 미러링

   1. 복사하고자 하는 저장소의 bare clone 생성

      ```bach
      git clone --bare {복사하고자하는저장소의 git 주소}
      ```

   2. 새로운 저장소로 mirror-push

      ```bash
      cd {복사하고자하는저장소의git 주소}
      git push --mirror {붙여놓을저장소의git주소}
      ```

   3. 1번에서 생성된 저장소 삭제

<br>

1. #### 100MB를 넘어가는 파일을 가진 저장소 미러링

   1. [git lfs](https://git-lfs.github.com/)와 [BFG Repo Cleaner](https://rtyley.github.io/bfg-repo-cleaner/) 설치

   2. 복사하고자 하는 저장소의 bare clone 생성

      ```bach
      git clone --mirror {복사하고자하는저장소의 git 주소}
      ```

   3. commit history에서 large file을 찾아 트랙킹

      ```bash
      git filter-branch --tree-filter 'git lfs track "*.{zip,jar}"' -- --all
      ```

   4. BFG를 이용하여 해당 파일들을 git lfs로 변경

      ```bash
      java -jar ~/usr/bfg-repo-cleaner/bfg-1.13.0.jar --convert-to-git-lfs '*.zip'
      java -jar ~/usr/bfg-repo-cleaner/bfg-1.13.0.jar --convert-to-git-lfs '*.jar'
      ```

   5. 새로운 저장소로 mirror-push

      ```bash
      cd {복사하고자하는저장소의git 주소}
      git push --mirror {붙여놓을저장소의git주소}
      ```

   6. 1번에서 생성된 저장소 삭제

<br>

- ref
  - [GitHub Help](https://help.github.com/articles/duplicating-a-repository/)
  - [stack overflow](https://stackoverflow.com/questions/37986291/how-to-import-git-repositories-with-large-files)

