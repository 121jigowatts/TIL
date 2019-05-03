require 'regexp'

class MessageAnalyzerTest < Test::Unit::TestCase
  def test_match
    target = MessageAnalyzer.new
    text = 'ご飯'
    expected = true
    actual = target.match? text
    assert_equal(expected, actual)
  end 

  def test_keyword
    target = MessageAnalyzer.new
    text = 'ご飯'
    expected = ''
    actual = target.keyword text
    assert_equal(expected, actual)
  end
end
