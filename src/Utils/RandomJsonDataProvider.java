package Utils;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * Random Json Data Provider to Mock the User Input
 */
public class RandomJsonDataProvider {
    private static Random generator = new Random();

    public static JSONObject getRandomJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", getRandomName());
        jsonObject.put("Age", getRandomAge());
        jsonObject.put("Phone", getRandomPhone());
        jsonObject.put("Gender", getRandomGender());
        return jsonObject;

    }

    private static String getRandomGender() {
        if (generator.nextBoolean())
            return "Man";
        else
            return "Woman";
    }

    private static String getRandomPhone() {
        int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number

        num1 = generator.nextInt(7) + 1;
        num2 = generator.nextInt(8);
        num3 = generator.nextInt(8);
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;

        return "(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3;

    }


    private static Integer getRandomAge() {
        return generator.nextInt((100 - 18) + 1) + 18;
    }

    private static String getRandomName() {
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";


        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = generator.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(generator.nextInt(lexicon.length())));
            }
        }
        return builder.toString();
    }
}



