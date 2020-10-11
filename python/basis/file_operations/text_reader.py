# text file reader
import os

path = './text.txt'
if os.path.exists(path):
    with open('text.txt', 'r') as f:
        print(f.read())
        while True:
            line = f.readline()
            print(line, end='')
            if not line:
                break
