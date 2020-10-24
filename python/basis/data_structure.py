# List
values = [1, 3, 5, 6, 2, 4]
print(type(values))
print(values.count(2))

values.sort()
print(values)

values.reverse()
print(values)

# Tuple
person = ("alice", 18, True)
print(type(person))
name, age, student = "alice", 18, True
print(name, age, student)

# Dictionary
products = {'apple': 100, 'banana': 120}
print(type(products))
pointer = dict(x=10, y=20)

print(products.keys())
print(products.values())
print(products['apple'])

# Set
my_set = {1, 2, 2, 2, 3, 3, 4, 5, 5}
print(my_set)

my_set.add(6)
my_set.remove(1)
print(my_set)
my_set.clear()
print(my_set)
