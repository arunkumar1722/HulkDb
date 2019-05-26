package DataStore;

public interface FileStore {
    void set(String key, String value);
    String get(String Key);
    boolean delete(String key);
}
