#define MAX_CHAR 26  // There are 26 lowercase letters

// Function to check if all characters have equal frequency
bool areOccurrencesEqual(char *s) {
    int freq[MAX_CHAR] = {0};  // Array to store frequency of each character
    
    // Count frequency of each character
    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }
    
    // Find the frequency of the first non-zero character
    int firstFreq = -1;
    for (int i = 0; i < MAX_CHAR; i++) {
        if (freq[i] > 0) {
            firstFreq = freq[i];
            break;
        }
    }
    
    // Check if all non-zero frequencies are the same
    for (int i = 0; i < MAX_CHAR; i++) {
        if (freq[i] > 0 && freq[i] != firstFreq) {
            return false;
        }
    }
    
    return true;
}