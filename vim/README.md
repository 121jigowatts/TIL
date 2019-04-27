# vimの設定

ホームディレクトリに`.vimrc`ファイルを作成し、設定を記述する。

## コメントアウト
```
" ダブルクォーテーションでコメントアウト
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
