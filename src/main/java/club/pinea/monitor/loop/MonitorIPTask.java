package club.pinea.monitor.loop;

import club.pinea.monitor.mail.MailUtil;
import club.pinea.monitor.mail.SendMail;
import club.pinea.monitor.util.HTTPClientUtil;
import club.pinea.monitor.config.RedisKeysConstants;
import club.pinea.monitor.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.Session;

/**
 * 〈一句话功能简述〉<br>
 * 〈监控IP地址〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
@Component
public class MonitorIPTask {

    @Autowired
    private RedisService redisServiceImpl;

//    @Autowired
//    private SendMail sendMail;
//
//    @Autowired
//    private Session session;

//    @Value("${spring.mail.sender}")
//    private String sender;
//
//    @Value("${spring.mail.receivers}")
//    private String receivers;

    @Autowired
    private UpdateDomainRecordService updateDomainRecordService;

    @Scheduled(fixedRate = RedisKeysConstants.LOOP_TIME, initialDelay = 1000)
    public void loopIPtask(){
        System.out.println("Monitoring ...");
        String dbIP = redisServiceImpl.getLocalIp();
        String localIP = HTTPClientUtil.getLocalIP();
        if(dbIP == null || !dbIP.equals(localIP)){
//            for (String receiver: receivers.split(",")) {
//                sendMail.sendMail(MailUtil.createMineMessage(sender, receiver, "IP变更", localIP, session));
//            }
            updateDomainRecordService.updateDomainRecordByHome(localIP);
            redisServiceImpl.setLocalIp(localIP);
        }
    }
}
