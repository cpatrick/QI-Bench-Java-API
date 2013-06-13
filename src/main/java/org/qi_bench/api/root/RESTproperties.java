package org.qi_bench.api.root;


import java.io.InputStream;
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
        InputStream in = null;

        try {
                // See http://www.mkyong.com/java/java-properties-file-examples/ example 3
                //  for the source of the following line. The "magic" seems to be the call
                //  to "getClassLoader()" without it the method does not work.
            in = RESTproperties.class.getClassLoader().getResourceAsStream("REST.properties");
            restProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try{
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        buildDate = restProperties.getProperty("buildDate");
        version   = restProperties.getProperty("version");
    }
}
