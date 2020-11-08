# EC2 - Elastic Compute Cloud

AWSクラウド上の仮想サーバー。

## EC2インスタンスへの接続

EC2インスタンスを作成し、キーペアを作成後ダウンロード(pemファイル)しておく。

```sh
# 秘密鍵ファイルをオーナー以外が使えないよう権限を厳しく設定
chmod 600 ./{ssh-key.pem}
# インスタンスのパブリックIPを指定
# ログインユーザはec2-userを指定
ssh -i ./{ssh-key.pem} ec2-user@xx.xx.xx.xx
# 初回のみ接続先サーバを信頼するか聞かれるのでyesと入力する
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
```
