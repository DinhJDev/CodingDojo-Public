# Find and Replace
words = "It's thanksgiving day. It's my birthday, too!"
print(words.replace("day","month",1))

# Min and Max
x = [2,54,-2,7,12,98]
print("The minimum of x is {}".format(min(x)))
print("The maximum of x is {}".format(max(x)))

# First and Last
y = ["hello",2,54,-2,7,12,98,"world"]
print(y[0])
print(y[len(y)-1])

# New List
z = [19,2,54,-2,7,12,98,32,10,-3,6]
z.sort()
z.append(z[0:len(z)/2])
for x in range (0,len(z)/2-1):
    z.pop(0)
z.insert(0,z[len(z)-1])
z.pop(len(z)-1)
print(z)