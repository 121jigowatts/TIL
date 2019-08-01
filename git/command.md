## Gitの基本的な使い方について

### Gitの設定を表示する
```
$ git config -l
```

### リポジトリを初期化する
```
$ git init
```

### リポジトリの状態を確認する
```
$ git status
```
```
# リポジトリの状態を短いフォーマットで出力 & ファイルおよびディレクトリを表示
$ git status -s -uall
```

### ファイルをステージ(インデックス)に追加する
```
$ git add
```

### 変更をローカルリポジトリにコミットする
```
# 詳細なコミットメッセージを記述する
$ git commit
```
エディタが立ち上がり詳細なコミットメッセージを記述することができる。
何も書かずにエディタを閉じることでコミットを中止できる。

```
# 1行コミットメッセージを記述する
$ git commit -m "my first commit"
```
-mオプションを付けることで、簡単なメッセージを記述できる。

### コミットログを表示する
```
$ git log
```

```
# コミットメッセージを1行のみ表示する
$ git log --pretty=short
```

```
# コミットログをグラフで表示する
$ git log --graph
```

```
# 指定のディレクトリ、ファイルのログを表示する
$ git log README.md
```

### 差分を表示する

```
# ワーキングツリーとステージの差分を表示する
$ git diff
```

```
# ワーキングツリーと最新コミットの差分を表示する
$ git diff HEAD
```

```
# 指定のファイルの差分を表示する
$ git diff README.md
```

### バージョン管理外のファイルを削除する

```
# 削除対象のファイルを確認する（実際に削除はされない）
$ git clean -n

# 削除を実行する
$ git clean -f
```

***

### ブランチを操作する
```
# ブランチを一覧表示
$ git branch
```
```
# リモートブランチを含んだブランチ情報を表示
$ git branch -a
```
```
# ブランチ一覧と共にHEADのコミット情報、上流ブランチの名前を表示
$ git branch -vv
```

```
# ブランチを作成
$ git branch MyBranch
```

```
# ブランチを削除
$ git branch -d MyBranch
```

```
# ブランチを切り替える(masterブランチへ切り替える)
$ git checkout master
```

```
# ブランチを作成し、切り替える
$ git checkout -b MyBranch
```

```
# ブランチをmasterへ切り替える
$ git checkout master
# ブランチをマージする(MyBranchをmasterブランチへマージする)
$ git merge --no-ff MyBranch
```
### コミットにタグを設定する
```
# コミットにタグを設定
$ git tag <tag_name>

# リモートリポジトリに反映
$ git push --tags
```

***

### git reset

### やり直し
commitする前の状態でやり直したい場合
```
$ git checkout -- <file>
```

```
# コミットログを修正する
$ git commit --amend
```
エディタが開くので書き換えて保存する

### git rebase -i

***

### リモートリポジトリとのやりとり

```
# リモートリポジトリの登録(originという名前でgit@github.com:XXX[GitHubのパス]を指定など)
$ git remote add リポジトリ名 リモートリポジトリのパス
```

```
# リモートリポジトリの確認
$ git remote -v
# リモートリポジトリの再登録
$ git remote set-url リポジトリ名 リモートリポジトリのパス
```

#### アップロード
```
# リモートリポジトリにローカルリポジトリの内容を送信(リモートリポジトリにローカルmasterブランチの内容を送信)
$ git push origin master
# ブランチを指定
$ git push origin ローカルブランチ名:リモートブランチ名

# ローカルブランチをリモートブランチにPushする
$ git push origin feature/hoge
```

#### クローン
```
# リモートリポジトリを取得
$ git clone リモートリポジトリのパス
```

#### ダウンロード
```
# 最新のリモートリポジトリのブランチを取得
$ git fetch origin リモートブランチ名
# ログを確認
$ git log FETCH_HEAD
# 差分を確認
$ git diff FETCH_HEAD
# 問題がなければマージ
$ git merge FETCH_HEAD

# リモートブランチをローカルにチェックアウトする
$ git checkout -b feature/hoge origin/feature/hoge
```

```
# 最新のリモートリポジトリのブランチを取得しマージ*mergeまで同時にしてくれるので注意
$ git pull origin リモートブランチ名

# 削除されたリモートブランチを同期する
$ git remote prune origin
```
