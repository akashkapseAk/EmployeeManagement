package com.employee.Service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class ContactUsService {

       

    public boolean contactUs(String subject,String message,String to)
    {
        boolean f=false;

        String form="aryakapse@gmail.com";  //configuration your EmailId

        String host="smtp.gmail.com";

        Properties properties=System.getProperties();

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");


        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return  new PasswordAuthentication("aryakapse@gmail.com","qtefmftlfuxwcpcp");  //configuration your EmailId and genrate code 

            }
        });
        session.setDebug(true);
        MimeMessage m=new MimeMessage(session);
        try {

            m.setFrom(form);
            m.addRecipients(Message.RecipientType.TO,to);
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            System.out.println("mail sent success");
            f=true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return f;

    }
}
