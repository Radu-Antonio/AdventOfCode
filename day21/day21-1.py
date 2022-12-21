monkey = {}
for line in open("day21/input.in", "r").read().split('\n'):
	name, op = line.split(": ")
	if op.isdigit():
		op = int(op)
	monkey[name] = op

def dfs(mon):
	if isinstance(monkey[mon], int):
		return monkey[mon]

	first, op, second = monkey[mon].split()
	monkey[mon] = eval(f'{dfs(first)} {op} {dfs(second)}')
	return monkey[mon]
	
print(dfs("root"))