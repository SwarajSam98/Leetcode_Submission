
class Solution {
    public int maxDifference(String s, int k) {
        int ans = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int n = s.length();
                int[] prefixA = new int[n + 1];
                int[] prefixB = new int[n + 1];

                // Build prefix arrays
                for (int i = 0; i < n; i++) {
                    prefixA[i + 1] = prefixA[i] + (s.charAt(i) == a ? 1 : 0);
                    prefixB[i + 1] = prefixB[i] + (s.charAt(i) == b ? 1 : 0);
                }

                // minDiff[parityA][parityB]
                int[][] minDiff = new int[2][2];
                for (int[] row : minDiff)
                    Arrays.fill(row, Integer.MAX_VALUE / 2);

                for (int l = 0, r = 0; r < n; r++) {
                    // Maintain window of size >= k and valid a, b counts
                    while ((r - l + 1) >= k &&
                            prefixA[l] < prefixA[r + 1] &&
                            prefixB[l] < prefixB[r + 1]) {

                        int pa = prefixA[l] % 2;
                        int pb = prefixB[l] % 2;
                        minDiff[pa][pb] = Math.min(minDiff[pa][pb], prefixA[l] - prefixB[l]);
                        l++;
                    }

                    int pa = prefixA[r + 1] % 2;
                    int pb = prefixB[r + 1] % 2;
                    int candidate = (prefixA[r + 1] - prefixB[r + 1]) - minDiff[1 - pa][pb];
                    ans = Math.max(ans, candidate);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
