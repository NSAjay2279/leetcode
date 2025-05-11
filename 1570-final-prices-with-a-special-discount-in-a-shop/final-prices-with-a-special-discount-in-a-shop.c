#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    int* result = (int*)malloc(sizeof(int) * pricesSize);
    int* stack = (int*)malloc(sizeof(int) * pricesSize);
    int top = -1;

    for (int i = pricesSize - 1; i >= 0; --i) {
        int x = prices[i];
        // Pop elements greater than x
        while (top >= 0 && stack[top] > x) {
            top--;
        }
        // Apply discount if available
        if (top >= 0) {
            result[i] = x - stack[top];
        } else {
            result[i] = x;
        }
        // Push current price
        stack[++top] = x;
    }

    free(stack);
    *returnSize = pricesSize;
    return result;
}
