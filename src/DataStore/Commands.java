package DataStore;

import org.json.simple.JSONObject;

public interface Commands {

    void set(String key, JSONObject value);
    JSONObject get(String Key);
    boolean delete(String key);
    void exit();
}
