class Solution:
    def numSquares(self, n: int) -> int:
        squares = []  # list to store all perfect squares <= n
        i = 1         # start from 1 because 1*1 is the smallest perfect square
        while i * i <= n:
            squares.append(i * i)   # append the square of i to the list
            i += 1                  # move to the next integer

        # Step 2: Create a DP array where:
        # dp[x] = minimum number of perfect squares that sum to x.
        # Size is n + 1 so we can index from 0 to n directly.
        dp = [0] * (n + 1)  # initialize all values to 0 for now

        # We know:
        # dp[0] = 0 -> zero can be formed using 0 numbers.
        # For all other i, we will compute dp[i] iteratively.

        # Step 3: Fill dp for each value from 1 up to n.
        for target in range(1, n + 1):
            # For each 'target', we want to find the minimum count of squares.

            # Start with a large number as the initial best.
            # We'll minimize over all choices.
            min_count_for_target = float('inf')

            # Try every perfect square 'sq' that is <= current 'target'.
            for sq in squares:
                if sq > target:
                    # No need to continue if square is larger than target.
                    # Because squares list is sorted increasingly.
                    break

                # If we use this 'sq' once, then we need to form 'target - sq'
                # using perfect squares. That subproblem answer is dp[target - sq].
                # So total count if we choose this 'sq' is:
                # 1 (for this square) + dp[target - sq]
                current_count = 1 + dp[target - sq]

                # Update minimum if this choice is better.
                if current_count < min_count_for_target:
                    min_count_for_target = current_count

            # After checking all squares, assign the best found value
            # to dp[target].
            dp[target] = min_count_for_target

        # Step 4: The answer for original 'n' is stored in dp[n].
        return dp[n]
        