###########
# Syntax
###########

# if文
x = 123

if x % 2 == 0 then
  puts x.to_s + ' -> even'
else
  puts x.to_s + ' -> odd'
end

# for文
list = ['a','b','c','d']
for item in list
  puts item
end

# 範囲演算子
total = 0
for item in 1..100
  total += item
end
puts 'TOTAL:' + total.to_s

# 配列のeach
fruits = ['apple','banana','orange']
fruits.each do |item|
  puts item
end

# ハッシュのeach
members = { alice: 18, bob: 26, charlotte: 23 }
members.each do |name, age|
  puts name.to_s + ':' + age.to_s
end

# case文
month = 3

case month
when 1..3
  puts month.to_s + ' -> Fourth quarter.'
when 4..6
  puts month.to_s + ' -> First quarter.'
when 7..9
  puts month.to_s + ' -> Second quarter.'
when 10..12
  puts month.to_s + ' -> Third quarter.'
else
  puts 'Incorrect value.'
end

# while文
val = 0
while val < 5
  puts val
  val += 1
end

