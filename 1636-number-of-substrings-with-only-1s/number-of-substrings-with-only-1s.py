class Solution:
    def numSub(self, s: str) -> int:
        return sum(((l:=sum(map(int,g)))+1)*l//2 for c,g in groupby(s) if int(c))%(10**9+7)