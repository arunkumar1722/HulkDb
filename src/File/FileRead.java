package File;


import DataStore.JsonData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 * FileRead is a helper class that reads KeyValueDataStore from A File.
 * Used for Persistence.
 */
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

    public HashMap<String, JsonData> getInMemoryDb() {
        HashMap<String, JsonData> inMemoryDb;

        try {

            //System.out.println("objectInputStream.read() ==-1 = " + ( objectInputStream.read() ==-1));

            inMemoryDb = (HashMap<String, JsonData>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Tried to read the already existing file but failed because " + e.getMessage());
            return new HashMap<>();
        }

        return inMemoryDb;
    }

}
