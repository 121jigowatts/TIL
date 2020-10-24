# generator

def some_func():
    for i in range(5):
        print(i)


def step():
    some_func()
    yield 'first step'
    some_func()
    yield 'second step'
    some_func()
    yield 'third step'


gen = step()
print(next(gen))
print('@@@')
print(next(gen))
print('@@@')
print(next(gen))
