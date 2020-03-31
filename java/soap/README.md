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

### tips

pom.xmlの`<exclusion>`タグで以下のエラーが発生した。

```sh
Execution default of goal org.jvnet.jaxb2.maven2:maven-jaxb2-plugin:0.14.0:generate failed.
```

これはJAVA_HOMEを設定することで解消した。具体的には~/.zshrcに以下を記述し`source ~/.zshrc`を実行する。

```vim
export JAVA_HOME=`/usr/libexec/java_home -v 12`
export PATH=${JAVA_HOME}/bin:${PATH}
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
