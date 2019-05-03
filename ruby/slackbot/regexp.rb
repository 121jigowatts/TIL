class MessageAnalyzer
  @@pattern = /^ご飯[[:space:]|\s]*/ 
  def match?(text)
    p @@pattern
    p text
    @@pattern === text
  end

  def keyword(text)
    keyword = @@pattern.match(text).post_match
  end
end

text = 'ご飯'

re = MessageAnalyzer.new
puts re.match? text
keyword =  re.keyword text
puts keyword

if keyword.empty?
  puts 'Empty!'
end
