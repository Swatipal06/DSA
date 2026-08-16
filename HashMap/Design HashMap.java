/*
Problem: Design HashMap
Platform: LeetCode (706)

Approach:
1. Use two ArrayLists to store:
   - `keys`: Stores all keys.
   - `values`: Stores the corresponding values.
2. Maintain the relationship between a key and its value using
   the same index in both lists.
3. `put(key, value)`:
   - If the key already exists, update its corresponding value.
   - Otherwise, add the key and value at the end.
4. `get(key)`:
   - Find the key using `indexOf()`.
   - Return the corresponding value.
   - Return -1 if the key does not exist.
5. `remove(key)`:
   - Find the key's index.
   - Remove both the key and its corresponding value.

Time Complexity:
- put: O(n)
- get: O(n)
- remove: O(n)

Space Complexity: O(n)

Note:
- This is a simple implementation for understanding the basic
  key-value mapping concept.
- A true HashMap implementation would use hashing and buckets
  to achieve O(1) average time for put, get, and remove.
*/

class MyHashMap {
    List<Integer> keys;
    List<Integer> values;

    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if (keys.contains(key)) {
            values.set(keys.indexOf(key), value);
         } else {
            keys.add(key);
            values.add(value);
        }
    }
    
    public int get(int key) {
        if (!keys.contains(key)) {
            return -1;
        }
        return values.get(keys.indexOf(key));
    }
    
    public void remove(int key) {
        if (!keys.contains(key)) {
            return;
        }
        int index = keys.indexOf(key);
        keys.remove(index);
        values.remove(index);
    }
}
