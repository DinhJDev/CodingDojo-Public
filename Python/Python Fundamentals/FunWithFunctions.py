# Odd/Even

def odd_even(num):
    if num%2 != 0:
        print("Number is {}. This is an odd number.".format(num))
    else:
        print("Number is {}. This is an even number.".format(num))

for x in range (0, 11):
    odd_even(x)



# Multiply

a = [2,4,10,16]

def multiply(arr, multi):
    b = []
    for x in arr:
        b.append(x * 5)
    return b

result = multiply(a, 5)
print(result)