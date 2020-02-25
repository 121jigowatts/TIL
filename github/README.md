# GitHub CLI

[LINK](https://cli.github.com/)

## Install

```sh
brew install github/gh/gh
```

## Help

```sh
gh help
```

## Issue

```sh
# issueの一覧表示
gh issue list
```

```sh
# インタラクティブにissueを作成
gh issue create

# タイトルとボディを指定して作成
gh issue create --title "try GitHub CLI" --body "[GitHub CLI](https://cli.github.com/)"
```

```sh
# issueのステータスを表示
gh issue status
```

```sh
# Webブラウザで表示
gh issue view <number>
```

## Pull Request

```sh
# pull requestをcheckoutして確認する
gh pr checkout <number>
```

```sh
# pull requestの一覧表示
gh pr list
```

```sh
# インタラクティブにpull requestを作成
gh pr create

# タイトルとボディを指定して作成
gh pr create --title "try GitHub CLI" --body "[GitHub CLI](https://cli.github.com/)"
```

```sh
# pull requestのステータスを表示
gh pr status
```

```sh
# Webブラウザで表示
gh pr view <number>
```
