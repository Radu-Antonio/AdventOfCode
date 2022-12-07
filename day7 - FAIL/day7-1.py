with open("day7 - FAIL/input.in", "r") as file:
	dirs = set()
	prev = {}
	dir_sum = {}
	dir_folders = {}
	curr_dir = "root"

	for line in file:
		command = line.split()
		
		if command[0] == '$' and command[1] == "cd":
			dir_name = command[2]
			if dir_name == "..":
				curr_dir = prev[curr_dir]
			else:
				dirs.add(dir_name)
				prev[dir_name] = curr_dir
				curr_dir = dir_name

		if command[0] != '$':
			if command[0] == "dir":
				if curr_dir in dir_folders:
					dir_folders[curr_dir].append(command[1])
				else:
					dir_folders[curr_dir] = [command[1]]
			else:
				dir_sum[curr_dir] = dir_sum.get(curr_dir, 0) + int(command[0])

def dfs(dir):
	if dir not in dir_folders:
		return 

	for d in dir_folders[dir]:
		dfs(d)
		dir_sum[dir] += dir_sum[d]

dfs('/')
print(sum(dir_sum[dir] for dir in dirs if dir_sum[dir] <= 100000))

"""
- works with the example:
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
"""