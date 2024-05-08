class Checker:
    def __init__(self, row, column, color="red"):
        self.__color = color
        self.move = (row, column)
        self.__promoted = False
        self.__row = 0
        self.__column = 0

    def promote(self):
        self.__promoted = True

    def move(self, row, column):
        if 1 <= row <= 8:
            self.__row = row
            if self.__row == 8:
                self.promote()
        else:
            self.__row = 1

        if 1 <= column <= 8:
            self.__column = column
        else:
            self.__column = 1

    def get_color(self):
        return self.__color

    def get_row(self):
        return self.__row

    def get_column(self):
        return self.__column

    def is_promoted(self):
        return self.__promoted


def a(item):
    item += 3


def b(item):
    return item + 4


def c(a_list, x):
    a_list.append(x)


def clear(a_list):
    a_list = []


def advance(ch):
    ch.move(ch.get_row() + 1, ch.get_column() - 1)


def advance2(ch):
    ch = Checker(ch.get_row() + 1, ch.get_column() -1, ch.get_color())

x = 7
a(x)
print(x)  # first print
x = b(x)
print(x)  # second print

a_list = [1, 2, 3]
c(a_list, b(x))
print(str(a_list) + " __ " + str(x))  # third print

clear(a_list)
print(a_list)  # fourth print

ch = Checker(5, 8, "Black")
advance(ch)
print(ch.get_row())  # fifth print

c2 = Checker(2, 3)
advance2(c2)
print(c2.get_row())  # sixth print
