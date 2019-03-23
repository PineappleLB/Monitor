package club.pinea.monitor.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;

import java.util.Properties;
import java.security.Security;

/**
 * 〈一句话功能简述〉<br>
 * 〈项目整体配置〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
@Configuration
public class ApplicationConfiguration {

    @Value("${spring.redis.ip}")
    private String redisIP;

    @Value("${spring.redis.auth}")
    private String redisAuth;

    @Value("${spring.redis.port}")
    private Integer redisPort = 6379;

    @Value("${spring.mail.serverAddress}")
    private String serverAddress;

    @Value("${spring.mail.auth}")
    private String emailAuth;

    @Value("${spring.mail.sender}")
    private String sender;

    @Value("${spring.mail.user}")
    private String user;

    @Bean
    public Jedis initJedis() {
        Jedis jedis = new Jedis(redisIP, redisPort);
        if (redisAuth != null && !"".equals(redisAuth)) {
            jedis.auth(redisAuth);
        }
        return jedis;
    }

    @Bean
    public Session emailSession() {
        try{
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Properties props = new Properties();

            props.setProperty("mail.smtp.host", serverAddress);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.transport.protocol", "SMTP");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            // 创建验证器
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发送邮件的用户名     发送邮件的授权码
                    return new PasswordAuthentication(user, emailAuth);
                }
            };
            Session session = Session.getInstance(props, auth);
            return session;
            //TODO
        } catch(Exception e){
            return null;
        }

    }

}
