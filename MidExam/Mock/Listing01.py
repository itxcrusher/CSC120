def b(value):
    return value + 2


def c(a_list, value):
    a_list.append(value)
    return a_list


def advance(cl):
    return cl + 10


def main():
    a_list = [5, 10]
    x = 2
    val = 5

    output1 = advance(val)      # 15
    output2 = val               # 5
    output3 = b(x)              # 4
    output4 = c(a_list, b(x))   # address of [5, 10, 4]
    output5 = x                 # 2
    output6 = c(a_list, b(x+1)) # address of [5, 10, 4, 5]

    print(output1)      # 15
    print(output2)      # 5
    print(output3)      # 4
    print(output4)      # [5, 10, 4, 5]
    print(output5)      # 2
    print(output6)      # [5, 10, 4, 5]


if __name__ == "__main__":
    main()
