### GitHub Fork로 협업하기 

---

1. Fork한 자신의 원격 저장소 확인 (최초에는 존재하지 않음)

   ```bash
   git remote -v
   ```

2. Fork한 자신의 로컬 저장소에 Fork한 원격 저장소 등록

   ```bash
   git remote add upstream {원격저장소의 Git 주소}
   ```

3. 등록된 원격 저장소 확인

   ```bash
   git remote -v
   ```

4. 원격 저장소의 최신 내용을 Fork한 자신의 저장소에 업데이트 

   ```bash
   git fetch upstream
   git checkout master
   git merge upstream/master
   ```

   - pull : fetch + merge

<br>

- [ref] 
  - https://help.github.com/articles/configuring-a-remote-for-a-fork/
  - https://help.github.com/articles/syncing-a-fork/

