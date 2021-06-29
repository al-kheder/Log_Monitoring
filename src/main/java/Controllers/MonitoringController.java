package Controllers;

import Managers.ConfigurationManager;
import Managers.LogFileManager;
import Managers.MailManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MonitoringController {
    private static final Logger LOG = LoggerFactory.getLogger(MonitoringController.class);
    private Properties properties;

    public MonitoringController() {
        this.properties = ConfigurationManager.getInstance().getProperties();
    }
    public void startScan() throws InterruptedException {

        List<String> filesToScan = ConfigurationManager.getInstance().getLogFileList();
        List<String> regexList = ConfigurationManager.getInstance().getRegexList();
        List<String> mailRecipients = ConfigurationManager.getInstance().getMailRecipients();

        // Will be filled with a List of matches for each RegEx applied to each file
        // Key = filename + regex, Value = list of matches
        HashMap<String, List<String>> matches = new HashMap<String, List<String>>();

        LogFileManager logFileManager = new LogFileManager();
        MailManager mailManager = new MailManager();

        // Match each Regex against each file, add matches to "matches" Hashmap
        for (String fileName : filesToScan) {
            for (String regex : regexList) {
                matches.put(fileName.concat("+" + regex), logFileManager.readLogFile(regex, fileName));
            }
        }
        if (matches.size() > 0) {
            mailManager.sendMail(String.join(",", mailRecipients), matches);
        } else {
            LOG.info("No matches mere found");
        }
    }


}
