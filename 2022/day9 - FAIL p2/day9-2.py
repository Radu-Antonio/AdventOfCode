import copy

with open("input.in", "r") as file:
	trail = set()
	arr = [[0, 0] for _ in range(10)]
	adj = [(x, y) for x in range(-1, 2) for y in range(-1, 2)]

	for line in file:
		dir, amount = line.split()
		for _ in range(int(amount)):
			prev_arr = copy.deepcopy(arr)
			if dir == 'U':
				arr[0][1] += 1
			elif dir == 'D':
				arr[0][1] -= 1
			elif dir == 'R':
				arr[0][0] += 1
			else:
				arr[0][0] -= 1

			# something is wrong here ...but what ?
			done = False
			for i in range(1, 10):
				for x, y in adj:
					if [arr[i][0]+x, arr[i][1]+y] == arr[i-1]:
						done = True
						break
				else:
					arr[i] = prev_arr[i-1].copy()
				if done:
					break
			trail.add(tuple(arr[-1]))

	print(len(trail))