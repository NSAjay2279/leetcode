class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];

        // Initialize the array with values 1 to n
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // Helper function for recursive calculation
        return helper(arr, n, 0, k);
    }

    // Helper function to recursively find the winner
    private int helper(int[] arr, int length, int startIndex, int k) {
        // Base case: if there's only one person left
        if (length == 1) {
            return arr[0];
        }

        // Calculate the index to remove
        int indexToRemove = (startIndex + k - 1) % length;

        // Shift the remaining elements left to remove the person
        for (int i = indexToRemove; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Recurse with the new array and updated length
        return helper(arr, length - 1, indexToRemove, k);
    }

}