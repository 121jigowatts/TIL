# SOAP通信

## サーバの起動

```sh
git clone https://github.com/spring-guides/gs-producing-web-service.git
cd gs-producing-web-service/complete
./mvnw spring-boot:run
```

ブラウザから[http://localhost:8080/ws/countries.wsdl](http://localhost:8080/ws/countries.wsdl)にアクセスし機能することを確認。

## WSDLよりコード生成

pom.xmlに設定したurlよりWSDLクラスを`target/generated-sources`に自動生成する。

```sh
./mvnw clean compile
```

## アプリケーションの実行

クライアント側のアプリケーションの実行。

```sh
cd soap_client
./mvnw spring-boot:run
```

## 参考

- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
- [Consuming a SOAP web service](https://spring.io/guides/gs/consuming-web-service/)
