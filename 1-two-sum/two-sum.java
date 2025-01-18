public class Solution {

    // Define a hash table entry class to store key-value pairs
    static class HashEntry {
        int key;
        int value;
        HashEntry next;

        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Define the hash table class
    static class HashTable {
        private static final int TABLE_SIZE = 10000;
        private HashEntry[] table;

        public HashTable() {
            table = new HashEntry[TABLE_SIZE];
        }

        // Hash function to compute index for a given key
        public int hash(int key) {
            return (key % TABLE_SIZE + TABLE_SIZE) % TABLE_SIZE;  // Ensures non-negative index
        }

        // Insert a key-value pair into the hash table
        public void insert(int key, int value) {
            int index = hash(key);
            HashEntry newEntry = new HashEntry(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
        }

        // Search for a key in the hash table and return its value if found
        public int search(int key) {
            int index = hash(key);
            HashEntry entry = table[index];
            while (entry != null) {
                if (entry.key == key) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return -1; // Return -1 if the key is not found
        }
    }

    // Function to find two indices whose values sum to the target
    public static int[] twoSum(int[] nums, int target) {
        HashTable hashTable = new HashTable();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int complementIndex = hashTable.search(complement);
            if (complementIndex != -1) {
                result[0] = complementIndex;
                result[1] = i;
                return result;
            }
            hashTable.insert(nums[i], i);
        }
        return result; // In case no solution is found, though the problem guarantees a solution
    }
}
