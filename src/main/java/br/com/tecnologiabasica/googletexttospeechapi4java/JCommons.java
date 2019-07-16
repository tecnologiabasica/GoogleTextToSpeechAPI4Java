/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author afonso
 */
public class JCommons {

    private static JCommons instance = null;
    private String homeDir = null;
    private String propertyFile = ".googlecloud.properties";
    private String apiUrl = "https://texttospeech.googleapis.com";
    private String apiKey = null;

    public static JCommons getInstance() {
        if (instance == null) {
            instance = new JCommons();
        }
        return instance;
    }

    public String getHomeDir() {
        if (homeDir == null) {
            homeDir = System.getProperty("user.home");
        }
        File theDir = new File(homeDir);

        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (SecurityException se) {
                se.printStackTrace();
            }
        }
        return homeDir;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getPropertyFilePath() {
        return getHomeDir() + File.separator + propertyFile;
    }

    public String getFilePropertyVariable(String filePath, String property) {
        String returnValue = null;
        try {
            Properties prop = getPropertiesFile(filePath);
            if (prop != null) {
                returnValue = prop.getProperty(property);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnValue;
    }

    private Properties getPropertiesFile(String path) {
        Properties props = null;
        try {
            File fileTest = new File(path);
            if (fileTest.exists()) {
                FileInputStream file = new FileInputStream(path);
                props = new Properties();
                props.load(file);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return props;
    }

    public String getApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = getFilePropertyVariable(getPropertyFilePath(), "apiKey");
        }
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
