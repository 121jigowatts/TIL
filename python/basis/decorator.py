# decorator

def logger(func):
    def wrapper(*args, **kwargs):
        print('start')
        func(*args, **kwargs)
        print('end')

    return wrapper


def func_info(func):
    def wrapper(*args, **kwargs):
        print('------')
        print('function:', func.__name__)
        print('args:', args)
        print('kwargs:', kwargs)
        print('------')
    return wrapper


@logger
@func_info
def some_fun(x, y):
    print(f'Done: x={x} y={y}')


some_fun(1, 2)
some_fun('a', 'b')
some_fun(True, False)
