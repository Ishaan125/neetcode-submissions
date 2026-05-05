class Solution:
    def myPow(self, x: float, n: int) -> float:
        original = x
        flag = False
        if n == 0:
            return 1
        if n < 0:
            flag = True
            n = -n
        for i in range(n-1):
            x = original * x
        
        if flag:
            return 1/x
        return x