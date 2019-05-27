package DataStore;

import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import org.json.simple.JSONObject;

public interface FileStore {
    void set(String key, JSONObject value) throws DuplicateKeyException, KeySizeException, JsonSizeException;
    JSONObject get(String Key) throws NoKeyException;
    boolean delete(String key) throws NoKeyException;
}
