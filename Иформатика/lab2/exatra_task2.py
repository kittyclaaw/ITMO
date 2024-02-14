def decode(arr):
    s1 = arr[0] ^ arr[2] ^ arr[4] ^ arr[6]
    s2 = arr[1] ^ arr[2] ^ arr[5] ^ arr[6]
    s3 = arr[3] ^ arr[4] ^ arr[5] ^ arr[6]
    error = s1 + s2 * 2 + s3 * 4 - 1
    arr[error] = int(not arr[error])
    print('Ошибка в бите №', error + 1)
    return arr

arr = list(map(int, input().split()))
print(*decode(arr))
