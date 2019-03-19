package club.pinea;

import club.pinea.monitor.Application;
import club.pinea.monitor.mail.MailUtil;
import club.pinea.monitor.mail.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.Session;

/**
 * 测试邮件类
 *
 * @author pineapple
 * @create 2019/3/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMail {


    @Value("${spring.mail.serverAddress}")
    private String serverAddress;

    @Value("${spring.mail.auth}")
    private String emailAuth;

    @Value("${spring.mail.sender}")
    private String sender;

    @Value("${spring.mail.user}")
    private String user;

    @Autowired
    private Session session;

    @Autowired
    private SendMail sendMail;

//    @Test
//    public void testSendMail(){
//        sendMail.sendMail(MailUtil.createMineMessage(sender, "2443755705@qq.com", "IP变更", "120.79.29.207", session));
//    }

}
