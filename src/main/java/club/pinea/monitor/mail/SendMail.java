package club.pinea.monitor.mail;


import javax.mail.Message;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送邮件类〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
public interface SendMail {

    /**
     * 发送邮件
     * @param message
     * @return
     */
    int sendMail(Message message);


}
