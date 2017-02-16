package org.learn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyWriter {

    public static void main(String[] args) {
        writeProperties();
    }

    private static void writeProperties() {
        InputStream inputStream = null;
        String fileName = "output.properties";
        try {
            Properties properties = new Properties();
            properties.setProperty("user.name", "admin");
            properties.setProperty("user.age", "25");
            properties.setProperty("user.country", "USA");
            properties.setProperty("user.email", "xyz@test.com");

            System.out.println("1. Start writing properties to Property file");
            File writeFile = new File("output.properties");
            FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
            properties.store(fileOutputStream, "Creating new property file");

            System.out.println("2. Writing properties to Property file : "+properties.toString());
            System.out.printf("3. Successfully written properties to file = %s", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
