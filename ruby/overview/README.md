# Overview

## Coding Style

クラスやモジュール名称は大文字始まりとする。複数単語で構成される場合はキャメルケースが推奨とされる。
```
class SimpleClass
end

module SimpleModule
end
```

メソッド名は小文字始まりとする。複数単語で構成される場合はスネークケースが慣例となっている。
```
def simple_method
end
```

真偽値を返却するメソッドは末尾に`?`を付けたメソッド名にするのが一般的となっている。
```
def done?
  true
end
```

変数名はメソッド名同様に小文字始まりとし、複数単語で構成される場合はスネークケースが慣例。
```
coding_style = 'ruby'
```



