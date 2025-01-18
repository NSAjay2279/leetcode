public class Solution {

    // Helper class to store value and index pair
    static class IndexedNum {
        int value;
        int index;

        IndexedNum(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    // Method to compare two IndexedNum objects for sorting
    static int compare(IndexedNum a, IndexedNum b) {
        return a.value - b.value;
    }

    // The twoSum method
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // Create an array of IndexedNum to hold values and their original indices
        IndexedNum[] indexedNums = new IndexedNum[n];
        for (int i = 0; i < n; i++) {
            indexedNums[i] = new IndexedNum(nums[i], i);
        }

        // Sort the indexedNums array by the value using bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compare(indexedNums[i], indexedNums[j]) > 0) {
                    // Swap
                    IndexedNum temp = indexedNums[i];
                    indexedNums[i] = indexedNums[j];
                    indexedNums[j] = temp;
                }
            }
        }

        // Use two pointers to find the target sum
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = indexedNums[left].value + indexedNums[right].value;
            
            if (sum == target) {
                // Return the indices of the numbers
                return new int[] { indexedNums[left].index, indexedNums[right].index };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Return an empty array if no solution is found
        return new int[0];
    }
}
