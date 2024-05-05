import dice as d

MAX_SIDES_SIX = 6
MAX_SIDES_TWELVE = 12


def main():
    """

    :return: print you win if one of the dice has the value that is twice the other's
    """
    user = input('Hit return: ')
    while user != 'Return':
        user = input('Invalid. Try again: ')
        while user == 'Return':
            # did extra credit so there is no parameter here but
            # if the default sides is not 6 then the parameter would be MAX_SIDES_SIX
            my_first_dice = d.Dice()
            my_second_dice = d.Dice(MAX_SIDES_TWELVE)
            first_dice = my_first_dice.get_current()
            second_dice = my_second_dice.get_current()
            print('First dice:', first_dice)
            print('Second dice:', second_dice)

            if first_dice == second_dice * 2:
                print('You win')
                break
            if second_dice == first_dice * 2:
                print('You win')
                break
            user = input('Hit return: ')


if __name__ == '__main__':
    main()
