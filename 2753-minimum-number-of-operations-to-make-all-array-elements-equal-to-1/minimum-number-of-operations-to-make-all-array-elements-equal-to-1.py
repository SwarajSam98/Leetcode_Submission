class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)

        # Step 1: Compute overall GCD of the array.
        # If the overall GCD is > 1, we can never reach 1 (since GCD only decreases).
        overall_gcd = 0
        for num in nums:
            overall_gcd = math.gcd(overall_gcd, num)

        if overall_gcd != 1:
            return -1  # Impossible case

        # Step 2: If there's already a 1, each non-1 element can become 1 in one step.
        ones = nums.count(1)
        if ones > 0:
            return n - ones

        # Step 3: Find the smallest subarray whose gcd becomes 1.
        # Once found, we can compute total operations using (L - 1) + (n - 1).
        min_len = float('inf')
        for i in range(n):
            current_gcd = nums[i]
            for j in range(i + 1, n):
                current_gcd = math.gcd(current_gcd, nums[j])
                if current_gcd == 1:
                    min_len = min(min_len, j - i + 1)
                    break  # No need to go further for this starting point

        return (min_len - 1) + (n - 1)
        