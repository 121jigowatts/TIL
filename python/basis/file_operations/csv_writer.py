# csv file writer

import csv

with open('text.csv', 'w', newline='') as csv_file:
    fieldnames = ['Name', 'Count']
    writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
    writer.writeheader()
    writer.writerow({'Name': 'A', 'Count': 1})
    writer.writerow({'Name': 'B', 'Count': 2})
    writer.writerow({'Name': 'C', 'Count': 3})
