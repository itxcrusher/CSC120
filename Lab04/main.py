from dice import Dice


def main():
    """
    Main function to execute the game logic. Creates two dice objects and rolls them continuously
    until the value of one die is exactly twice the value of the other, indicating a win.
    """
    d6 = Dice()
    d12 = Dice(12)

    while True:
        roll_d6 = d6.roll()
        roll_d12 = d12.roll()

        print(f"\nD6: {roll_d6}, D12: {roll_d12}")

        if roll_d12 == 2 * roll_d6 or roll_d6 == 2 * roll_d12:
            print("You won!")
            break

        input("Press return to continue...")


if __name__ == "__main__":
    main()
