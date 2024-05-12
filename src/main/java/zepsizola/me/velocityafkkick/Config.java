package zepsizola.me.velocityafkkick;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Properties config;

    public Config() {
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getKickWords() {
        return config.getProperty("kick-words");
    }

    public String getKickMessage() {
        return config.getProperty("kick-message");
    }
}