class Solution {
    public boolean isAnagram(String s, String t) {
        
        // Anagrams must be the same length
        if (s.length() != t.length()) return false;

        // Count frequency of each character in both strings
        int[] count = new int[26];  // Only lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, it's a valid anagram
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}