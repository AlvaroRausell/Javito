import java.util.HashMap;
import java.util.Map;

public class Objects {
    private static HashMap<String, String> stringObjects  = new HashMap<>();

    private static HashMap<String, Boolean> booleanObjects = new HashMap<>();


    public static void add(String key, String value) {
        stringObjects.put(key,value);
    }



    public static void add(String key, boolean value) {
        booleanObjects.put(key,value);
    }

    public static String retrieveValueString(String key){
        return stringObjects.get(key);
    }

    public static boolean retrieveValueBool(String key){
        return booleanObjects.get(key);
    }



    public static boolean isObject(String line){

        for (Map.Entry e: booleanObjects.entrySet()){
            if (e.getKey().equals(line))
                return true;
        }
        for (Map.Entry e: stringObjects.entrySet()){
            if (e.getKey().equals(line))
                return true;
        }
        return false;
    }
    public static String findByKey(String key){

        for (Map.Entry e: booleanObjects.entrySet()){
            if (e.getKey().equals(key))
                return e.getValue().toString();
        }
        for (Map.Entry e: stringObjects.entrySet()){
            if (e.getKey().equals(key))
                return e.getValue().toString();
        }

        return null;
    }

}