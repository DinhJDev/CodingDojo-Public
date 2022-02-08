from tokenize import String


l = ['magical unicorns',19,'hello',98.98,'world']
#l = [2,3,1,7,4,12]
#l = ['magical','unicorns']
listType = ""
stringResult = ""
sumResult = 0

for x in range (0,len(l)):
    if isinstance(l[x],type(l[0])):
        if listType != "mixed":
            if type(l[0]) == str:
                listType = "string"
            elif type(l[0]) == int:
                listType = "integer"
    else:
        if listType != "mixed":
            listType = "mixed"

    if type(l[x]) == str:
        stringResult += l[x] + " "
    if type(l[x]) == int:
        sumResult += l[x]
    if type(l[x]) == float:
        sumResult += l[x]
    print(type(l[x]))

print("The list you entered is of {} type".format(listType))
print(stringResult)
print(sumResult)