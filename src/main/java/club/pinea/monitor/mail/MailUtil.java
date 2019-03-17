package club.pinea.monitor.mail;

import javax.mail.Message;
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
     * @param props
     * @return
     */
    public static Message createMineMessage(String sender, String receiver, String title, String content, Session session) {
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sender)); // 设置发送者

        message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

        message.setSubject(title);
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

        message.setContent(emailMsg);
        message.setSentDate(new Date());
        return message;
    }

}
