with open("day6/input.in", "r") as file:
	data = file.read()

for idx in range(len(data) - 3):
	if len(set(data[idx:idx+4])) == 4:
		print(idx+4)
		break