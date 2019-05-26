import DataStore.DataManager;
import File.FileOptions;
import File.FileRead;
import File.FileWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filepath, filename;
        String input;
        DataManager dm = null;

        System.out.println("Welcome to Hulk DB");

        System.out.println("Enter the file name:");
        filename = in.readLine();

        System.out.println("Enter the file path or 'd' for default");
        filepath = in.readLine();

        if (filepath.equals("d") || filepath.equals("D") || filepath.isEmpty()) {
            dm = new DataManager(filename);
        } else {
            FileOptions options = new FileOptions(filename, filepath);
            dm = new DataManager(options);
        }

        boolean nextTime = true;
        while (nextTime) {
            System.out.println("Options :\n 1-Create. \n 2-Read. \n 3-Delete. \n 4-Exit. \n");
            input = in.readLine();

            switch (input) {
                case "1": {

                    System.out.println("Enter the Key");
                    String key = in.readLine();
                    //TODO key validations
                    System.out.println("Enter the Value");

                    String value = in.readLine();

                    dm.set(key, value);


                    break;
                }
                case "2": {
                    System.out.println("Enter the Key");
                    String key =in.readLine();


                    String value = dm.get(key);
                    System.out.println("Your value is " + value);

                    break;
                }

                case "3": {
                    System.out.println("Enter the Key");
                    String key = in.readLine();


                    dm.delete(key);


                    break;
                }

                case "4": {
                    nextTime = false;
                    dm.exit();
                    break;
                }
            }


        }


    }


}


/**
 * Sample path = /home/user/Downloads/Examples/
 */