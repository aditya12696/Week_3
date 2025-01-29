package hashmapshashfunctions.simplehashmap;

class SimpleHashMap {
    private static final int SIZE = 10; // Size of the hash map
    private String[] keys;
    private Integer[] values;

    public SimpleHashMap() {
        keys = new String[SIZE];
        values = new Integer[SIZE];
    }

    // Hash function to get index
    private int getHash(String key) {
        return key.hashCode() % SIZE;
    }

    // Put method to insert key-value pair
    public void put(String key, int value) {
        int index = getHash(key);
        keys[index] = key;
        values[index] = value;
    }

    // Get method to retrieve value by key
    public Integer get(String key) {
        int index = getHash(key);
        if (keys[index] != null && keys[index].equals(key)) {
            return values[index];
        }
        return null; // Not found
    }

    // Remove method to delete key-value pair by key
    public void remove(String key) {
        int index = getHash(key);
        if (keys[index] != null && keys[index].equals(key)) {
            keys[index] = null;
            values[index] = null;
        }
    }

    // Display all elements
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] != null) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }

    public static void main(String[] args) {
        SimpleHashMap map = new SimpleHashMap();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.display();

        System.out.println("Value of 'Two': " + map.get("Two"));

        map.remove("Two");

        System.out.println("After removing 'Two': ");
        map.display();
    }
}

