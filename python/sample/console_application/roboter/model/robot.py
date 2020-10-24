""" Robot """
import string


class Robot():
    def __init__(self, name):
        self._name = name


class RestaurantRobot(Robot):
    def __init__(self, name):
        super().__init__(name=name)
        self._username = 'NoName'
        self._dafault_path = './roboter/templates'

    def remenber_name(self, username):
        self._username = username

    def greeting(self):
        return self.__get_content_greeting()

    def ask_recommend(self, popular_restaurant):
        return self.get_content_recommend_restaurant(popular_restaurant)

    def ask_favorite(self):
        return self.__get_content_favorite_restaurant()

    def bye(self):
        return self.__get_content_bye()

    def __get_content_greeting(self):
        file_path = self._dafault_path + '/greeting.txt'
        with open(file_path, encoding="utf-8") as file:
            template = string.Template(file.read())
            return template.substitute(name=self._name)

    def get_content_recommend_restaurant(self, recommended):
        file_path = self._dafault_path + '/recommended_restaurant.txt'
        with open(file_path, encoding="utf-8") as file:
            template = string.Template(file.read())
            return template.substitute(recommended=recommended)

    def __get_content_favorite_restaurant(self):
        file_path = self._dafault_path + '/favorite_restaurant.txt'
        with open(file_path, encoding="utf-8") as file:
            template = string.Template(file.read())
            return template.substitute(name=self._username)

    def __get_content_bye(self):
        file_path = self._dafault_path + '/closing.txt'
        with open(file_path, encoding="utf-8") as file:
            template = string.Template(file.read())
            return template.substitute(name=self._username)
