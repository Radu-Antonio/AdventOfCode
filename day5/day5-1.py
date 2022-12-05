import re

with open("day5/input.in", "r") as file:
	matrix = [[] for _ in range(8)]
	items_position = range(1, 34, 4)

	for cnt in range(8):
		line = file.readline()
		for idx in items_position:
			matrix[cnt].append(line[idx])

	file.readline()
	file.readline()
	rows, cols = len(matrix), len(matrix[0])
	crates = [[] for _ in range(cols+1)]

	for col in range(cols):
		for row in range(rows-1, -1, -1):
			if matrix[row][col] == ' ':
				break
			crates[col+1].append(matrix[row][col])

	for line in file:
		amount, from_pillar, to_pillar = map(int, re.findall(r'\d+', line))
		crates[to_pillar].extend(crates[from_pillar][-amount:][::-1])
		crates[from_pillar] = crates[from_pillar][:-amount]

	for pillar in crates[1:]:
		print(pillar[-1], end = '')