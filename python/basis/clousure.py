# closure

def outer(v):
    x = v

    def inner(message):
        nonlocal x
        x += 1
        return f'{message}: {x}'

    return inner


f = outer(10)
print(f('apple'))
print(f('orange'))
print(f('banana'))
