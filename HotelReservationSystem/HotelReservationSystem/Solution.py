class Reservation:
    def __init__(self, name, room=None):
        self.name = name
        self.room = room if room is not None else 0

    def set_room(self, room):
        self.room = room

    def set_name(self, name):
        self.name = name

    def get_room(self):
        return self.room

    def get_name(self):
        return self.name

    def __str__(self):
        return f"{self.name} - Room {self.room + 1}"

class Hotel:
    def __init__(self, number_of_rooms=5):
        self.number_of_rooms = number_of_rooms
        self.rooms = [Reservation("", i) for i in range(self.number_of_rooms)]

    def add_rooms(self, number_of_rooms):
        print(f"Added {number_of_rooms} more rooms.")
        for i in range(number_of_rooms):
            self.rooms.append(Reservation("", self.number_of_rooms))
            self.number_of_rooms += 1

    def reserve_room(self, person):
        if self.available_rooms() == 0:
            print(f"Hotel is full. No room available for {person}")
            return
        for r in self.rooms:
            if r.get_name() == "":
                r.set_name(person)
                print(f"{r.get_name()} reserved Room {r.get_room() + 1}")
                return

    def reserve_room_by_number(self, person, room):
        for r in self.rooms:
            if r.get_room() == room - 1:
                r.set_name(person)
                print(f"{r.get_name()} reserved Room {r.get_room() + 1}")
                return

    def available_rooms(self):
        return sum(1 for r in self.rooms if r.get_name() == "")

    def cancel_reservation(self, person):
        for r in self.rooms:
            if r.get_name() == person:
                r.set_name("")
                print(f"Cancelled reservations for {person}")
                return

    def print_reservations(self):
        print("Current Reservations:")
        current_reservations = 0
        for r in self.rooms:
            if r.get_name() != "":
                current_reservations += 1
                print(f"{r.get_name()} - Room {r.get_room() + 1}")
        print(f"Total Reservations: {current_reservations}")
        print(f"Available Rooms: {self.available_rooms()}")

def main():
    input_number = input()
    if len(input_number) == 1:
        hotel = Hotel(int(input_number))
        while True:
            try:
                command = input().split()
                if command[0] == "reserve":
                    if len(command) == 2:
                        hotel.reserve_room(command[1])
                    else:
                        hotel.reserve_room_by_number(command[1], int(command[2]))
                elif command[0] == "build":
                    hotel.add_rooms(int(command[1]))
                elif command[0] == "cancel":
                    hotel.cancel_reservation(command[1])
                elif command[0] == "print":
                    hotel.print_reservations()
            except EOFError:
                break
    else:
        hotel = Hotel()
        while True:
            try:
                command = input().split()
                if command[0] == "reserve":
                    if len(command) == 2:
                        hotel.reserve_room(command[1])
                    else:
                        hotel.reserve_room_by_number(command[1], int(command[2]))
                elif command[0] == "cancel":
                    hotel.cancel_reservation(command[1])
                elif command[0] == "build":
                    hotel.add_rooms(int(command[1]))
                elif command[0] == "print":
                    hotel.print_reservations()
            except EOFError:
                break

if __name__ == "__main__":
    main()
