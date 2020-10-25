"""
hello python script.
"""
import datetime

import termcolor

print(termcolor.colored('Hello Python', 'green'))
print('Running with docker.')
print(termcolor.colored(datetime.datetime.now(), 'blue'))
