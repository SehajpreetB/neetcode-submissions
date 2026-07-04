class Solution {
public boolean util(int start, String s, Set<String> words, Boolean[] dp) {

        // Entire string has been segmented
        if (start == s.length())
            return true;

        // Already computed
        if (dp[start] != null)
            return dp[start];

        // Try every possible prefix starting at 'start'
        for (int end = start + 1; end <= s.length(); end++) {

            String prefix = s.substring(start, end);

            if (words.contains(prefix)) {

                if (util(end, s, words, dp)) {
                    return dp[start] = true;
                }
            }
        }

        return dp[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];

        return util(0, s, words, dp);
    }
}
