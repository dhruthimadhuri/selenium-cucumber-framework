package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigReader {
	
	 private static Properties prop = new Properties();
	 private static HashMap<String,String> configprop = new HashMap<>();
       
        static{
        	
        	try {
            FileInputStream fis = new FileInputStream("src/main/resources/Config/config.properties");
            prop.load(fis);
            for (String key: prop.stringPropertyNames()) {
            configprop.put(key.toLowerCase(), prop.getProperty(key).toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }



    public static String get(String key) {
        if (key == null) {
            return null;
        }
        return configprop.get(key.toLowerCase());
    }

    public static String get(String key, String defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return configprop.getOrDefault(key.toLowerCase(), defaultValue);
    }

        // Iterate through keys and match ignoring case
//        for (String propKey : prop.stringPropertyNames()) { //properties is a subclass of hashtable<object.object>->return set<string>
//            if (propKey.equalsIgnoreCase(key)) {
//                return prop.getProperty(propKey);
//            }
//        }
//        return null;  
 //   }
// to handle any missing config properties
//    public String get(String key, String defaultValue) {
//        return prop.getProperty(key, defaultValue);
//    }

}


