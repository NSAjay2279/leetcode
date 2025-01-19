class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert the wordDict to a HashSet for quick lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        
        // Call the helper function to break the word from index 0
        return dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        // If we reach the end of the string, return a list with an empty string (base case)
        if (start == s.length()) {
            return new ArrayList<>(Arrays.asList(""));
        }
        
        // If the result is already computed, return it from memo
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Try all possible prefixes starting from index 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            
            // If the prefix is a valid word in the dictionary
            if (wordSet.contains(word)) {
                // Recursively get the sentences from the remainder of the string
                List<String> subSentences = dfs(s, end, wordSet, memo);
                
                // For each sentence in subSentences, prepend the current word
                for (String subSentence : subSentences) {
                    result.add(word + (subSentence.isEmpty() ? "" : " " + subSentence));
                }
            }
        }

        // Store the result in the memo for future reference
        memo.put(start, result);
        return result;
    }
}
