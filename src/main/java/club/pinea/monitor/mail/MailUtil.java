package club.pinea.monitor.mail;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

/**
 * 邮件的帮助类
 *
 * @author pineapple
 * @create 2019/3/17
 */
public class MailUtil {

    /**
     *
     * @param sender
     * @param receiver
     * @param title
     * @param content
     * @param session
     * @return
     */
    public static Message createMineMessage(String sender, String receiver, String title, String content, Session session) {
        try{
            // 创建一个Message，它相当于是邮件内容
            Message message = new MimeMessage(session);

            // 设置发送者
            message.setFrom(new InternetAddress(sender));

            // 设置发送方式与接收者
            message.setRecipient(RecipientType.TO, new InternetAddress(receiver));

            message.setSubject(title);
            message.setContent(content, "text/html;charset=UTF-8");
            message.setSentDate(new Date());
            return message;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
