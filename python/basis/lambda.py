# lambda

values = [1, 2, 3, 4, 5]


def my_func(v, func):
    for i in v:
        if func(i):
            print(i)


# def sample_lambda(item):
#     return item % 2 == 0


# my_func(values, sample_lambda)

my_func(values, lambda item: item % 2 == 0)
my_func(values, lambda item: item % 2 == 1)
