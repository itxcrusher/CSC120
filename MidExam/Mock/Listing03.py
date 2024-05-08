from UnitTest import UnitTest


class InventoryItem:    # inventory_item.py

    def __init__ (self, room_name, item_name, count):
        """
            Stores inventory information about a given item in a given room.
            :param room name: The name of the room the item is found in.
            :param item name: The name of the item.
            :param count: The number of the given item found in the given room.
        """
        self.__room_name = room_name
        self.__item_name = item_name
        self.__count = count

    def get_count(self):
        return self.__count

    def increment(self, amount=1):
        self.__count += amount

    def decrement(self, amount=1):
        if self.__count >= amount:
            self.__count -= amount
        else:
            self.__count = 0

def test_inventory_operations():
    item = InventoryItem("Fox", "Cat", 2)
    #item2 = InventoryItem("Dog", "Stick", 0)
    test = UnitTest()
    item.decrement(2)
    test.assert_equals("Test decrement", item.get_count(), 0)

if __name__ == "__main__":
    test_inventory_operations()
