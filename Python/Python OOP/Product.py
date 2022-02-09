class Product(object):
    def __init__(self, price, itemName, weight, brand):
        self.price = price
        self.itemName = itemName
        self.weight = weight
        self.brand = brand
        self.status = "for sale"

    def sell(self):
        self.status = "sold"

    def addTax(self, tax):
        self.price = self.price + (self.price*tax)

    def returnProduct(self, reason):
        if reason == "defective":
            self.status = reason
            self.price = 0
        elif reason == "box":
            self.status = "for sale"
        elif reason == "opened":
            self.status = "used"
            self.price = self.price * .8
