import math
import sys
from typing import Counter


def problem1_calculateDistance(x1, y1, x2, y2):
    return math.sqrt(pow(x2-x1, 2)+pow(y2-y1, 2))


def problem2(l):
    return list(set(l))


def problem3(a, b):
    return (a[:math.ceil(len(a)/2)]+b[:math.ceil(len(b)/2)], a[math.ceil(len(a)/2):]+b[math.ceil(len(b)/2):])


def problem4():
    f = open(sys.argv[len(sys.argv)-1], "r")
    my_str = f.read()
    f.close()
    words = Counter(my_str.split()).most_common(20)
    words = [word[0] for word in words]
    f = open("popular_words.txt", "w")
    f.write("\n". join(map(lambda word: str(word), words)))
    f.close()


def problem5(str):
    st = ""
    for s in str:
        if (s not in "aeouiAEOUI"):
            st = st+s
    return st


def problem6(str, char):
    return [i for i, x in enumerate(str) if x == char]


print("Problem 1")
print(problem1_calculateDistance(5, 2, 1, 2))
print("----------")

print("Problem 2")
l = [1, 2, 2, 3, 2]
l = problem2(l)
print(l)
print("----------")

print("Problem 3")
print(problem3("abcdef", "ghijk"))
print("----------")

print("Problem 4")
problem4()
print("----------")

print("Problem 5")
print(problem5("abcdefABC"))
print("----------")

print("Problem 6")
print(problem6("Google", 'o'))
print("----------") 
