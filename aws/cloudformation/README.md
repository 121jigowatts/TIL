# AWS Cloudformation Template

```sh
# テンプレートファイルのバリデーションコマンド
aws cloudformation validate-template --template-body file://ec2.yml
```

```sh
# スタックの作成コマンド
aws cloudformation create-stack --stack-name handson-cfn-ec2 --template-body file://ec2.yml
```

```sh
# スタックの更新コマンド
aws cloudformation update-stack --stack-name handson-cfn-ec2 --template-body file://ec2.yml
```

## VPC

## EC2

## RDS

## ELB
