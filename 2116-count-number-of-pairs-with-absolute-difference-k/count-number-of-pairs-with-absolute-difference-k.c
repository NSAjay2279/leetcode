#define MAX_VALUE 100  // The maximum value of nums[i]

int countKDifference(int* nums, int numsSize, int k) {
    int count = 0;
    int freq[MAX_VALUE + 1] = {0};  // Hash table to store frequencies of numbers

    // Iterate through the array to count the number of pairs with the absolute difference of k
    for (int i = 0; i < numsSize; i++) {
        int num = nums[i];

        // Check if num + k exists in the hash table
        if (num + k <= MAX_VALUE && freq[num + k] > 0) {
            count += freq[num + k];
        }

        // Check if num - k exists in the hash table
        if (num - k >= 0 && freq[num - k] > 0) {
            count += freq[num - k];
        }

        // Update the frequency of the current number
        freq[num]++;
    }

    return count;
}

