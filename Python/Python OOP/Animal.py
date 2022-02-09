from mimetypes import init


class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health

    def walk(self):
        self.health -= 1
        return self

    def run(self):
        self.health -= 5
        return self

    def displayHealth(self):
        print("Health: {}".format(self.health))
        return self


a1 = Animal("Bob", 100)
a1.walk().walk().walk().run().run().displayHealth()


class Dog(Animal):
    def __init__(self, name):
        super(Dog, self).__init__(self, name)
        self.health = 150

    def pet(self):
        self.health += 5
        return self


d1 = Dog("April")
d1.walk().walk().walk().run().run().pet().displayHealth()


class Dragon(Animal):
    def __init__(self, name):
        super(Dragon, self).__init__(self, name)
        self.health = 170

    def fly(self):
        self.health -= 10
        return self

    def displayHealth(self):
        print("I am a Dragon")
        super(Dragon, self).displayHealth()
        return self


dr1 = Dragon("Yang")
dr1.walk().walk().walk().run().run().fly().displayHealth()
