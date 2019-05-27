package DataStore;

import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import Utils.Validations.TimeUtils;
import Utils.Validations.ValidationsUtils;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.HashMap;

public class KeyValueDataStore implements FileStore {


    private HashMap<String, JsonData> inMemoryDb;

    KeyValueDataStore() {
        inMemoryDb = new HashMap<>();
    }

    @Override
    public void set(String key, JSONObject value) throws DuplicateKeyException, KeySizeException, JsonSizeException {
        if (inMemoryDb.containsKey(key))
            throw new DuplicateKeyException();

        if (!ValidationsUtils.checkKeySize(key))
            throw new KeySizeException();


        if (!ValidationsUtils.checkJSONObjectSize(value))
            throw new JsonSizeException();

        JsonData jsonData = new JsonData(value);
        inMemoryDb.put(key, jsonData);
    }

    @Override
    public void setWithTTL(String key, JSONObject value, Long ttl) throws DuplicateKeyException, KeySizeException, JsonSizeException {
        if (inMemoryDb.containsKey(key))
            throw new DuplicateKeyException();

        if (!ValidationsUtils.checkKeySize(key))
            throw new KeySizeException();


        if (!ValidationsUtils.checkJSONObjectSize(value))
            throw new JsonSizeException();

        JsonData jsonData = new JsonData(value, ttl);
        inMemoryDb.put(key, jsonData);
    }

    @Override
    public JsonData get(String Key) throws NoKeyException {
        boolean present = inMemoryDb.containsKey(Key);

        if(!present)
            throw new NoKeyException();

        boolean isAlive = true;

        if (present) {
            JsonData jsonData = inMemoryDb.get(Key);
            Date expiryDate = TimeUtils.addSecondstoDate(jsonData.getDateCreated(), jsonData.getTimeToLive());
            Date now = new Date();
            isAlive = now.before(expiryDate);
        }

        if(!isAlive){
            inMemoryDb.remove(Key);
            throw new NoKeyException();
        }


        return inMemoryDb.get(Key);
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

    public HashMap<String, JsonData> getInMemoryDb() {
        return inMemoryDb;
    }

    public void setInMemoryDb(HashMap<String, JsonData> inMemoryDb) {
        this.inMemoryDb = inMemoryDb;
    }
}
