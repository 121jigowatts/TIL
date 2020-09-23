# vim

## vimコマンド

### 文字削除

カーソル位置の一文字を削除する。

```vi
x
```

カーソル行を削除する。

```vi
dd
```

### やり直し

```vi
u
```

`control+r`でやり直し自体をやり直せる。

### 行コピー&ペースト

現在のカーソル位置の行をコピーする。複数行コピーしたい場合は行数と合わせて実行する。（e.g. `3yy`でカーソル位置から三行分コピー）

```vi
yy
```

カーソル位置へペーストする。

```vi
p
```

### 行カット&ペースト

現在のカーソル位置の行を切り取る（削除と同じ）。

```vi
dd
```

カーソル位置へペーストする。

```vi
p
```

### ウィンドウを横に分割して別ファイルを開く

`control+w w`でウィンドウの切り替え。

```vi
:sp /path/to/another.txt
```

### ウィンドウを縦に分割して別ファイルを開く

```vi
:vs /path/to/another.txt
```

## vimの設定

ホームディレクトリに`.vimrc`ファイルを作成し、設定を記述する。

### コメントアウト

```vi
" ダブルクォーテーションでコメントアウト
```

### 行番号の表示

```vi
set number
```

### 検索結果をハイライト

```vi
set hlsearch
```

### 検索時に大文字小文字を区別しない

```vi
set ignorecase
```

### tabを半角スペースへ

```vi
set expandtab
```

### tabの表示幅

```vi
set tabstop=4
```

### 行頭でのtab表示幅

```vi
set shiftwidth=4
```

### シンタックスハイライト

```vi
syntax on
```

### カラースキーマ

```vi
colorscheme elflord
```

`:colorscheme`コマンドで一時的に変更することも可能。`:colorscheme` + `space` + `control` + `D`で以下の選択可能なスキームを表示。

- blue
- darkblue
- default
- delek
- desert
- elflord
- evening
- industry
- koehler
- morning
- murphy
- pablo
- peachpuff
- ron
- shine
- slate
- torte
- zellner
