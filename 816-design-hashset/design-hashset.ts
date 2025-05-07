class MyHashSet {
    private table: number[][];

    constructor() {
        // Initialize the array to represent the hash table.
        this.table = new Array(1000); // You can adjust the size based on performance needs
    }

    // Hash function to compute the index based on the key
    private hash(key: number): number {
        return key % this.table.length;
    }

    add(key: number): void {
        const index = this.hash(key);
        if (!this.table[index]) {
            this.table[index] = [];
        }
        // Avoid duplicate values
        if (!this.table[index].includes(key)) {
            this.table[index].push(key);
        }
    }

    remove(key: number): void {
        const index = this.hash(key);
        const bucket = this.table[index];
        if (bucket) {
            const keyIndex = bucket.indexOf(key);
            if (keyIndex !== -1) {
                bucket.splice(keyIndex, 1); // Remove the key from the bucket
            }
        }
    }

    contains(key: number): boolean {
        const index = this.hash(key);
        const bucket = this.table[index];
        return bucket ? bucket.includes(key) : false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
