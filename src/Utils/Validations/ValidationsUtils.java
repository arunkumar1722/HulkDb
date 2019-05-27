package Utils.Validations;

import org.json.simple.JSONObject;

public class ValidationsUtils {

    public static boolean checkKeySize(String targetString){
        return targetString.length() <= 32;
    }

    public static boolean checkJSONObjectSize(JSONObject jsonObject){
       int countOfChars = jsonObject.toJSONString().length();
       return  countOfChars <=( 16 * 1024);
    }


}



