class Bike(object):
    def __init__(self, price, max_speed):
        self.price = price
        self.max_speed = max_speed
        self.miles = 0

    def displayInfo(self):
        print("This bike's price is: {}".format(self.price))
        print("This bike's max speed is: {}".format(self.max_speed))
        print("This bike has a mileage of {}".format(self.miles))
        return self

    def ride(self):
        print("Riding")
        self.miles += 10
        return self

    def reverse(self):
        if self.miles >= 5:
            print("Reversing")
            self.miles -= 5
        else:
            print("Can't reverse anymore")
            self.miles = 0
        return self


bike1 = Bike(200, "25mph")
bike1.ride().ride().ride().reverse().displayInfo()
bike2 = Bike(100, "15mph")
bike2.ride().ride().reverse().reverse().displayInfo()
bike3 = Bike(400, "35mph")
bike3.reverse().reverse().reverse().displayInfo()
