""" Robot Controller """
from roboter.view import console


class RobotController():

    def __init__(self, robot, ranking):
        self.robot = robot
        self.ranking_model = ranking

    def survey(self):
        self.__greeting()
        self.__ask_recommended_restaurant()
        self.__ask_favorite_restaurant()
        self.__bye()

    def __greeting(self):
        username = console.read_input(self.robot.greeting())
        if username:
            self.robot.remenber_name(username)

    def __ask_recommended_restaurant(self):
        asked = []
        while True:
            restaurant_name = self.ranking_model.popular_restaurant(asked)
            if not restaurant_name:
                break
            asked.append(restaurant_name)
            ret = console.read_input(self.robot.ask_recommend(restaurant_name))
            if not ret:
                break
            if ret.capitalize() == 'Yes' or ret.capitalize() == 'Y':
                break

    def __ask_favorite_restaurant(self):
        restaurant_name = console.read_input(self.robot.ask_favorite())
        self.ranking_model.save(restaurant_name)

    def __bye(self):
        console.display(self.robot.bye())
