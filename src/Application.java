import DataStore.DataManager;
import File.FileOptions;
import Utils.Exceptions.DuplicateKeyException;
import Utils.Exceptions.JsonSizeException;
import Utils.Exceptions.KeySizeException;
import Utils.Exceptions.NoKeyException;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filepath, filename;
        String input;

        DataManager dm;


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

        boolean shouldContinue = true;
        while (shouldContinue) {

            System.out.println("Options :\n 1-Create. \n 2-Read. \n 3-Delete. \n 4-Exit. \n");
            input = in.readLine();

            switch (input) {
                case "1": {
                    System.out.println("Enter the Key");
                    String key = in.readLine();
                    System.out.println("Enter the Value");
                    String value = in.readLine();

                    JSONObject obj;
                    obj = new JSONObject();
                    obj.put("Name", value);
                    obj.put("CharacterCount", value.length());
                    System.out.println(obj.toJSONString());

                    /*
                    SAMPLE:
                    {
                        "name ":"value",
                            "capsName":"VALUE"
                    }*/

                    try {
                        dm.set(key, obj);
                    } catch (DuplicateKeyException | KeySizeException | JsonSizeException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case "2": {
                    System.out.println("Enter the Key");
                    String key = in.readLine();


                    JSONObject value = null;
                    try {
                        value = dm.get(key);
                    } catch (NoKeyException e) {
                        e.printStackTrace();
                    } finally {
                        if (value != null)
                            System.out.println("Your value is " + value.toJSONString());

                    }


                    break;
                }

                case "3": {
                    System.out.println("Enter the Key");
                    String key = in.readLine();
                    try {
                        dm.delete(key);
                    } catch (NoKeyException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case "4": {
                    shouldContinue = false;
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