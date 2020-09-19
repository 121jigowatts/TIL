# README

listenポートを8088に設定したdefault.confをコピーしたイメージをビルドする

```sh
# Dockerfileからイメージをビルド
docker build -t nginx:edit1 .

# イメージからコンテナを起動
docker run --name tmp-web -d -p 80:8088 --rm nginx:edit1
```
