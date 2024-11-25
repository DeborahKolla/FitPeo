package utility;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {
        File src = new File("config.properties");

        try {

            FileInputStream fls = new FileInputStream(src);

            pro = new Properties();
            pro.load(fls);

        } catch (Exception e) {
            System.out.print("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }



}
