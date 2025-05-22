class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Width between the two lines
            int width = right - left;

            // Height is the minimum of the two lines
            int h = Math.min(height[left], height[right]);

            // Calculate area and update maxArea
            maxArea = Math.max(maxArea, width * h);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
        
    }
}