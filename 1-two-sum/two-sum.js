/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let hashTable = {};  // Use an object to mimic a hash table
    
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        
        // Check if the complement exists in the hash table
        if (hashTable[complement] !== undefined) {
            return [hashTable[complement], i];  // Return the indices of the two numbers
        }
        
        // Store the current number and its index in the hash table
        hashTable[nums[i]] = i;
    }
    
    // Return an empty array if no solution is found (although per the problem statement, one solution always exists)
    return [];
};
