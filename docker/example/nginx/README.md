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

## tips

`docker-compose`実行時に`max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]`というメッセージが出て起動できない場合、以下のコマンドを実行する。

```sh
docker-machine ssh
sudo sysctl -w vm.max_map_count=262144
```
