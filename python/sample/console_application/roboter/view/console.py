""" Console """
import termcolor

DEFAULT_PRINT_COLOR = 'green'


def display(content, color=DEFAULT_PRINT_COLOR):
    """
    print
    """
    decorated_content = decoration(content)
    print(termcolor.colored(decorated_content, color))


def read_input(content=None, color=DEFAULT_PRINT_COLOR):
    """
    input
    """
    if content:
        decorated_content = decoration(content)
        return input(termcolor.colored(decorated_content, color))
    return input()


def decoration(content):
    """
    decorate
    """
    return f'''\
**************************************************************
{content}
**************************************************************
'''
