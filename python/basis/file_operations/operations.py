# file oparations

import os
import pathlib
import glob
import shutil
import time

# file/direcotry check
print('file exists:', os.path.exists('text.txt'))
print('is file: ', os.path.isfile('text.txt'))
print('is directory: ', os.path.isdir('templates'))

# make empty file
pathlib.Path('empty.txt').touch()

# copy file
shutil.copy('empty.txt', 'empty2.txt')

# make directory
os.mkdir('test_dir')

shutil.copy('empty.txt', 'test_dir/empty3.txt')

# file path
print(glob.glob('test_dir/*'))

# rename file
os.rename('empty2.txt', 'renamed.txt')

time.sleep(2)

# remove file
os.remove('test_dir/empty3.txt')
os.remove('renamed.txt')
os.remove('empty.txt')

time.sleep(2)

# remove direcotry
os.rmdir('test_dir')

# make symlink
# os.symlink('renamed.txt', 'symlink.txt')

# current path
print(os.getcwd())
