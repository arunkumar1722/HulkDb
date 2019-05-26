package DataStore;

import java.util.HashMap;

public class KeyValueDataStore implements FileStore {

    private HashMap<String, String> inMemoryDb;

    KeyValueDataStore() {
        inMemoryDb = new HashMap<>();
    }

    @Override
    public void set(String key, String value) {
        inMemoryDb.put(key, value);
    }

    @Override
    public String get(String Key) {
        boolean present = inMemoryDb.containsKey(Key);
        if (present) {
            return inMemoryDb.get(Key);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(String Key) {
        boolean present = inMemoryDb.containsKey(Key);
        if (present) {
            inMemoryDb.remove(Key);
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, String> getInMemoryDb() {
        return inMemoryDb;
    }

}
