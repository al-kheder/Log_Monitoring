import Controllers.MonitoringController;
import Managers.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Main {
    private static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();


        Properties properties = ConfigurationManager.getInstance().getProperties();

        MonitoringController monitoringController = new MonitoringController();

        monitoringController.startScan();

        long stopTime = System.currentTimeMillis();

        System.out.println("Execution Time is: " + (stopTime - startTime) + "Milli");

    }
}
