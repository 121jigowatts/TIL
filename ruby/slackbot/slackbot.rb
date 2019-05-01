require 'slack-ruby-client'

Slack.configure do |config|
  config.token = ENV['SLACK_API_TOKEN']
end

client = Slack::Web::Client.new
puts client.auth_test

# client.chat_postMessage(channel: '#dev', text: 'Hello World!', as_user: true)

channels = client.channels_list.channels
general_channel = channels.detect { |c| c.name = 'general' }

# puts general_channel

=begin
client.files_upload(
  channels: '#dev',
  as_user: true,
  file: Faraday::UploadIO.new('/Users/soil/Pictures/20180512_020517260_iOS.jpg', 'image/jpeg'),
  title: 'My Avatar',
  filename: 'avatar.jpg',
  initial_comment: 'Attached a selfie.'
)
=end

# general_channel = client.channels_info(channel: '#general')
# puts general_channel

ruby_user = client.users_info(user: '@ruby')
puts ruby_user


