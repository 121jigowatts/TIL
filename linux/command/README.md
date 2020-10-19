# Command

## curl

ネットワークを経由したデータ転送を行う

|オプション|説明|
|-|-|
|-d|POSTパラメータの指定|
|-H|HTTPヘッダーの指定|
|-I|HTTPレスポンスヘッダーの取得|
|-v|詳細なログの出力|
|-X|HTTPメソッドの指定|

```sh
# GETメソッド
curl https://example.com/hello
# POSTメソッド
curl -X POST https://example.com/hello -H "accept: application/json" -d '{"Name":"alice", "Age":"17"}'
```

## grep

ファイル内の文字列を検索する

```sh
# grep 検索文字列 ファイル名
grep test sample.txt
# grep 検索文字列 ディレクトリ配下
grep test ./*
# grep 正規表現 対象
grep h.*p ./*
# -l でヒットしたファイル名のみ表示
grep -l h.*p ./*
# and検索
grep test ./* | grep hoge
```

## less

テキストファイルの中身を見る

|オプション|説明|
|-|-|
|-X|終了後に画面をクリアしない|
|-N|行番号を付与|

|コマンドモード|説明|
|-|-|
|g|ファイル先頭へ移動|
|G|ファイル末尾へ移動|
|? **文字列** |カーソル位置から前方へ文字列検索|
|/|カーソル位置から後方へ文字列検索|
|n|検索の繰り返し|
|N|逆方向へ検索の繰り返し|

```sh
less -N app_debug.log

# コマンドモードで文字列検索(\でエスケープ)
/ hoge
```

## ps

プロセスを表示する

|オプション|説明|
|-|-|
|a|端末操作プロセスを表示する|
|u|CPUやメモリの使用率を表示する|
|x|制御端末のないプロセスを表示する|

```sh
ps aux
```

## ssh

sshでリモートログイン

```sh
ssh user@192.168.0.2

# パスワードの入力
Password:
```

## scp

リモートとローカルでファイルをコピーする

```sh
# リモートのファイルをローカルへコピー
scp user@192.168.0.2:~/logs/debug.log ./

# ローカルのファイルをリモートへコピー
scp app.yaml user@192.168.0.2:~/app/
```

## tail

## tar

アーカイブファイルを作成・展開する

|オプション|説明|
|-|-|
|c|新しくアーカイブを作成する|
|f|アーカイブファイル名を指定する|
|x|アーカイブを展開する|
|v|アーカイブ結果を表示する|
|z|アーカイブをgzip形式で圧縮/解凍する|

```sh
# 対象ファイルをgzipで圧縮
tar cfvz /tmp/hoge.tar.gz ~/target
# tar + gzipで圧縮されたアーカイブを解凍・展開する
tar xfvz /tmp/hoge.tar.gz
```
