import File.FileRead;
import File.FileWrite;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world");
       /* FileRead fr = new FileRead("a.txt");
        fr.getInMemoryDb();
       */

        FileWrite fw = new FileWrite("a.txt");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("1", "Aru1");
        hm.put("2", "Aru2");
        hm.put("3", "Aru3");
        hm.put("4", "Aru4");

        boolean okay = fw.storeInMemoryDb(hm);
        System.out.println("OKay= " + okay);

        hm.clear();

        HashMap<String, String> mm = new HashMap<>();

        FileRead fr = new FileRead("a.txt");
        mm = fr.getInMemoryDb();


        System.out.println("Key = 1 , value = "+mm.get("1"));
        System.out.println("Key = 2 , value = "+mm.get("2"));
        System.out.println("Key = 3 , value = "+mm.get("3"));
        System.out.println("Key = 4 , value = "+mm.get("4"));


    }
}
