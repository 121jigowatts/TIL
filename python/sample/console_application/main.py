# Udemy task
from roboter.controller import robot_controller
from roboter.model import ranking
from roboter.model import robot


def main():
    roboco = robot.RestaurantRobot('roboco')
    rank_model = ranking.Ranking()
    restaurant_robot = robot_controller.RobotController(roboco, rank_model)
    restaurant_robot.survey()


if __name__ == '__main__':
    main()
