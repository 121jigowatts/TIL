# Git

## Gitの基本的な使い方について

### ユーザー名とEmailアドレスを設定する

```sh
git config --global user.name "hoge foo"
git config --global user.email hoge@example.com
```

### Gitの設定を表示する

```sh
git config -l
```

### 日本語ファイルが文字化けする時

```sh
git config --local core.quotepath false
```

### pullをfast-forwardのみ許可する

```sh
git config --global pull.ff only
```

### リポジトリを初期化する

```sh
git init
```

### リポジトリの状態を確認する

```sh
git status
```

```sh
# リポジトリの状態を短いフォーマットで出力 & ファイルおよびディレクトリを表示
git status -s -uall
```

### ファイルをステージ(インデックス)に追加する

```sh
git add
```

### 変更をローカルリポジトリにコミットする

```sh
# 詳細なコミットメッセージを記述する
git commit
```

エディタが立ち上がり詳細なコミットメッセージを記述することができる。
何も書かずにエディタを閉じることでコミットを中止できる。

```sh
# 1行コミットメッセージを記述する
git commit -m "my first commit"
```

-mオプションを付けることで、簡単なメッセージを記述できる。

### コミットログを表示する

```sh
git log
```

```sh
# 変更内容を表示する
git log -p
```

```sh
# コミットを1行で表示する
git log --oneline
```

```sh
# コミットの表示数を指定する
git log -3
```

```sh
# コミットメッセージを1行のみ表示する
git log --pretty=short
```

```sh
# コミットログをグラフで表示する
git log --graph
```

```sh
# 指定のディレクトリ、ファイルのログを表示する
git log README.md
```

```sh
# 特定ユーザのログのみ表示する
git log --oneline --author='user_name'
```

```sh
# コミット対象ファイルを表示する
git log --oneline --name-status -5
```

### 差分を表示する

```sh
# ステージされていない内容の差分を表示する（ステージ対象*新規作成ファイルは対象外）
git diff
# ステージ済みの内容の差分を表示する（コミット時に反映される変更差分）
git diff --cached
```

```sh
# 作業ツリーと最新コミットの差分を表示する
git diff HEAD
```

```sh
# 指定のファイルの差分を表示する
git diff README.md
```

```sh
# 差分のあるファイル名だけ表示する
git diff --name-only
```

### バージョン管理外のファイルを削除する

```sh
# 削除対象のファイルを確認する（実際に削除はされない）
git clean -n

# ディレクトリも対象とする
git clean -dn

# 削除を実行する
git clean -f

# ディレクトリも対象とする
git clean -df
```

***

### ブランチを操作する

```sh
# ブランチを一覧表示
git branch
```

```sh
# リモートブランチを含んだブランチ情報を表示
git branch -a
```

```sh
# ブランチ一覧と共にHEADのコミット情報、上流ブランチの名前を表示
git branch -vv
```

```sh
# ブランチを作成
git branch MyBranch
```

```sh
# ブランチを削除
git branch -d MyBranch
```

```sh
# ブランチを切り替える(masterブランチへ切り替える)
git checkout master
# こっちでもok
git switch master
```

```sh
# ブランチを作成し、切り替える
git checkout -b MyBranch
# こっちでもok
git switch -c MyBranch
```

### ブランチをマージする

```sh
# ブランチをmasterへ切り替える
git checkout master
# ブランチをマージする(MyBranchをmasterブランチへマージする)
git merge --no-ff MyBranch
```

```sh
# fast-forwardの場合のみマージする
git merge --ff-only develop
```

```sh
# マージで競合が発生
git merge develop
# 競合したファイルの状態を確認
# UUマークが付いているファイルが競合しているので、編集し競合を解決する
git status -s
UU hoge.txt

# 競合を解決したらgit add
git add hoge.txt
# Mマークに変更されていることを確認
git status -s
M hoge.txt

# マージコミット
git commit
```

```sh
# マージを中止したい場合
git merge --abort
```

### 複数のコミットをひとつにまとめる

```sh
# developブランチで複数回コミットする
git commit -am "commit1"
git commit -am "commit2"
git commit -am "commit3"
# masterブランチへ切り替える
git checkout master

# --squashオプションを付けてマージ
git merge --squash develop

git commit -am "squash"
```

### 他ブランチのコミットを取り込む

```sh
# 複数のコミットを指定可能
git cherry-pick コミット コミット

# チェリーピック実行中に競合が発生した場合、競合を解決して続ける
git cherry-pick --continue

# チェリーピック実行中に競合が発生した場合、チェリーピックを中止し開始前の状態に戻る
git cherry-pick --abort
```

### 作業を一時的に保存する

```sh
# 作業ツリーの変更をスタッシュに保存
git stash

# 保存したスタッシュを一覧表示
git stash list

# 保存した内容を表示
git stash show -p stash@{0}

# 保存した内容を作業ツリーに戻す
git stash pop
```

### コミットにタグを設定する

```sh
# コミットにタグを設定
git tag <tag_name>

# リモートリポジトリに反映
git push --tags
```

### リポジトリの最適化

