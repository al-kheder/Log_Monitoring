package Managers;

import org.junit.jupiter.api.Test;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MailManagerTest {

  @Test
    void testSendMail() {
        MailManager testMail = new MailManager();

        HashMap<String, List<String>> matches = new HashMap<>();
        List<String> values = new ArrayList<>();

        String key = "C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.\\";
        values.add("02-Aug-2019 14:14:05.258 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2943.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:07.342 WARNUNG [https-jsse-nio-8543-exec-1218] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2948.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:09.668 WARNUNG [https-jsse-nio-8543-exec-1227] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2952.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:13.403 WARNUNG [https-jsse-nio-8543-exec-1228] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2955.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:17.731 WARNUNG [https-jsse-nio-8543-exec-1197] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2960.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:20.548 WARNUNG [https-jsse-nio-8543-exec-1246] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2964.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:22.543 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2968.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:28.293 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2982.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:32.200 WARNUNG [https-jsse-nio-8543-exec-1238] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2984.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:35.085 WARNUNG [https-jsse-nio-8543-exec-1242] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2986.41239.809c1.\\1.bxss.me. Do you miss a dependency?");

        matches.put(key, values);

        testMail.sendMail("test@gmail.com", matches);

    }

    @Test
    void prepareMessage() throws MessagingException, IOException {
        MailManager prepareMessage = new MailManager();
        //Session
        Properties props = ConfigurationManager.getInstance().getMailProperties();
        //myAccount
        final String myAccount = props.getProperty("mail.smtp.user");
        final String password = props.getProperty("mail.smtp.password");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });

        //recipients
        String recipient = "ali.al-kheder@telekom.de,alkhdyyr@gmail.com";
        //Matches
        HashMap<String, List<String>> matches = new HashMap<>();
        List<String> values = new ArrayList<>();

        String key = "C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.";
        values.add("02-Aug-2019 14:14:05.258 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2943.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:07.342 WARNUNG [https-jsse-nio-8543-exec-1218] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2948.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:09.668 WARNUNG [https-jsse-nio-8543-exec-1227] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2952.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:13.403 WARNUNG [https-jsse-nio-8543-exec-1228] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2955.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:17.731 WARNUNG [https-jsse-nio-8543-exec-1197] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2960.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:20.548 WARNUNG [https-jsse-nio-8543-exec-1246] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2964.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:22.543 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2968.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:28.293 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2982.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:32.200 WARNUNG [https-jsse-nio-8543-exec-1238] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2984.41239.809c1.\\1.bxss.me. Do you miss a dependency?");
        values.add("02-Aug-2019 14:14:35.085 WARNUNG [https-jsse-nio-8543-exec-1242] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2986.41239.809c1.\\1.bxss.me. Do you miss a dependency?");

        matches.put(key, values);

        MimeMessage message = (MimeMessage) MailManager.prepareMessage(session, myAccount, recipient, matches);

        MimeMessage exmessageAttachment = new MimeMessage(session);

        exmessageAttachment.setText(
               "Hallo ali.al-kheder,alkhdyyr,\n"+
               "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:05.258 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2943.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:07.342 WARNUNG [https-jsse-nio-8543-exec-1218] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2948.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:09.668 WARNUNG [https-jsse-nio-8543-exec-1227] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2952.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:13.403 WARNUNG [https-jsse-nio-8543-exec-1228] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2955.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:17.731 WARNUNG [https-jsse-nio-8543-exec-1197] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2960.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:20.548 WARNUNG [https-jsse-nio-8543-exec-1246] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2964.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:22.543 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2968.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:28.293 WARNUNG [https-jsse-nio-8543-exec-1226] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2982.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:32.200 WARNUNG [https-jsse-nio-8543-exec-1238] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2984.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"+
                "Match for C:/Users/alkhd/Desktop/ProjektArbeit/catalina.out+dns.sqli.,\n"+
                " matched line: 02-Aug-2019 14:14:35.085 WARNUNG [https-jsse-nio-8543-exec-1242] org.primefaces.application.resource.PrimeResourceHandler.handleResourceRequest No dynamic resource handler registered for: sc';copy (select '') to program 'nslookup dns.sqli.\\018090.41239-2986.41239.809c1.\\1.bxss.me. Do you miss a dependency?"+"\n"

       );

        assertEquals(exmessageAttachment.getContent(), message.getContent());

    }
}

