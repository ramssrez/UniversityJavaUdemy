package com.at.internship.system;

import java.io.*;
import java.util.Properties;

public class PropertyHandler {
    // Buena práctica de programación:
    // Se recomienda usar constructores privados en clases de utilería (utility classes),
    // cuyos métodos son todos estáticos
    private PropertyHandler() {}

    private static final String PROP_PROPS_FILE = "com.at.internship.system.propsFile";



    /**
     * Buena práctica de programación: Documentar métodos y parámetros en el formato estándar para javadocs
     * @param defaultPropsFile from classpath
     * @param configPropsFile anywhere in filesystem
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void load(String defaultPropsFile, String configPropsFile) throws FileNotFoundException, IOException {
        System.out.println("PROP_PROPS_FILE = " + PROP_PROPS_FILE);
        // Load default properties
        Properties defaultProps = new Properties(System.getProperties());
        //FileInputStream in = new FileInputStream(defaultPropsFile);
        InputStream in = PropertyHandler.class.getResourceAsStream(defaultPropsFile);
        defaultProps.load(in);
        in.close();

        // Create application properties
        Properties appProps = new Properties(defaultProps);

        // Load last invocation properties
        try {
            in = new FileInputStream(configPropsFile);
        } catch (FileNotFoundException e) {
            if(!new File(configPropsFile).createNewFile()) {
                System.err.printf("Failed to create file %s", configPropsFile);
                System.exit(1);
            }
            in = new FileInputStream(configPropsFile);
        }
        appProps.load(in);
        in.close();

        System.setProperties(appProps);
        System.setProperty(PROP_PROPS_FILE, configPropsFile);
    }

    public static String getStringProperty(String key) {
        return System.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    public static void clearProperty(String key) {
        System.getProperties().remove(key);
    }

    public static void persist() throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream(System.getProperty(PROP_PROPS_FILE));
        System.getProperties().store(out, "---No Comment---");
        out.close();
    }

}
