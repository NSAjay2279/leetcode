class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        final int MAX_VALUE = 100;  // Maximum value for nums[i]
        int[] freq = new int[MAX_VALUE + 1];  // Hash table (array) to store frequencies of numbers

        // Iterate through the array to count the number of pairs with the absolute difference of k
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Check if num + k exists in the array (freq table)
            if (num + k <= MAX_VALUE && freq[num + k] > 0) {
                count += freq[num + k];
            }

            // Check if num - k exists in the array (freq table)
            if (num - k >= 0 && freq[num - k] > 0) {
                count += freq[num - k];
            }

            // Update the frequency of the current number
            freq[num]++;
        }

        return count;
    }
}