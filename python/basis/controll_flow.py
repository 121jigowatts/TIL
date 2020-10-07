# if文
x = 10

if x < 0:
    print('negative')
elif x == 0:
    print('zero')
else:
    print('positive')

# for文
fruits = ['apple', 'banana', 'orange']
for fruit in fruits:
    print(fruit)
else:
    print('done')

# range関数
for i in range(3):
    print('hello')

# enumerate関数
for i, fruit in enumerate(fruits):
    print(i, fruit)

# dictionaryでfor文
people = {'alice': 18, 'bob': 32}
for k, v in people.items():
    print(k, ':', v)

# while文
count = 0
while count < 4:
    print(count)
    count += 1
else:
    print('done')