```sh
# --autoオプションを付けるとリポジトリの状態から必要であれば実行される
git gc --auto

# オブジェクトの数が1000以上ある場合に実行するのが良い
git count-objects -v
```

***

### やり直し

```sh
# ステージ(インデックス登録)を取り消す
git reset

# 直前のコミットの一つ前の状態(HEAD^)に戻す
git reset --hard HEAD^

# コミットのやり直しをする（作業ツリーはそのまま）
git reset --soft HEAD^
```

```sh
# 作業ツリーの変更を取り消す
git restore <file>
```

```sh
# コミットログを修正する
git commit --amend
# エディタが開くので書き換えて保存する
```

### リベースする

⚠**リモートリポジトリにプッシュしたコミットはリベースしないように注意**

```sh
# featureブランチにmasterブランチの変更分を取り込む
git checkout feature
git rebase master
```

#### コミットをやり直す

HEADから3つ前のコミットを起点にコミット内容を修正する。

```sh
git rebase -i HEAD~3
```

```sh
# テキストエディタが起動するので、やり直すコミットをpickからeditに編集して保存
pick bd1d5ed 修正1つ目
edit b76c68d 修正2つ目
edit 80d9c21 修正3つ目
```

```sh
# editと編集した一つ目のコミット(b76c68d 修正2つ目)について、ファイルを修正したらステージに追加
git add hoge.md
# --amendオプションでコミット
git commit --amend
# 一つ目のコミットのやり直しをコミットしたら--continueオプションでrebase
git rebase --continue
```

```sh
# editと編集した二つ目のコミット(80d9c21 修正3つ目)について、ファイルを修正したらステージに追加
git add hoge.md
# --amendオプションでコミット
git commit --amend
# コンフリクトが発生した場合はコミットコマンドではなく、--continueオプションでrebaseとする
# テキストエディタが起動するので、コミットメッセージを編集し保存する
git rebase --continue
```

#### コミットをまとめる

HEADから3つ前のコミットを起点にコミット内容を修正する。

```sh
git rebase -i HEAD~3
```

```sh
# テキストエディタが起動するので、まとめるコミットをpickからsquashに編集して保存
pick bd1d5ed 修正1つ目
squash b76c68d 修正2つ目
squash 80d9c21 修正3つ目
```

再度テキストエディタが起動するので、コミットメッセージを修正し保存する。

#### コミットを削除する

HEADから3つ前のコミットを起点にコミット内容を修正する。

```sh
git rebase -i HEAD~3
```

```sh
# テキストエディタが起動するので、削除したいコミットをエディタ上で削除して保存
pick bd1d5ed 修正1つ目
# pick b76c68d 修正2つ目
pick 80d9c21 修正3つ目
```

### リモートリポジトリに公開済みのコミットを取り消す

```sh
git log --oneline
hash111 bad commit
hash000 good commit

# 指定のコミットを取り消すコミットを作成する
git revert --no-edit hash111

# 複数のコミットを取り消す
git revert --no-edit hash111 hash000

# revert実行時に競合が発生した場合は競合を解決しrevertを続ける
git revert --continue
```

```sh
git log --oneline
hash444 Merge branch 'feature' into 'master'
hash333 add new feature (parent number 2)
hash222 init (parent number 1)

# マージコミットからマージ元ブランチのコミットを調べる
# 左から親番号1、2となる
git show hash444
commit hash444...
Merge: hash222 hash333

# マージコミットを取り消すコミットを作成する
# -mオプションに続き親番号を指定する
git revert -m 1 hash444 --no-edit
```

***

### リモートリポジトリとのやりとり

```sh
# リモートリポジトリの登録(originという名前でgit@github.com:XXX[GitHubのパス]を指定など)
git remote add リポジトリ名 リモートリポジトリのパス
```

```sh
# リモートリポジトリの確認
git remote -v
# リモートリポジトリの再登録
git remote set-url リポジトリ名 リモートリポジトリのパス
```

```sh
# リモートリポジトリの詳しい情報を表示
git remote show origin
```

#### アップロード

```sh
# リモートリポジトリにローカルリポジトリの内容を送信(リモートリポジトリにローカルmasterブランチの内容を送信)
git push origin master
# ブランチを指定
git push origin ローカルブランチ名:リモートブランチ名

# ローカルブランチをリモートブランチにPushする
git push origin feature/hoge
```

#### クローン

```sh
# リモートリポジトリを取得
git clone リモートリポジトリのパス
```

#### ダウンロード

```sh
# 最新のリモートリポジトリのブランチを取得
git fetch origin リモートブランチ名
# ログを確認
git log FETCH_HEAD
# 差分を確認
git diff FETCH_HEAD
# 問題がなければマージ
git merge FETCH_HEAD

# リモートブランチをローカルにチェックアウトする
git checkout -b feature/hoge origin/feature/hoge
```

```sh
# 最新のリモートリポジトリのブランチを取得しマージ*mergeまで同時にしてくれるので注意
git pull origin リモートブランチ名

# 削除されたリモートブランチを同期する
git remote prune origin
```

```sh
# featureブランチにリモートのmasterブランチをプルしてくるときにリベースする
git checkout feature
git pull --rebase origin master
```
