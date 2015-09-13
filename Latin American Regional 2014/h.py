
def func(a, b):
	return min(24 - abs(a-b), abs(a-b))

input = raw_input

n = int(input())
zones = sorted(map(int, input().split()))

a = sum([func(zones[i], zones[i+1]) for i in range(0, n, 2)])
b = sum([func(zones[i], zones[i+1]) for i in range(-1, n-1, 2)])

print(min(a, b))