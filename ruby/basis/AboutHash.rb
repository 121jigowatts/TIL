# ハッシュの初期化
x_hash = { 'alice'=>18,'bob'=>26 }
y_hash = { alice: 18, bob: 26 }
z_hash = Hash.new

# 値の取得・変更
z_hash[:alice] = 18
puts z_hash[:alice]

