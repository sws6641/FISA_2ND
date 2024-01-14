import sys
temp = {}

sz = int(sys.stdin.readline())

for _ in range(sz):
    key = int(sys.stdin.readline())
    if key in temp.keys():
        temp[key] += 1
    else:
        temp[key] = 1

fre = 0
ans = sys.maxsize
for k,v in temp.items():
    if v > fre:
        ans = k
    elif v == fre:
        if ans > k:
            ans = k

print(ans)


