class MathDojo(object):
    def __init__(self):
        self.total = 0

    def add(self, num, *nums):
        self.total += num + sum(list(nums))
        return self

    def subtract(self, num, *nums):
        self.total -= num + sum(list(nums))
        return self

    def result(self):
        print(self.total)


md = MathDojo()
md.add(2).add(2, 5).subtract(3, 2).result()
