# gradle入門

参考：
> [Gradle Tutorials and Guides](https://gradle.org/guides/#getting-started)

## Javaアプリケーションのビルド
`main`メソッドを持つクラスを指定。

build.gradle
```
plugins {
    id 'java'
    id 'application'
}
mainClassName = 'demo.App'
```

## Javaライブラリのビルド
build.gradle
```
plugins {
    id 'java-library'
}
```

## Javaマルチプロジェクトのビルド
サブプロジェクトのディレクトリ名の参照を記載する。

settings.gradle
```
include 'api','common'
```

別プロジェクトを参照するにはdependenciesへ下記の通り記載。

build.gradle
```
dependencies {
    compile project(':common')
}
```