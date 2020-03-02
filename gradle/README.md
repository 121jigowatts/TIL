# gradle入門

参考：
> [Gradle Tutorials and Guides](https://gradle.org/guides/#getting-started)

## Javaアプリケーションのビルド

`main`メソッドを持つクラスを指定。

build.gradle

```gradle
plugins {
    id 'java'
    id 'application'
}
mainClassName = 'demo.App'
```

## Javaライブラリのビルド

build.gradle

```gradle
plugins {
    id 'java-library'
}
```

## Javaマルチプロジェクトのビルド

サブプロジェクトのディレクトリ名の参照を記載する。

creating-multi-project-builds/settings.gradle

```gradle
include 'api','common'
```

別プロジェクトを参照するにはdependenciesへ下記の通り記載。

creating-multi-project-builds/api/build.gradle

```gradle
dependencies {
    compile project(':common')
}
```

## Spring Boot 2 アプリケーションのビルド

チュートリアル通りだと動かなかったので、ビルド時のエラーから以下の通り変更してエラーを解消した。

build.gradle

```gradle
plugins {
    id 'java'
    id 'com.gradle.build-scan' version '2.2.1'
    id 'org.springframework.boot' version '2.0.5.RELEASE'
    id 'io.spring.dependency-management' version '1.0.7.RELEASE'
}
```

## タスク

作成したタスクは`gradle tasks --all`でリスト表示することができる。グループを指定しておけば`--all`オプションは不要。

build.gradle

```gradle
tasks.register("hello") {
    group = 'Welcome'
    description = 'Produces a greeting'

    doLast {
        println 'Hello, World'
    }
}
```
