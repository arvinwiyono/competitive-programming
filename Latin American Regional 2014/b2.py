input = raw_input

# Monash Lambda
line = input()
s_cost, refund = map(int, line.split())
A = list(input())
i_cost = s_cost - refund

n = len(A)
n_black = A.count('B')
n_white = A.count('W')

total_cost = 0

# For each black past the "halfway point"
for i in range(n_black, n):
	#print("".join(A[:i]) + " " + "".join(A[i:]))
	if A[i] == 'W':
		continue

	if 'B' not in A[i:]:
		break

	# Find closest white to the left
	near_index = None
	for j in range(n_black-1, -1, -1):
		if A[j] == 'W':
			near_index = j
			break

	# Test insertion on closest white
	dist = i - near_index
	a = i_cost * dist

	# Find furthest white to the left
	far_index = None
	for j in range(i):
		if A[j] == 'W':
			far_index = j
			break

	# Test selection on furthest white
	b = s_cost

	# If insertion is cheaper
	if (a < b):
		cost = a
		swap_with = near_index
	else:
		cost = b
		swap_with = far_index

	# Perform swap
	A[i], A[swap_with] = A[swap_with], A[i]
	total_cost += cost
	#print(total_cost)
	#print(near_index, far_index)

print(total_cost)