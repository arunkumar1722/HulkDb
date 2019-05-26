package DataStore;

import File.FileOptions;
import File.FileManager;

public class DataManager implements Commands {
    /*
     * 1.New Hashmap generate
     * 3.options display
     * */


    private KeyValueDataStore keyValueDataStore;
    private FileManager fileManager;

    public DataManager(FileOptions options) {
        keyValueDataStore = new KeyValueDataStore();
        fileManager = new FileManager(options);
        create();
    }

    public DataManager(String fileName) {
        keyValueDataStore = new KeyValueDataStore();
        FileOptions options = new FileOptions(fileName);
        fileManager = new FileManager(options);
        create();
    }


    private void create() {
        System.out.println("DataManager is ready to go.");
    }


    @Override
    public void set(String key, String value) {
        keyValueDataStore.set(key, value);
    }

    @Override
    public String get(String Key) {
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
