package DataStore;

public interface Commands {

    void set(String key, String value);
    String get(String Key);
    boolean delete(String key);
    void exit();
}
