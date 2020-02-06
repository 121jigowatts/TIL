# Docker

## Dockerイメージの操作

### イメージのダウンロード

```sh
docker pull イメージ名:タグ名
```

### イメージの一覧表示

```sh
# 全てのイメージを表示
docker images -a
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