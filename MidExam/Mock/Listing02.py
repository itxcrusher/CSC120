inventory = {}          # Dictionary, Empty, Global, 2D/Nested
MAX_ITEMS = 11


def add_item(room_name, item_name, count):      # 'Fox', 'Stick', 9
    if count < MAX_ITEMS:
        if room_name in inventory:
            inventory[room_name][item_name] = count     # inventory['Fox']['Stick'] = 9
        else:
            inventory[room_name] = {item_name: count}   # inventory['Fox'] = {'Stick': 9}
    else:
        print("Max 10 items allowed!")


def remove_item(room_name, item_name):
    """
    Removes room, item, count from the inventory if they are present
    :param room_name: Name of room
    :param item_name: Item name
    """
    if room_name in inventory and item_name in inventory[room_name]:
        del inventory[room_name][item_name]


def print_inventory():
    for room, items in inventory.items():
        for item, count in items.items():
            print(f"{room} has {count} {item}")


def main():
    add_item("Kitchen", "Spoons", 10)
    add_item("Garage", "Hammers", 5)
    print_inventory()
    remove_item("Kitchen", "Spoons")
    print_inventory()


if __name__ == "__main__":
    main()
