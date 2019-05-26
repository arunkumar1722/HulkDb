package DataStore;

import org.json.simple.JSONObject;

public interface FileStore {
    void set(String key, JSONObject value);
    JSONObject get(String Key);
    boolean delete(String key);
}
