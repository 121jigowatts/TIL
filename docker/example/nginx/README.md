# README

listenポートを8088に設定したdefault.confをコピーしたイメージをビルドする。


```sh
# Dockerfileからイメージをビルド
docker build -t nginx:edit1 .
```

## Dockerfile

`docker run`コマンドによるコンテナを起動。

```sh
docker run --name tmp-web -d -p 80:8088 --rm nginx:edit1
```

## docker-compose

docker-composeによるコンテナの起動。

```sh
docker-compose up -d
```

ブラウザから[index.html](http://localhost/index.html)にアクセスして、`index.hmtl`の内容が表示されることを確認。

