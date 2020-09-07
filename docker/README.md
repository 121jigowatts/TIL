# Docker

## Dockerイメージの操作

### イメージのダウンロード

```sh
# タグ名を省略した場合はlatestタグ
docker pull イメージ名:タグ名
```

### イメージの一覧表示

```sh
# 全てのイメージを表示
docker images -a
```

### イメージの詳細譲歩を表示

```sh
# イメージ名またはイメージIDを指定
docker inspect イメージ名
```

### イメージの削除

```sh
# 複数のイメージを削除したい場合はスペースで区切って指定
docker rmi イメージ名 [イメージ名]
```

### Dockerイメージの検索

```sh
# Docker Hubに公開されているイメージを検索
docker search [キーワード]
```

## Dockerfileからイメージを作成

```sh
# docker build -t イメージ名:タグ名 [Dockerfileの場所]
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
docker-compose exec <service> <command>

# サービス名を指定してbash起動
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
