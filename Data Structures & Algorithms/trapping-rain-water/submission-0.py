from itertools import accumulate
class Solution:
    def trap(self, height: List[int]) -> int:
        pre = list(accumulate(height, max))
        suf = list(accumulate(height[::-1], max))[::-1]
        total = 0
        for i in range(len(height)):
            add = min(pre[i],suf[i]) - height[i]
            if add > 0:
                total += add
        return total