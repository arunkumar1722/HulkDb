package DataStore;

import File.FileOptions;
import File.FileManager;
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
            System.out.println("Data has been restored from file to MAP!!!!");
        }

        System.out.println("DataManager is ready to go.");
    }


    @Override
    public void set(String key, JSONObject value) {
        keyValueDataStore.set(key, value);
    }

    @Override
    public JSONObject get(String Key) {
        return keyValueDataStore.get(Key);
    }

    @Override
    public boolean delete(String key) {
        return keyValueDataStore.delete(key);
    }

    @Override
    public void exit() {
        fileManager.getFileWrite().storeInMemoryDb(keyValueDataStore.getInMemoryDb());
    }


}
