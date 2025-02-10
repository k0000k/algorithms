import sys

word = sys.stdin.readline().rstrip()
boom = sys.stdin.readline().rstrip()
stack = []
length = len(boom)

def is_equal():
    for i in range(length):
        if (boom[i] != stack[len(stack) - length + i]):
            return False
    return True

for char in word:
    stack.append(char)
    if (len(stack) >= length):
        if (is_equal()):
            for _ in range(length):
                stack.pop()

if (len(stack) == 0):
    print("FRULA")
else:
    for i in stack:
        print(i, end="")