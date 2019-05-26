package File;


import java.io.*;
import java.util.HashMap;

public class FileRead {

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;


    public FileRead(String fileName) {
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getInMemoryDb() {
        HashMap<String, String> inMemoryDb = null;

        try {
            inMemoryDb = (HashMap<String, String>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return inMemoryDb;
    }

}
