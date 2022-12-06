with open("day6/input.in", "r") as file:
	data = file.read()

for idx in range(len(data) - 13):
	if len(set(data[idx:idx+14])) == 14:
		print(idx+14)
		break