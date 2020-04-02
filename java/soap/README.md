# SOAP通信

## サーバの起動

```sh
cd soap_client
./mvnw spring-boot:run
```

ブラウザから[http://localhost:8080/ws/countries.wsdl](http://localhost:8080/ws/countries.wsdl)にアクセスし機能することを確認。

### tips1

Java 12環境ではpom.xmlに以下の設定を追加することでエラーを解消できた。

```xml
<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
<dependency>
  <groupId>javax.xml.bind</groupId>
  <artifactId>jaxb-api</artifactId>
  <version>2.3.0-b170201.1204</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.activation/activation -->
<dependency>
  <groupId>javax.activation</groupId>
  <artifactId>activation</artifactId>
  <version>1.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime -->
<dependency>
  <groupId>org.glassfish.jaxb</groupId>
  <artifactId>jaxb-runtime</artifactId>
  <version>2.3.0-b170127.1453</version>
</dependency>
```

## WSDLよりコード生成

pom.xmlに設定したurlよりWSDLクラスを`target/generated-sources`に自動生成する。

```sh
./mvnw clean compile
```

### tips2

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
