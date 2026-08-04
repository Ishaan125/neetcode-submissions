class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        memo = {}
        res = 0

        def dfs(i, curr) -> int:
            if i >= len(nums):
                return 0

            if (i,curr) in memo:
                return memo[(i,curr)]

            skip = dfs(i+1, curr)
            take = 0

            if nums[i] > curr:
                take = 1 + (dfs(i+1, nums[i]))

            memo[(i,curr)] = max(skip, take)
            return memo[(i,curr)]
        
        for i in range(len(nums)):
            res = max(res, dfs(i,float("-inf")))

        return res