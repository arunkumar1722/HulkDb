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
        HashMap<String, String> inMemoryDb;

        try {

            System.out.println("objectInputStream.read() ==-1 = " + ( objectInputStream.read() ==-1));

            inMemoryDb = (HashMap<String, String>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("tried to read the already existing file but failed. because empty.");
            return new HashMap<>();
        }

        return inMemoryDb;
    }

}
