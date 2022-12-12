import queue

def bfs():
	global grid, dist, q
	dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))

	while not q.empty():
		i, j = q.get()
		for a, b in dirs:
			x, y = i + a, j + b
			if 0 <= x < n and 0 <= y < m and dist[x][y] == float('inf') and ord(grid[x][y]) - ord(grid[i][j]) <= 1:
				dist[x][y] = dist[i][j] + 1
				q.put((x, y))

with open("day12/input.in", "r") as file:
	grid = list(map(lambda x: x.strip(), file.readlines()))
	n = len(grid)
	m = len(grid[0])
	dist = [[float('inf') for _ in range(m)] for _ in range(n)]
	q = queue.Queue()

	for i in range(n):
		for j in range(m):
			if grid[i][j] == 'S' or grid[i][j] == 'a':
				q.put((i, j))
				dist[i][j] = 0
			if grid[i][j] == 'E':
				end = (i, j)
				grid[i] = grid[i].replace('E', 'z')

	bfs()
	a, b = end
	print(dist[a][b])