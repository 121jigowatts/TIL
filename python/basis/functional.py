# function

def hello():
    print('hello')
    return 0


return_code = hello()
print('return code:', return_code)


def my_func(cd, *args, **kwargs):
    """print function arguments.

    :param cd: code value.
    :param args: arguments are tuple.
    :param kwargs: keyword arguments are dictionary.
    :return: no return.
    """
    print(id, type(id))
    print(args, type(args))
    print(kwargs, type(kwargs))


my_func(1, '2', '3', name='alice', age=18)

# Type関数
print('TYPE:', type('moon'))

# ヘルプ関数
help(my_func)
