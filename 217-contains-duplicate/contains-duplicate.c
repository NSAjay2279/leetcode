#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// Simple hash set implementation for integers
#define HASH_SIZE 10007

typedef struct Node {
    int val;
    struct Node* next;
} Node;

Node* hashTable[HASH_SIZE];

unsigned int hash(int key) {
    return (unsigned int)(key >= 0 ? key : -key) % HASH_SIZE;
}

void hashSetInit() {
    for (int i = 0; i < HASH_SIZE; ++i) {
        hashTable[i] = NULL;
    }
}

bool hashSetContains(int key) {
    unsigned int idx = hash(key);
    Node* curr = hashTable[idx];
    while (curr) {
        if (curr->val == key) return true;
        curr = curr->next;
    }
    return false;
}

void hashSetAdd(int key) {
    unsigned int idx = hash(key);
    Node* node = (Node*)malloc(sizeof(Node));
    node->val = key;
    node->next = hashTable[idx];
    hashTable[idx] = node;
}

void hashSetFree() {
    for (int i = 0; i < HASH_SIZE; ++i) {
        Node* curr = hashTable[i];
        while (curr) {
            Node* tmp = curr;
            curr = curr->next;
            free(tmp);
        }
        hashTable[i] = NULL;
    }
}

bool containsDuplicate(int* nums, int numsSize) {
    hashSetInit();
    for (int i = 0; i < numsSize; ++i) {
        if (hashSetContains(nums[i])) {
            hashSetFree();
            return true;
        }
        hashSetAdd(nums[i]);
    }
    hashSetFree();
    return false;
}