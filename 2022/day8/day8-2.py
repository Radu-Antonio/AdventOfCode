with open("day8/input.in", "r") as file:
	grid = [list(map(int, line.strip())) for line in file]
	rows = len(grid)
	cols = len(grid[0])
	ans = 0

for i in range(1, rows-1):
	for j in range(1, cols-1):
		up = down = left = right = 0

		for k in range(i-1, -1, -1):
			up += 1
			if grid[k][j] >= grid[i][j]:
				break
		
		for k in range(i+1, rows):
			down += 1
			if grid[k][j] >= grid[i][j]:
				break
		
		for k in range(j-1, -1, -1):
			left += 1
			if grid[i][k] >= grid[i][j]:
				break
		
		for k in range(j+1, cols):
			right += 1
			if grid[i][k] >= grid[i][j]:
				break
		
		ans = max(ans, up * down * left * right)

print(ans)