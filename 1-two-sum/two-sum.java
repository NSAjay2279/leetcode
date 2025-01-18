class Solution { 
    public int[] twoSum(int[] nums, int target) {
        // Custom hash map to simulate the hash table structure
        class HashTable {
            private class Entry {
                int key;
                int value;
                Entry next;

                Entry(int key, int value) {
                    this.key = key;
                    this.value = value;
                    this.next = null;
                }
            }

            private Entry[] table;

            public HashTable(int size) {
                table = new Entry[size];
            }

            public void put(int key, int value) {
                // Ensure index is non-negative by taking absolute value
                int index = Math.abs(key % table.length);
                Entry newEntry = new Entry(key, value);
                if (table[index] == null) {
                    table[index] = newEntry;
                } else {
                    Entry current = table[index];
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newEntry;
                }
            }

            public Integer get(int key) {
                // Ensure index is non-negative by taking absolute value
                int index = Math.abs(key % table.length);
                Entry current = table[index];
                while (current != null) {
                    if (current.key == key) {
                        return current.value;
                    }
                    current = current.next;
                }
                return null;
            }
        }

        HashTable hashTable = new HashTable(10000);  // Initialize hash table with a size of 10000
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer index = hashTable.get(complement);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];  // Return an empty array if no solution is found
    }
}
