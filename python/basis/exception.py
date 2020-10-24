# exception

values = [1, 2, 3, 4, 5]

try:
    values[10]
except IndexError as ex:
    print('list index out of range:(')
else:
    print('done')
finally:
    print('end')

print('@@@')

try:
    values[0]
except IndexError as ex:
    print('list index out of range:(')
else:
    print('done')
finally:
    print('end')


class MyException(Exception):
    pass


def some_func():
    raise MyException()


try:
    some_func()
except MyException as ex:
    print('This is my exception.')
