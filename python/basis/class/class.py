# class

class Drink(object):
    def __init__(self, name, size):
        self.__name = name
        self.__size = size

    def age_check(self, age):
        return False

    @property
    def name(self):
        return self.__name

    @property
    def size(self):
        return self.__size


class Beer(Drink):
    def age_check(self, age):
        return age >= 18


class Cola(Drink):
    def age_check(self, age):
        return age > 0


class Person(object):
    def __init__(self, name, age):
        self.__name = name
        self.__age = age

    def say_something(self):
        print(f'I am {self.__name}. hello.')

    def order(self, drink):
        if drink.age_check(self.__age):
            print(f'{self.__name} order {drink.size} {drink.name}.')
        else:
            print(f'{self.__name} cannot order {drink.size} {drink.name}!')

    @property
    def name(self):
        return self.__name

    @property
    def age(self):
        return self.__age


mike = Person('Mike', 20)
alice = Person('Alice', 16)
beer = Beer('Heineken', 'large')
coke = Cola('Coca-Cola', 'medium')

mike.say_something()
mike.order(beer)

alice.say_something()
alice.order(beer)
alice.order(coke)
