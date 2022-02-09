x = [4, 6, 1, 3, 5, 7, 25]

def draw_stars(arr):
    for x in arr:
        stars = ""
        for y in range(0,x):
            stars += "*"
        print(stars)

draw_stars(x)