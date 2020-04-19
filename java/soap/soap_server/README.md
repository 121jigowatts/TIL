# SOAP Server

## Start up

```sh
./mvnw clean install
./mvnw spring-boot:run
```

## Request

```sh
# Country情報照会
curl --header "content-type: text/xml" -d @request_country.xml http://localhost:8080/ws

# User情報照会
curl --header "content-type: text/xml" -d @request_user.xml http://localhost:8080/ws
```
