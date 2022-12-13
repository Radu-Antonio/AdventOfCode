def is_correct(l1, l2):
	# i know it's a recursive function but idk how to implement it
	return None

with open("day13 - FAIL/input.in", "r") as file:
	packets = list(map(lambda x: list(map(eval, x.split('\n'))), file.read().split('\n\n')))
	count = 0

	for idx, (p1, p2) in enumerate(packets, start=1):
		if is_correct(p1, p2):
			count += idx

	print(count)