# クラス
class SimpleClass
  # アクセサ
  # 変数の値読み書き
  attr_accessor:value
  # 変数の値読み込み
  attr_reader:rate
  # attr_writerは値の書き換えのみ

  # イニシャライザ
  def initialize (a_value=100, a_rate=1.1)
    # インスタンス変数
    @value = a_value
    @rate = a_rate
  end

  # メソッド
  def method_a
    puts "method a"
  end

  # メソッドの引数はカッコで括らなくてもOK
  def method_b (x, y, z)
    puts "X:" + x + " Y:" + y + " Z:" + z
  end

  # 最後に評価された値が戻り値となるが、returnで明示しても良い
  def method_c x
    return x * 2
  end

  def calc
    @value * @rate
  end

end

class1 = SimpleClass.new
class1.method_a
class1.method_b('foo','var','hoge')
p class1.method_c 8
p class1.calc

p class1.rate
class1.value = 860
p class1.calc

