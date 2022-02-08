# Multiples

# Write code that prints all the odd numbers from 1 to 1000. Use the for loop and don't use a list to do this exercise.

for x in range (1,1000):
    if x % 2 == 1:
        print(x)



# Create another program that prints all the multiples of 5 from 5 to 1,000,000.

for x in range (5,1000000):
    if x % 5 == 0:
        print(x)



# Sum List

a = [1, 2, 5, 10, 255, 3]
sum = sum(a)
print(sum)



# Average List

print(sum/len(a))