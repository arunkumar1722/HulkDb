import DataStore.DataManager;
import File.FileOptions;
import File.FileRead;
import File.FileWrite;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Scanner in = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        String filepath, filename;
        String input;
        DataManager dm = null;

        System.out.println("Welcome to Hulk DB");

        System.out.println("Enter the file name:");
        filename = in.next();

        System.out.println("Enter the file path:");
        filepath = in.next();

        if (filepath.isEmpty()) {
            dm = new DataManager(filename);
        } else {
            FileOptions options = new FileOptions(filename, filepath);
            dm = new DataManager(options);
        }

        boolean nextTime = true;
        while (true) {
            System.out.println("Options :\n 1-Create. \n 2-Read. \n 3-Delete. \n 4-Exit. \n");
            input = in.next();

            switch (input) {
                case "1": {

                    System.out.println("Enter the Key");
                    String key = in.next();
                    //TODO key validations
                    System.out.println("Enter the Value");

                    String value = in.next();

                    dm.set(key,value);


                    break;
                }
                case "2": {
                    System.out.println("Enter the Key");
                    String key = in.next();


                   String value =  dm.get(key);
                   System.out.println("Your value is "+value);

                    break;
                }

                case "3": {
                    System.out.println("Enter the Key");
                    String key = in.next();


                    dm.delete(key);


                    break;
                }

                case "4": {
                    nextTime = false;
                    break;
                }
            }


        }


    }


}
