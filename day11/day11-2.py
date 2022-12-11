import re
from collections import defaultdict

def aux(a):
	return int(re.findall(r'\d+', a)[0])

with open("day11/input.in", "r") as file:
	monkeys = []
	freq = defaultdict(int)
	mod = 1

	for monkey in file.read().split('\n\n'):
		num, items, op, test, true, false = monkey.split('\n')
		num = aux(num)
		items = list(map(int, re.findall(r'\d+', items)))
		op = ['*' if '*' in op else '+', 'self' if re.findall(r'\d+', op) == [] else aux(op)]
		test = aux(test)
		true = aux(true)
		false = aux(false)
		monkeys.append([items, op, test, true, false])
		mod *= test

for _ in range(10000):
	for idx, monkey in enumerate(monkeys):
		items, op, test, true, false = monkey
		for item in items:
			freq[idx] += 1
			add = item if op[1] == 'self' else op[1]

			if op[0] == '+':
				item += add
			else:
				item *= add

			item %= mod
			monkeys[false if item % test else true][0].append(item)
		monkeys[idx][0] = []

a, b = sorted(freq.values())[-2:]
print(a * b)

# modular arithmetic idea from hyper-neutrino