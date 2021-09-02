# git 명령어



# 목차

1. git init
2. git add
3. git status
4. git config
5. git commit
6. git log



## git init

 * 현재 working directory에 git 생성
 * `git init` 으로 사용



## git add

* commit을 하기 위해 working directory에 있는 자료를 staging Area에 저장
* `git add <file>` 형식으로 사용
* `git add .`을 통해 수정되거나 아직 올라가지 않은 모든 파일을 staging area에 저장



## git status

* 현재 staging area에 저장된 내용과 working directory에 있는 수정된(혹은 새로 생성된) 파일을 확인
* `git status` 로 사용



## git config

* user email/github_id 등록
* commit 하기 전에 필수로 등록해야함
* `git config --global user.email <xxx@xxx.net>`  형식으로 email 등록
* `git config --global user.name <github_id>` 형식으로 id 등록



## git commit

* staging area에 저장된 내용을 repository에 저장
* `git commit -m <commit_message>` 형식으로 사용
* 저장 후 status는 빈 상태



## git log

* 현재까지 commit history 확인

* `commit 1234xxx...` 에서 앞에 4자리만으로 구별 가능

  

## git diff

* commit간 변경사항 확인(수정, 증가 ,삭제)
* `git log`를 통해 확인한 commit 주소를 사용해서 확인 가능
* `git diff xxxx xxxx` 형식으로 사용 가능



## git remote

* remo_repository 관리 가능
* `git remote add origin <remote_repo>`  형식으로 사용



## git push

* commit을 remo_repository로 전송
* `git push -u origin master` 형식으로 사용



## git clone

* remo_repository를 local로 복사
* `git clone <remote_repo>` 형식으로 사용