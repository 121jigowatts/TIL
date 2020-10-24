# csv file reader

import csv

with open('text.csv', 'r') as csv_file:
    reader = csv.DictReader(csv_file)
    for row in reader:
        print(row['Name'], row['Count'])
