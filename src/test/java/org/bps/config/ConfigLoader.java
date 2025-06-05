package org.bps.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigLoader {
    private static Config config;

    public static void loadConfig(String env){
        String configFile = "environments/"+env;
        config = ConfigFactory.load(configFile);
    }

    public static String getAppUrl(){
        return config.getString("baseUrl");
    }

    public static String getUname(){
        return config.getString("uname");
    }

    public static String getPassword(){
        return config.getString("password");
    }

    public static String getBrowser(){
        return config.getString("browser");
    }
}
