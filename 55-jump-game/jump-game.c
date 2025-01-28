#include <stdbool.h>

bool canJump(int* nums, int numsSize) {
    int furthest = 0;  // Track the furthest reachable index

    for (int i = 0; i < numsSize; i++) {
        // If the current index is beyond the furthest reachable index, return false
        if (i > furthest) {
            return false;
        }
        
        // Update the furthest reachable index
        furthest = (furthest > i + nums[i]) ? furthest : i + nums[i];
        
        // If we can reach or exceed the last index, return true
        if (furthest >= numsSize - 1) {
            return true;
        }
    }

    return false;  // If we finish the loop without reaching the end
}
