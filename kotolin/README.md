# Kotlin

## 環境構築

HomebrewでCommand line compilerをインストールする。

```sh
brew update
brew install kotlin
```

### Hello world

```kotlin
fun main() {
    println("Hello, world!")
}
```

```sh
kotlinc hello.kt -include-runtime -d hello.jar
java -jar hello.jar
```

### REPL

```sh
kotlinc-jvm
>>> 1+1
res0: kotlin.Int = 2
>>> :quit
```
