class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int sum = 1;
        int up = 1;
        int down = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (down > 0) {
                    sum += down * (down + 1) / 2;
                    if (down >= up) {
                        sum += down - up + 1;
                    }
                    down = 0;
                    up = 1;
                }
                up = ratings[i] == ratings[i - 1] ? 1 : up + 1;
                sum += up;
            } else {
                down += 1;
            }
        }
        if (down > 0) {
            sum += down * (down + 1) / 2;
            if (down >= up) {
                sum += down - up + 1;
            }
        }
        return sum;
    }
}