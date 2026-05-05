class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        res = 1.0
        for i in range(abs(n)):
            res *= x
        
        return 1/res if n < 0 else res