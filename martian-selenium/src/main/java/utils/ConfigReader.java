package utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;

    private static Properties initProperties(){
        properties= new Properties();
         try {

           //FileInputStream ip = new FileInputStream("src/test/resources/config.properties"); 
           //path is tied to stream

           //works for ci/cd or any machine
           InputStream ip = Thread.currentThread().getContextClassLoader().
           getResourceAsStream("config.properties");
            properties.load(ip);
         } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("Config file not found or could not be loaded");
         }

        return properties;
    }

    public static String getProperty(String key){
       if ( properties==null ){
        initProperties();
       }
       
        return properties.getProperty(key);
    }

    public static String getBaseUrl(){
        initProperties();
        String env = System.getProperty("env","dev");
        String url = properties.getProperty("BASE_URL_"+env);
        return url;

    }
}
