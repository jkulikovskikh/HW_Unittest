class ListComparison:

    def __init__(self, list1, list2):
        self.list1 = list1
        self.list2 = list2

    def calc_average(self, input_data):
        if not isinstance(input_data, list):
            raise TypeError("Input should be a list")
        if not input:
            raise ZeroDivisionError("Division by zero. List is empty")
        return sum(input_data)/len(input_data)

    def comparison(self):
        average1 = self.calc_average(self.list1)
        average2 = self.calc_average(self.list2)
        if average1 > average2:
            return "Первый список имеет большее среднее значение"
        elif average1 < average2:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"

