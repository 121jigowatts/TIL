# vimコマンド

## 文字削除

カーソル位置の一文字を削除する。
```
x
```

カーソル行を削除する。
```
dd
```

## やり直し

```
u
```
`control+r`でやり直し自体をやり直せる。

## 行コピー&ペースト

現在のカーソル位置の行をコピーする。複数行コピーしたい場合は行数と合わせて実行する。（e.g. `3yy`でカーソル位置から三行分コピー）
```
yy
```

カーソル位置へペーストする。
```
p
```

## ウィンドウを横に分割して別ファイルを開く

`control+w w`でウィンドウの切り替え。
```
:sp /path/to/another.txt
```

## ウィンドウを縦に分割して別ファイルを開く

```
:vs /path/to/another.txt
```

# vimの設定

ホームディレクトリに`.vimrc`ファイルを作成し、設定を記述する。

## コメントアウト
```
" ダブルクォーテーションでコメントアウト
```

## 行番号の表示
```
set number
```

## 検索結果をハイライト
```
set hlsearch
```

## 検索時に大文字小文字を区別しない
```
set ignorecase
```

## tabを半角スペースへ
```
set expandtab
```

## tabの表示幅
```
set tabstop=4
```

## 行頭でのtab表示幅
```
set shiftwidth=4
```

## シンタックスハイライト
```
syntax on
```

## カラースキーマ
```
colorscheme elflord 
```

`:colorscheme`コマンドで一時的に変更することも可能。`:colorscheme ` + `space` + `control` + `D`で以下の選択可能なスキームを表示。

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
