num = int(input())
def fib(n):
    if n in (0, 1):
        return 1
    else:
        return fib(n - 1) + fib(n - 2)

def h(n):
    a = str(num)
    c = 0
    for i in range(len(a)):
        if a[i] == '1':
            c += fib(len(a) - i)
    return c

print(h(num))
