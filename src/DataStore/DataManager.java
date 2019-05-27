package DataStore;

import File.FileOptions;
import File.FileManager;
import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import org.json.simple.JSONObject;

public class DataManager implements Commands {

    private KeyValueDataStore keyValueDataStore;
    private FileManager fileManager;

    public DataManager(FileOptions options) {
        fileManager = new FileManager(options);
        keyValueDataStore = new KeyValueDataStore();
        create(options);
    }

    public DataManager(String fileName) {
        FileOptions options = new FileOptions(fileName);
        fileManager = new FileManager(options);
        keyValueDataStore = new KeyValueDataStore();
        create(options);
    }


    private void create(FileOptions options) {
        if (options.isAlreadyExists()){
            keyValueDataStore.setInMemoryDb(fileManager.getFileRead().getInMemoryDb());
        }

        System.out.println("DataManager is ready to go.");
    }


    @Override
    public void set(String key, JSONObject value) throws DuplicateKeyException, KeySizeException, JsonSizeException {
        keyValueDataStore.set(key, value);
    }

    @Override
    public JSONObject get(String Key) throws NoKeyException {
        return keyValueDataStore.get(Key);
    }

    @Override
    public boolean delete(String key) throws NoKeyException {
        return keyValueDataStore.delete(key);
    }

    @Override
    public void exit() {
        fileManager.getFileWrite().storeInMemoryDb(keyValueDataStore.getInMemoryDb());
    }


}
