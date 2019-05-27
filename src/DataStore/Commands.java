package DataStore;

import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import org.json.simple.JSONObject;

public interface Commands {
    void set(String key, JSONObject value) throws DuplicateKeyException, KeySizeException, JsonSizeException;
    void setWithTTL(String key, JSONObject value,Long ttl) throws DuplicateKeyException, JsonSizeException, KeySizeException;
    JsonData get(String Key) throws NoKeyException;
    boolean delete(String key) throws NoKeyException;
    void exit();
}
