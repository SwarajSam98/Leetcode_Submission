class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to have numbers in ascending order
        Arrays.sort(nums);
      
        // Initialize the answer with a large value for comparison purposes
        int closestSum = Integer.MAX_VALUE;
      
        // The length of the numbers array
        int length = nums.length;
      
        // Iterate through each number in the array
        for (int i = 0; i < length; ++i) {
            // Initialize two pointers, one just after the current number and one at the end of the array
            int left = i + 1;
            int right = length - 1;
          
            // Continue as long as the left pointer is less than the right pointer
            while (left < right) {
                // Calculate the current sum of the three numbers
                int currentSum = nums[i] + nums[left] + nums[right];
              
                // If the current sum is equal to the target, return it immediately as the closest sum
                if (currentSum == target) {
                    return currentSum;
                }
              
                // If the current sum is closer to the target than the previous sum,
                // update closestSum with the current sum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
              
                // Move pointers based on how currentSum compares to the target
                if (currentSum > target) {
                    // If currentSum is greater than the target,
                    // move the right pointer to the left to reduce the sum
                    --right;
                } else {
                    // If currentSum is less than the target,
                    // move the left pointer to the right to increase the sum
                    ++left;
                }
            }
        }
      
        // Return the closest sum found
        return closestSum;
        
    }
}