class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create an array of custom data class to store values and their original indices
        Data[] array = new Data[nums.length];
        
        // Fill the array with values and their corresponding indices
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Data(nums[i], i);
        }
        
        // Sort the array based on the value
        Arrays.sort(array, (a, b) -> Integer.compare(a.val, b.val));
        
        int i = 0, j = array.length - 1;
        while (i < j) {
            int sum = array[i].val + array[j].val;
            if (sum == target) {
                // Return the indices of the original positions
                return new int[] { array[i].idx, array[j].idx };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return null;
    }
    
    // Data class to store value and its index
    static class Data {
        int val;
        int idx;
        
        Data(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}