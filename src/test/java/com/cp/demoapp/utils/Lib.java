package com.cp.demoapp.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.Random;

public class Lib {

    public static String browser;

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max number must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getBrowser() {
        try {
            BufferedReader buff1 = new BufferedReader(new FileReader("src\\test\\resources\\Configuration.properties"));
            Properties properties = new Properties();
            properties.load(buff1);
            browser = properties.getProperty("browser");
            buff1.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return browser;
    }

}
