package Utils;

import org.json.simple.JSONObject;

import java.util.Random;

public class RandomJsonDataProvider {
    static Random random = new Random();

    public static JSONObject getRandomJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", getRandomName());
        jsonObject.put("Age", getRandomAge());
        jsonObject.put("Phone", getPhone());
        jsonObject.put("Gender", getRandomGender());
        return jsonObject;

    }

    private static String getRandomGender() {
        if (random.nextBoolean())
            return "Man";
        else
            return "Woman";
    }

    private static String getPhone() {
        return "889898332";
    }


    private static Integer getRandomAge() {
        return (int) (Math.random() * 50 + 1);
    }

    private static String getRandomName() {
        return "arun" + getRandomAge().toString();
    }


}
