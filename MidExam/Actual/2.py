inventory = []

def add_item(item_name, room_name, count = 1):
    index = get_item_in_room(room_name, item_name)
    if index == -1:
        item = [room_name, item_name, count]
        inventory.append(item)
    else:
        inventory[index][2] += count

def get_item_in_room(room_name, item_name):
    for i in range(len(inventory)):
        if inventory[i][0] == room_name and inventory[i][1] == item_name:
            return i
    return -1

def remove(name, room_name, count):
    index = get_item_in_room(room_name, name)
    if index != -1:
        inventory[index][2] -= count
        if inventory[index][2] <= 0:
            inventory.pop(index)

def move(name, old_room, new_room, count):
    remove(name, old_room, count)
    add_item(name, new_room, count)

def show_inventory(name):
    print(f"Inventory for {name}")
    total = 0
    for item in inventory:
        if item[1] == name:
            room = item[0]
            print(" in %s: %d" % (room, item[2]))
            #room, item_count = item[0], item[2]
            #print(f" - in {room}: {item_count}")
            #total += item_count
            total += item[2]
    print(f"TOTAL: {total}")

if __name__ == "__main__":
    add_item("chair", "living room")
    add_item("table", "kitchen", 1)
    add_item("chair", "kitchen", 2)
    add_item("chair", "living room", 2)
    add_item("table", "living room", 2)

    show_inventory("chair")
    print("complete")
    move("chair", "living room", "kitchen", 2)

    show_inventory("chair")
    print("complete")
    show_inventory("table")
