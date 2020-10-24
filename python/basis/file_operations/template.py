# template

import string

text = '''\
Hi $name.

$message

good bye.
'''

template = string.Template(text)
contents = template.substitute(name='Alice', message='Have a nice day!')
print(contents)

print('######')

# テンプレート用のファイルを別に用意して読み込む
with open('templates/message_template.txt') as f:
    template = string.Template(f.read())
    contents = template.substitute(name='Alice', message='I like picture.')
    print(contents)
