# Create a new Express framework web application

[Node.jsとExpressでWeb APIを作成する](https://docs.microsoft.com/en-us/learn/modules/build-web-api-nodejs-express/1-introduction)チュートリアル。

## 環境構築

```sh
mkdir webapi
cd webapi
# Node.jsプロジェクト用のpackage.jsonファイル作成
npm init -y
# Expressフレームワークのインストール
npm install express
```

`app.js`にコードを追加する。

### アプリケーションの開始

```sh
node app.js
```

### herokuへデプロイ

```sh
# Deploy先の作成
heroku create node-express-on-heroku
# masterブランチ意外でサブディレクトリをデプロイしたい場合
git subtree push --prefix node/webapi/ heroku <現在のブランチ>:master
# デプロイの確認
heroku open
```
