import random

def coinToss():
    heads = 0
    tails = 0
    for x in range (0,10):
        num = random.random()

        if round(num) == 0:
            heads += 1
            print("Attempt #{}: Throwing the coin... It's a head! ... Got {} head(s) so far and {} tail(s) so far".format(x, heads, tails))
        else:
            tails += 1
            print("Attempt #{}: Throwing the coin... It's a tail! ... Got {} head(s) so far and {} tail(s) so far".format(x, heads, tails))

coinToss()