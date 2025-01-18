import java.util.*;

class AllOne {
    
    // HashMap to store key -> count
    private HashMap<String, Integer> keyToCount;
    
    // HashMap to store count -> set of keys
    private HashMap<Integer, Set<String>> countToKeys;

    public AllOne() {
        keyToCount = new HashMap<>();
        countToKeys = new HashMap<>();
    }

    // Increment the count of a key
    public void inc(String key) {
        int count = keyToCount.getOrDefault(key, 0);
        
        // Remove the key from the old count group
        if (count > 0) {
            countToKeys.get(count).remove(key);
            if (countToKeys.get(count).isEmpty()) {
                countToKeys.remove(count);
            }
        }
        
        // Add the key to the new count group
        count++;
        keyToCount.put(key, count);
        countToKeys.putIfAbsent(count, new HashSet<>());
        countToKeys.get(count).add(key);
    }

    // Decrement the count of a key
    public void dec(String key) {
        if (!keyToCount.containsKey(key)) {
            return;
        }

        int count = keyToCount.get(key);

        // Remove the key from the old count group
        countToKeys.get(count).remove(key);
        if (countToKeys.get(count).isEmpty()) {
            countToKeys.remove(count);
        }

        // Decrement the count and if the count reaches 0, remove the key
        if (count == 1) {
            keyToCount.remove(key);
        } else {
            count--;
            keyToCount.put(key, count);
            countToKeys.putIfAbsent(count, new HashSet<>());
            countToKeys.get(count).add(key);
        }
    }

    // Get the key with the maximum count
    public String getMaxKey() {
        if (countToKeys.isEmpty()) {
            return "";
        }
        
        int maxCount = Collections.max(countToKeys.keySet());
        return countToKeys.get(maxCount).iterator().next();
    }

    // Get the key with the minimum count
    public String getMinKey() {
        if (countToKeys.isEmpty()) {
            return "";
        }

        int minCount = Collections.min(countToKeys.keySet());
        return countToKeys.get(minCount).iterator().next();
    }
}
