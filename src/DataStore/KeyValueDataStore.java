package DataStore;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class KeyValueDataStore implements FileStore {

    private HashMap<String, JSONObject> inMemoryDb;

    KeyValueDataStore() {
        inMemoryDb = new HashMap<>();
    }

    @Override
    public void set(String key, JSONObject value) {
        inMemoryDb.put(key, value);
    }

    @Override
    public JSONObject get(String Key) {
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

    public HashMap<String, JSONObject> getInMemoryDb() {
        return inMemoryDb;
    }

    public void setInMemoryDb(HashMap<String, JSONObject> inMemoryDb) {
        this.inMemoryDb = inMemoryDb;
    }
}
