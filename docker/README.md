# Docker

## Dockerイメージの操作

### イメージのダウンロード

タグ名を省略した場合はlatestタグ
```sh
# docker pull {イメージ名:タグ名}
docker pull nginx:latest
```

### イメージの一覧表示

全てのイメージを表示
```sh
docker images -a
```

### イメージの詳細譲歩を表示

イメージ名またはイメージIDを指定
```sh
# docker inspect {イメージ名}
docker inspect nginx
```

### イメージの削除

```sh
# 複数のイメージを削除したい場合はスペースで区切って指定
# docker rmi イメージ名 [イメージ名]
docker rmi nginx
```

### Dockerイメージの検索

Docker Hubに公開されているイメージを検索
```sh
# docker search {キーワード}
docker search openjdk
```

## Dockerコンテナの操作

### コンテナの起動

```sh
# docker run --name {コンテナ名} {イメージ名}
docker run --name my-nginx nginx
```

デタッチドモードで実行する
```sh
# docker run -d {イメージ名}
docker run -d --name my-nginx -d nginx
```

ホスト側のポートとコンテナ側のポートをマッピング
```sh
# docker run -p {ホスト側ポート}:{コンテナ側ポート} {イメージ名}
docker run -d --name my-nginx -d -p 8080:80 nginx
```

### コンテナへの接続

```sh
# docker exec -it {コンテナ名} {コマンド}
docker exec -it my-nginx /bin/bash
```

### コンテナの停止

```sh
# docker stop {コンテナ名}
docker stop my-nginx
```

### コンテナの削除

```sh
# docker rm {コンテナ名}
docker rm my-nginx
```

### ホスト上のディレクトリをコンテナにマウント

```sh
#docker run --name {コンテナ名} -v {ホスト側ディレクトリ}:{コンテナ側ディレクトリ}:{オプション}
docker run --name my-nginx -v /path/to/html:/usr/share/nginx/html:ro -d -p 8080:80 nginx
```

### ホスト・コンテナ間のファイルコピー

:todo

### データの管理

#### volume

データ領域の作成
```sh
# docker volume create {ボリューム名}
docker volume create my-vol
```

作成したデータ領域の確認
```sh
docker volume ls
```

データ領域の削除
```sh
# docker volume rm {ボリューム名}
docker volume rm my-vol
```

#### ボリュームのマウント

```sh
# docker run -itd --name {コンテナ名} --mount source={ボリューム名},target=/path/to {イメージ名}
docker run -itd --name my-nginx --mount source=my-vol,target=/app nginx
```

## Dockerfileからイメージを作成

```sh
# docker build -t イメージ名:タグ名 {Dockerfileの場所}
docker build -t hello-world:latest .
# --no-cacheでキャッシュを無効化して全ての命令を実行する
docker build --no-cache -t hello-world:latest .
```

## Docker Composeによる複数コンテナの管理

### 複数コンテナの生成 / 起動

```sh
# -dオプションを付けることでバックグラウンドで実行する
docker-compose up -d
```

### 複数コンテナの一覧表示

```sh
docker-compose ps
```

### 複数コンテナのログ確認

```sh
docker-compose logs
```

### コマンド実行

```sh
# サービス名を指定してbash起動
# docker-compose exec <service> <command>
docker-compose exec db /bin/bash
```

### 複数コンテナの停止

```sh
docker-compose stop
```

### 複数コンテナの停止 / 削除

```sh
docker-compose down
```
