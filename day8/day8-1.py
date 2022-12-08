with open("day8/input.in", "r") as file:
	grid = [list(map(int, line.strip())) for line in file]
	rows = len(grid)
	cols = len(grid[0])
	ans = 2 * (rows + cols) - 4

for i in range(1, rows-1):
	for j in range(1, cols-1):
		up = max(grid[k][j] for k in range(i))
		down = max(grid[k][j] for k in range(i+1, rows))
		left = max(grid[i][k] for k in range(j))
		right = max(grid[i][k] for k in range(j+1, cols))

		if grid[i][j] > min(up, down, left, right):
			ans += 1

print(ans)