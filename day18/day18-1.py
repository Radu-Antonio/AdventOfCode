cubes = {tuple(map(int, x.split(','))) for x in open("day18/input.in", "r").read().split('\n')}
sides = [(0,0,1), (0,1,0), (1,0,0), (0,0,-1), (0,-1,0), (-1,0,0)]
ans = 0

def get_sides(cube):
	x, y, z = cube
	count = 0
	for a, b, c in sides:
		if (x+a, b+y, z+c) in cubes:
			count += 1

	return count

for cube in cubes:
	ans += 6 - get_sides(cube)

print(ans)