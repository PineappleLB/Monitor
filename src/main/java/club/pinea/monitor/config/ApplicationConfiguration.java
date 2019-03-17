package club.pinea.monitor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
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

    @Value("${spring.redis.port}")
    private String redisAuth;

    @Value("spring.redis.port")
    private Integer redisPort = 6379;

    @Value("spring.mail.serverAddress")
    private String serverAddress;

    @Value("spring.mail.auth")
    private String emailAuth;

    @Value("spring.mail.sender")
    private String sender;

    @Value("spring.mail.user")
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
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = new Properties();

            props.setProperty("mail.smtp.host", serverAddress);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //       props.setProperty("mail.smtp.port", "587");
            //       props.setProperty("mail.smtp.socketFactory.port", "587"); 上传到云服务器上要添加的代码
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.transport.protocol", "SMTP");

            // 创建验证器
            Authenticator auth = () -> {
                //发送邮件的用户名     发送邮件的授权码
                return new PasswordAuthentication(user, emailAuth);
            };
            Session session = Session.getInstance(props, auth);
            return session;
            //TODO
        } catch (MessagingException e) {
            //TODO e
            return null;
        } catch (AddressException e) {
            return null;
        }
    }

}
