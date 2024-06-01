class Solution {
    public int scoreOfString(String s) {
         int score = 0;
        
        // Iterate over the characters of the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // Calculate the absolute difference between the ASCII values of adjacent characters
            int diff = Math.abs(s.charAt(i) - s.charAt(i - 1));
            // Add the difference to the score
            score += diff;
        }
        
        return score;
    }
}
