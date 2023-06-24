package org.Configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileInput {

    public Properties fileinput() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Sarvesh\\IdeaProjects\\Capstone_Axis\\src\\main\\java\\ProjectConfig\\config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }

}
