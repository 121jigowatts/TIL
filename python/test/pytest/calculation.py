class Calculation(object):
    @staticmethod
    def add(x, y):
        if type(x) is not int or type(y) is not int:
            raise ValueError
        return x + y

    @staticmethod
    def multiply(x, y):
        if type(x) is not int or type(y) is not int:
            raise ValueError
        return x * y
