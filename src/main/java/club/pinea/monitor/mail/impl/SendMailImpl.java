package club.pinea.monitor.mail.impl;

import org.springframework.beans.factory.annotation.Value;

import club.pinea.monitor.mail.SendMail;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送邮件实现类〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
@Service
public class SendMailImpl implements SendMail {

    @Override
    public int sendMail(Message message) {
        try{
            Transport.send(message);
            System.out.println("发送成功！");
            return 1;
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
