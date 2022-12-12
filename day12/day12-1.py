import queue

def bfs(start):
	global grid, dist
	dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))
	q = queue.Queue()
	q.put(start)
	a, b = start
	dist[a][b] = 0

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

	for i in range(n):
		for j in range(m):
			if grid[i][j] == 'S':
				start = (i, j)
				grid[i] = grid[i].replace('S', 'a')
			if grid[i][j] == 'E':
				end = (i, j)
				grid[i] = grid[i].replace('E', 'z')

	bfs(start)
	a, b = end
	print(dist[a][b])