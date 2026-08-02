class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        visited = set()
        adj = [[] for _ in range(n)]
        for k,v in edges:
            adj[k].append(v)
            adj[v].append(k)

        def dfs(curr: int, parent: int) -> bool:
            if curr in visited:
                return False
            visited.add(curr)

            for i in adj[curr]:
                if not i == parent:
                    if not dfs(i, curr):
                        return False
            return True

        return dfs(0, -1) and len(visited) == n