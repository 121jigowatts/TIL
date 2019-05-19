require 'message_analyzer'

class MessageAnalyzerTest < Test::Unit::TestCase
  def setup
    pattern = /^ご飯[[:space:]|\s]*/
    @target = MessageAnalyzer.new(pattern)
  end

  def test_match
    text = 'ご飯'
    expected = true
    actual = @target.match? text
    assert_equal(expected, actual)
  end

  def test_discord
    text = 'testご飯'
    expected = false
    actual = @target.match? text
    assert_equal(expected, actual)
  end

  def test_keyword_empty
    text = 'ご飯'
    expected = ''
    actual = @target.get_keyword text
    assert_equal(expected, actual)
  end

  def test_keyword_a_word
    text = 'ご飯 新宿'
    expected = '新宿'
    actual = @target.get_keyword text
    assert_equal(expected, actual)
  end

end
