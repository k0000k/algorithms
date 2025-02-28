import sys

sys.setrecursionlimit(10**6)

def dfs(node, tree, length):
    for i in tree[node]:
        if (length[i[0]] == -1):
            length[i[0]] = length[node] + i[1]
            dfs(i[0], tree, length)

N = int(sys.stdin.readline())
tree = [[] for i in range(N + 1)]
result_a = [-1 for i in range(N + 1)]
result_b = [-1 for i in range(N + 1)]
result_a[0] = 0
result_b[0] = 0

for i in range(N - 1):
    parent, child, val = map(int, sys.stdin.readline().split())
    tree[parent].append((child, val))
    tree[child].append((parent, val))

result_a[1] = 0
dfs(1, tree, result_a)

a = result_a.index(max(result_a))

result_b[a] = 0
dfs(a, tree, result_b)

print(max(result_b))