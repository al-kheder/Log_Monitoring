package Managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileManager {
    private static Logger LOG = LoggerFactory.getLogger(LogFileManager.class);
    private Properties properties;
    private List<String> logFileList;

    public LogFileManager() {
        this.properties = ConfigurationManager.getInstance().getProperties();
        this.logFileList = getLogFileList();
    }

    private List<String> getLogFileList() {
        if (logFileList == null) {
            logFileList = ConfigurationManager.getInstance().getLogFileList();
        }
        return logFileList;
    }

    /**
     * read a log file and  get the exception in the file
     */
    public List<String> readLogFile(String reg, String pfadFile) {
        // The RE pattern
        Pattern pattern = Pattern.compile(reg);
        // to store mached events
        List<String> matchedLines = new ArrayList<String>();
        // A FileReader (see the I/O chapter)
        try {
            BufferedReader r = new BufferedReader(new FileReader(pfadFile));
            // For each line of input, try matching in it.
            String line;
            int index = 1;
            while ((line = r.readLine()) != null) {
                // For each match in the line, extract and print it.
                Matcher m = pattern.matcher(line);
                while (m.find()) {
                    // matchedLines.add(m.toString());
                    matchedLines.add(line);

                    LOG.debug("your RegEx: " + m.group() + "  Start Position : " + m.start() + " End Position :" + m.end() + ", Line Number: " + index + "\n" + matchedLines);
                }
                index++;
            }
            LOG.debug("Total matched Line in File" + "(" + pfadFile + ") : " + matchedLines.size());
        } catch (IOException ex) {
            LOG.error("Error matching pattern " + reg + " in file " + pfadFile, ex);
        }
        return matchedLines;
    }//readFile()

}
