with open("input.in", "r") as file:
	trail = set()
	tail = [0, 0]
	head = [0, 0]
	adj = [(x, y) for x in range(-1, 2) for y in range(-1, 2)]

	for line in file:
		dir, amount = line.split()
		for _ in range(int(amount)):
			prev_head = head.copy()
			if dir == 'U':
				head[1] += 1
			elif dir == 'D':
				head[1] -= 1
			elif dir == 'R':
				head[0] += 1
			else:
				head[0] -= 1

			for x, y in adj:
				if [tail[0]+x, tail[1]+y] == head:
					break
			else:
				tail = prev_head.copy()
			trail.add(tuple(tail))

	print(len(trail))