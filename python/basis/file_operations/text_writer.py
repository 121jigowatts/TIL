# text file writer

text = '''\
apple
orange
banana
'''

with open('text.txt', 'a') as f:
    f.write(text)
