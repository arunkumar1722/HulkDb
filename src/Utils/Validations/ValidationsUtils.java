package Utils.Validations;

import org.json.simple.JSONObject;
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


}



