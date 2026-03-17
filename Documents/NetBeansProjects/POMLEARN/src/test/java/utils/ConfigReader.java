/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    /**
     * Loads the properties file based on the environment name.
     * @param env The name of the properties file (e.g., "prod", "qa")
     */
    public static void loadConfig(String env) {
        properties = new Properties();
        
        // 1. Get the absolute path to the project root
        String projectPath = System.getProperty("user.dir");
        
        // 2. Build the path (Using / works on both Windows and Linux/Mac)
        String filePath = projectPath + "/src/test/java/config/" + env + ".properties";
        
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            System.out.println("Successfully loaded configuration: " + filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config file not found at: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config file at: " + filePath);
        }
    }

    /**
     * Retrieves a value from the loaded properties file.
     * @param key The key to look for (e.g., "baseUrl")
     * @return The value associated with the key
     */
    public static String get(String key) {
        if (properties == null) {
            throw new RuntimeException("ConfigReader.properties is null. Did you forget to call loadConfig() in your @BeforeSuite?");
        }
        
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key [" + key + "] not found in the properties file.");
        }
        return value;
    }
}