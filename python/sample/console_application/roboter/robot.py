import csv
import os
import string

from termcolor import colored


class Robot(object):
    def __init__(self, name):
        self.__robot_name = name
        self.__color = 'green'
        self.__user_name = 'NoName'
        self.__ranking = {}
        self.__ranking_file = './ranking.csv'
        self.read_csv()

    def execute(self):
        # 挨拶
        content = self.get_content_greeting()
        self.display(content)

        name = input()
        if name:
            self.__user_name = name

        # おすすめのレストラン
        sorted_ranking = sorted(self.__ranking.items(), key=lambda x: x[1], reverse=True)
        for rank in sorted_ranking:
            recommended = rank[0]

            content = self.get_content_recommended_restaurant(recommended)
            self.display(content)

            yes_no = input()
            if not yes_no:
                break
            if yes_no.capitalize() == 'Yes':
                break
            if yes_no.capitalize() == 'Y':
                break

        # お気に入りのレストランを質問
        content = self.get_content_favorite_restaurant()
        self.display(content)

        favorite_restaurant = input()

        if favorite_restaurant:
            # 引数のレストラン名を大文字に変換
            restaurant_name = favorite_restaurant.capitalize()
            # ランキングからレストラン名をキーにカウントを取得
            recorded_count = self.__ranking.get(restaurant_name)
            if recorded_count is None:
                self.__ranking[restaurant_name] = 1
            else:
                # カウントが存在していた場合、インクリメント
                self.__ranking[restaurant_name] = int(recorded_count) + 1

            self.write_csv()

        # クロージング
        content = self.get_content_bye()
        self.display(content)

    def get_content_greeting(self):
        with open('./roboter/templates/greeting.txt', encoding="utf-8") as f:
            template = string.Template(f.read())
            return template.substitute(name=self.__robot_name)

    def get_content_favorite_restaurant(self):
        with open('./roboter/templates/favorite_restaurant.txt', encoding="utf-8") as f:
            template = string.Template(f.read())
            return template.substitute(name=self.__user_name)

    @staticmethod
    def get_content_recommended_restaurant(recommended):
        with open('./roboter/templates/recommended_restaurant.txt', encoding="utf-8") as f:
            template = string.Template(f.read())
            return template.substitute(recommended=recommended)

    def get_content_bye(self):
        with open('./roboter/templates/closing.txt', encoding="utf-8") as f:
            template = string.Template(f.read())
            return template.substitute(name=self.__user_name)

    def write_csv(self):
        with open(self.__ranking_file, 'w', newline='', encoding="utf-8") as csv_file:
            fieldnames = ['Name', 'Count']
            writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
            writer.writeheader()
            for k, v in self.__ranking.items():
                writer.writerow({'Name': k, 'Count': v})

    def read_csv(self):
        if os.path.exists(self.__ranking_file):
            with open(self.__ranking_file, 'r', encoding="utf-8") as csv_file:
                ranking = {}
                reader = csv.DictReader(csv_file)
                print('-- ranking data --')
                for row in reader:
                    print(row['Name'], row['Count'])
                    ranking[row['Name']] = int(row['Count'])
                self.__ranking = ranking

    def display(self, text):
        decorate = f'''\
**************************************************************
{text}
**************************************************************\
        '''

        print(colored(decorate, self.__color))
