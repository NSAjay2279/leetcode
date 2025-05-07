#include <vector>
#include <list>
#include <iostream>

class MyHashSet {
public:
    MyHashSet() {
        // Initialize the hash set with a reasonable size
        table.resize(1000);  // The table size can be adjusted
    }
    
    void add(int key) {
        int index = hash(key);
        // Check if the key already exists in the corresponding bucket
        for (int k : table[index]) {
            if (k == key) return;  // No duplicates allowed
        }
        // Insert the key into the bucket
        table[index].push_back(key);
    }
    
    void remove(int key) {
        int index = hash(key);
        // Find and remove the key from the corresponding bucket
        auto& bucket = table[index];
        for (auto it = bucket.begin(); it != bucket.end(); ++it) {
            if (*it == key) {
                bucket.erase(it);
                return;
            }
        }
    }
    
    bool contains(int key) {
        int index = hash(key);
        // Check if the key exists in the corresponding bucket
        for (int k : table[index]) {
            if (k == key) return true;
        }
        return false;
    }

private:
    std::vector<std::list<int>> table;  // Hash table represented by a vector of lists
    
    // Hash function to map a key to an index
    int hash(int key) {
        return key % table.size();  // Simple hash function
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
