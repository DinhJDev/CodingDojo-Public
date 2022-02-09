class Call(object):
    def __init__(self, id, name, phoneNum, time, reason):
        self.id = id
        self.name = name
        self.phoneNum = phoneNum
        self.time = time
        self.reason = reason

    def display(self):
        print("Call ID: {}\nName: {}\nPhone Number: {}\nCall Time: {}\nCall Reason: {}".format(
            self.id, self.name, self.phoneNum, self.time, self.reason))


class CallCenter(object):
    def __init__(self):
        self.calls = []
        self.queueSize = len(self.calls)

    def add(self, call):
        self.calls.append(call)
        self.queueSize = len(self.calls)
        return self

    def remove(self):
        self.calls.pop(0)
        self.queueSize = len(self.calls)
        return self

    def info(self):
        for x in self.calls:
            x.display()
        print("Queue Size: {}".format(self.queueSize))


c1 = Call(1, "Jason", 1234, 10, "Help")
c2 = Call(2, "Karen", 5678, 20, "Complaint")

cc = CallCenter()
cc.add(c1).add(c2).info()
cc.remove().info()
