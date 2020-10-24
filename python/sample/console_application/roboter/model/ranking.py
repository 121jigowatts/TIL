""" Ranking of Popular Restaurant """
import csv
import os


class Ranking():
    def __init__(self):
        self.__data = {}
        self.__path = './ranking.csv'
        self.__read_csv()

    def popular_restaurant(self, asked):
        sorted_data = sorted(self.__data, key=self.__data.get, reverse=True)
        for name in sorted_data:
            if name in asked:
                continue
            return name

    def save(self, favorite_restaurant):
        if favorite_restaurant:
            # 引数のレストラン名を大文字に変換
            restaurant_name = favorite_restaurant.capitalize()
            # ランキングからレストラン名をキーにカウントを取得
            recorded_count = self.__data.get(restaurant_name)
            if recorded_count is None:
                self.__data[restaurant_name] = 1
            else:
                # カウントが存在していた場合、インクリメント
                self.__data[restaurant_name] = int(recorded_count) + 1

            self.__write_csv()

    def __write_csv(self):
        with open(self.__path, 'w', newline='', encoding="utf-8") as csv_file:
            fieldnames = ['Name', 'Count']
            writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
            writer.writeheader()
            for name, count in self.__data.items():
                writer.writerow({'Name': name, 'Count': count})

    def __read_csv(self):
        if os.path.exists(self.__path):
            with open(self.__path, 'r', encoding="utf-8") as csv_file:
                ranking = {}
                reader = csv.DictReader(csv_file)
                print('-- ranking data --')
                for row in reader:
                    print(row['Name'], row['Count'])
                    ranking[row['Name']] = int(row['Count'])
                self.__data = ranking
