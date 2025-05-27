class Solution {
    public int differenceOfSums(int n, int m) {
        // Total sum from 1 to n
        int totalSum = n * (n + 1) / 2;

        // Count of multiples of m
        int k = n / m;

        // Sum of numbers divisible by m
        int divisibleSum = m * k * (k + 1) / 2;

        // Sum of numbers not divisible by m
        int nonDivisibleSum = totalSum - divisibleSum;

        return nonDivisibleSum - divisibleSum;
        
    }
}