# Python開発環境構築

DockerとVisual Studio Codeの拡張機能 [Remote-Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) を使用してPythonの開発環境を構築する。

## Dockerコマンド

```sh
# Pythonの最新イメージを取得し、ホスト上のディレクトリをコンテナへマウント
docker run --name python3 -v /path/to/:/app:ro --rm -itd python:latest
```

コマンドパレットから`Remote-Containers:Attach to Running Container...`と入力するかステータスバーからクイックアクセスする。

新しいウィンドウが立ち上がったらterminalより`python`を実行することが可能。

```sh
# マウントしたディレクトリへ移動
cd /app
# パッケージをインストール
pip install --no-cache-dir -r requirements.txt
# スクリプトの実行
python hello.py
```

## docker-composeコマンド

Dockerコマンドで入力するのは手間がかかるので、Dockerfileに`pip install`、docker-compose.ymlにボリュームのマウントを書いておき、docker-composeコマンドで起動する。

```sh
docker-compose up -d
# Dockerコマンドでコンテナに接続しても確認できる
docker exec -it pydevenv bash
```

コンテナが起動したら、上記と同様にRemote-Containersで接続することでVSCode上で開発と実行が可能となる。
