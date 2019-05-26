package File;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileWrite {

    //  private FileWriter fileWriter;
    private FileOutputStream fileWriter;
    private ObjectOutputStream objectOutputStream;


    public FileWrite(String fileName) {
        try {
            fileWriter = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Boolean storeInMemoryDb(HashMap<String, String> inMemoryDb) {
        boolean success = true;
        try {
            objectOutputStream.writeObject(inMemoryDb);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

}
