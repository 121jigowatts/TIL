# Powered by ホットペッパー Webサービス

require 'http'
require 'json'

base_url = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1"
keyword = "新宿 焼肉"
recommend = 4

response = HTTP.get(base_url, params: {
  key: ENV['RECRUIT_API_TOKEN'],
  keyword: keyword,
  order: recommend,
  count: 5,
  format: 'json'  
  })

=begin
data = JSON.parse(response.body)
#JSON.pretty_generate(JSON.parse(response.body))

data['results']['shop'].each do |shop|
  puts shop['name']
end
=end

data = JSON.parse(response.body, object_class: OpenStruct)

data.results.shop.each do |a_shop|
  puts a_shop.name
end

