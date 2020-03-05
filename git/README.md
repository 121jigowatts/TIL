# Git

## Gitの基本的な使い方について

### Gitの設定を表示する

```sh
git config -l
```

### 日本語ファイルが文字化けする時

```sh
git config --local core.quotepath false
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

### 差分を表示する

```sh
# ステージされていない内容の差分を表示する（ステージ対象*新規作成ファイルは対象外）
git diff
# ステージ済みの内容の差分を表示する（コミット時に反映される変更差分）
git diff --cached
```

```sh
# ワーキングツリーと最新コミットの差分を表示する
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
```

```sh
# ブランチを作成し、切り替える
git checkout -b MyBranch
```

```sh
# ブランチをmasterへ切り替える
git checkout master
# ブランチをマージする(MyBranchをmasterブランチへマージする)
git merge --no-ff MyBranch
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

# 保存した内容をワーキングツリーに戻す
git stash pop
```

### コミットにタグを設定する

```sh
# コミットにタグを設定
git tag <tag_name>

# リモートリポジトリに反映
git push --tags
```

***

### やり直し

```sh
# 直前のコミットの一つ前の状態(HEAD^)に戻す
git reset --hard HEAD^
```

```sh
# ワーキングツリーの変更を取り消す
git restore <file>
```

```sh
# コミットログを修正する
git commit --amend
```

エディタが開くので書き換えて保存する

### git rebase -i

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
