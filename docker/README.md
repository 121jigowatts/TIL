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

未使用のイメージを削除

```sh
docker image prune
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
docker run --name my-nginx -d nginx
```

ホスト側のポートとコンテナ側のポートをマッピング

```sh
# docker run -p {ホスト側ポート}:{コンテナ側ポート} {イメージ名}
docker run --name my-nginx -d -p 8080:80 nginx
```

コンテナを停止した時点でコンテナの削除を行う

```sh
# docker run --rm {イメージ名}
docker run --name tmp-nginx --rm -d nginx
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
# docker run --name {コンテナ名} -v {ホスト側ディレクトリ}:{コンテナ側ディレクトリ}:{オプション}
docker run --name my-nginx -v /path/to/html:/usr/share/nginx/html:ro -d -p 8080:80 nginx
```

### ホスト・コンテナ間のファイルコピー

ホスト側のファイルをコンテナ側にコピー

```sh
# docker cp {ホスト側のファイルパス} {コンテナ名}:{コンテナ側のパス}
docker cp ./default.conf tmp-nginx:/etc/nginx/conf.d
```

コンテナ側のファイルをホスト側にコピー

```sh
# docker cp {コンテナ名}:{コンテナ側のファイルパス} {ホスト側のパス}
docker cp tmp-nginx:/etc/nginx/conf.d/default.conf ./
```

## データの管理

### データ領域の作成

```sh
# docker volume create {ボリューム名}
docker volume create my-vol
```

### 作成したデータ領域の確認

```sh
docker volume ls
```

### データ領域の削除

```sh
# docker volume rm {ボリューム名}
docker volume rm my-vol
```

### ボリュームのマウント

```sh
# docker run -itd --name {コンテナ名} --mount source={ボリューム名},target=/path/to {イメージ名}
docker run -itd --name my-nginx --mount source=my-vol,target=/app nginx
```

## Dockerネットワーク

### ネットワーク一覧表示

```sh
docker network ls
```

### ネットワークの情報について確認

```sh
docker network inspect bridge
```

デフォルトのネットワークではIPアドレスで通信することができるが、コンテナ名では通信することができないため、ユーザ定義のブリッジネットワークを作成する。

### ネットワークの作成

```sh
# docker network create {ネットワーク名}
docker network create my_network
```

### ネットワークにコンテナを接続

```sh
docker run -itd --name alpine_1 alpine
# docker network connect {ネットワーク名} {コンテナ名}
docker network connect my_network alpine_1
# --networkで接続するネットワークを指定
docker run -itd --name alpine_2 --network my_network alpine

docker attach alpine_1
# ユーザ定義のネットワークではコンテナ名で通信することが可能
ping -w 3 alpine_2
```

### コンテナからネットワークを切り離し

```sh
# docker network disconnect {ネットワーク名} {コンテナ名}
docker network disconnect my_network alpine_3
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

### 複数コンテナのイメージ再作成

```sh
docker-compose build --no-cache
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

## Docker MachineによるDocker実行環境

### Dockerホストの一覧表示

```sh
docker-machine ls
```

### Dockerホストの作成

```sh
# docker-machine create {Dockerホスト}
docker-machine create test-host
```

### 操作対象のDockerホスト指定

```sh
# docker-machine env {Dockerホスト}
docker-machine env test-host
# Docker for mac
eval $(docker-machine env test-host)
```

```cmd
docker-machine env test-host
REM Docker Toolbox(Windows)
eval $("C:\Program Files\Docker Toolbox\docker-machine.exe" env test-host)
```

### Dockerホストに接続

```sh
# docker-machine ssh {Dockerホスト}
docker-machine ssh test-host
```

### DockerホストのIP

```sh
# docker-machine ip {Dockerホスト}
docker-machine ip test-host
```

### Dockerホストの起動・停止

```sh
# docker-machine start {Dockerホスト}
docker-machine start test-host
# docker-machine stop {Dockerホスト}
docker-machine stop test-host
```
