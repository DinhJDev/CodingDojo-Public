class Car(object):
    def __init__(self, price, speed, fuel, mileage):
        self.price = price
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage

        if price > 10000:
            self.tax = 0.15
        else:
            self.tax = 0.12

    def display_all(self):
        print("Price: {}\nSpeed: {}\nFuel: {}\nMileage: {}\nTax: {}".format(
            self.price, self.speed, self.fuel, self.mileage, self.tax))


car1 = Car(2000, "35mph", "Full", "15mpg")
car2 = Car(20000, "35mph", "Empty", "15mpg")
car1.display_all()
car2.display_all()
