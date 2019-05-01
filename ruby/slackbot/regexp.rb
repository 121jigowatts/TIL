str = "ご飯　　    新宿 焼肉"
pattern = /^ご飯[[:space:]|\s]*/

p pattern === str

puts pattern.match(str).post_match

