package DataStore;

import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import Utils.Validations.ValidationsUtils;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class KeyValueDataStore implements FileStore {

    private HashMap<String, JSONObject> inMemoryDb;

    KeyValueDataStore() {
        inMemoryDb = new HashMap<>();
    }

    @Override
    public void set(String key, JSONObject value) throws DuplicateKeyException, KeySizeException, JsonSizeException {
        if (inMemoryDb.containsKey(key))
            throw new DuplicateKeyException();

        if(!ValidationsUtils.checkKeySize(key))
            throw new KeySizeException();


        if(!ValidationsUtils.checkJSONObjectSize(value))
            throw new JsonSizeException();

        inMemoryDb.put(key, value);
    }

    @Override
    public JSONObject get(String Key) throws NoKeyException {
        boolean present = inMemoryDb.containsKey(Key);
        if (present) {
            return inMemoryDb.get(Key);
        } else {
            throw new NoKeyException();
        }
    }

    @Override
    public boolean delete(String Key) throws NoKeyException {
        boolean present = inMemoryDb.containsKey(Key);
        if (present) {
            inMemoryDb.remove(Key);
            return true;
        } else {
            throw new NoKeyException();
        }
    }

    public HashMap<String, JSONObject> getInMemoryDb() {
        return inMemoryDb;
    }

    public void setInMemoryDb(HashMap<String, JSONObject> inMemoryDb) {
        this.inMemoryDb = inMemoryDb;
    }
}
