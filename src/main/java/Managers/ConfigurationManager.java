package Managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.RegexReader;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ConfigurationManager {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationManager.class);
    private static ConfigurationManager instance;

    private Properties properties;
    private Properties mailProperties;
    private final String propertiesFilePath;
    private final String mailPropertiesFilePath;

    //Constructor
    public ConfigurationManager() {
        this.properties = new Properties();
        this.mailProperties = new Properties();
        this.propertiesFilePath = "LogFileConfig.properties";
        this.mailPropertiesFilePath = "mail.properties";
    }//Managers.ConfigurationManager

    public static ConfigurationManager getInstance() {
        if (instance == null) instance = new ConfigurationManager();

        return instance;
    }

    public Properties getProperties() {
        if (properties.isEmpty()) {
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(propertiesFilePath);

            try {
                properties.load(resourceStream);
                LOG.info("Successfully loaded configuration from file.");
            } catch (IOException ex) {
                LOG.error("Error while loading configuration from file " + propertiesFilePath + ". Exiting.", ex);
                System.exit(1);
            }
        }
        return properties;
    }

    public Properties getMailProperties() {
        if (mailProperties.isEmpty()) {

            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(mailPropertiesFilePath);

            try {
                mailProperties.load(resourceStream);
                LOG.info("Successfully loaded mail configuration from file.");
            } catch (IOException ex) {
                LOG.error("Error while loading mail configuration from file " + mailPropertiesFilePath + ". Exiting.", ex);
                System.exit(1);
            }
        }
        return mailProperties;
    }

    public List<String> getLogFileList() {
        List<String> logFileList = Collections.emptyList();

        File logFiles = new File(properties.getProperty("FILES_TO_WATCH_LIST"));

        try {
            logFileList = Files.readAllLines(logFiles.toPath());
        } catch (IOException e) {
            LOG.error("Failed to read from pattern list, check that the path is correct.", e);
            System.exit(1);
        }
        return logFileList;
    }

    public List<String> getRegexList() {
        List<String> regexList = new ArrayList<>();

        File regexFile = new File(properties.getProperty("SEARCH_PATTERNS_LIST"));
        String line;
        RegexReader regexReader = null;

        try {
            regexReader = new RegexReader(new FileReader(properties.getProperty("SEARCH_PATTERNS_LIST")));
        } catch (FileNotFoundException e) {
            LOG.error("Could not find RegEx search pattern file, exiting!");
            System.exit(1);
        }

        try {
            while ((line = regexReader.readLine()) != null) {
                regexList.add(line);
            }
        } catch (IOException e) {
            LOG.error("Failed to get list of Regexes, check that the path is correct.", e);
            System.exit(1);
        }
        return regexList;
    }

    public List<String> getMailRecipients() {
        List<String> recipients = new ArrayList<String>();

        try {
            RegexReader r = new RegexReader(new FileReader(properties.getProperty("MAIL_RECIPIENTS")));
            String line;

            while ((line = r.readLine()) != null) {
                recipients.add(line);
            }
        } catch (Exception e) {
            LOG.error("Failed to get list of mail recipients, check that the path is correct.", e);
            System.exit(1);
        }

        return recipients;
    }


}
