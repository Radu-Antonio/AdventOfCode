with open("day10 - FAIL p2/input.in", "r") as file:
	querys = list(range(20, 221, 40))
	cycle = 0
	X = 1
	total_strength = 0

	for line in file:
		args = line.split()
		cycle += 1
		if cycle in querys:
			total_strength += X * cycle

		if args[0] == "addx":
			cycle += 1
			if cycle in querys:
				total_strength += X * cycle
			X += int(args[1])

	print(total_strength)