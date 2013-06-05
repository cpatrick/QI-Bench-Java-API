package org.qi_bench.api.root;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RESTproperties {

    public static String buildDate;
    public static String version;

        // Code in a "static" block like this is run through once
        //  see http://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
        //  in the section titled "Static Initialization Blocks"
    static { loadProperties(); }

    private static void loadProperties() {
        Properties restProperties = new Properties();
        try {
            restProperties.load(new FileInputStream("target/classes/REST.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildDate = restProperties.getProperty("buildDate");
        version   = restProperties.getProperty("version");
    }
}
