package Utils.Validations;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/** Contains all the validations methods
 * */
public class ValidationsUtils {

    public static boolean AssertKeySize(String targetString) {
        return targetString.length() > 32;
    }

    public static boolean AssertJsonObjectSize(JSONObject jsonObject) {
        int countOfChars = jsonObject.toJSONString().length();
        return countOfChars > (16 * 1024);
    }

    public static boolean AssertFileSize(FileInputStream file){
        long size;
        try {
           size = file.getChannel().size();
        } catch (IOException e) {
            e.printStackTrace();
            size = -1L;
        }

        return size > 1073741824L;
    }


}



