package club.pinea.monitor.loop;

import club.pinea.monitor.HTTPClientUtil;
import club.pinea.monitor.config.RedisKeysConstants;
import club.pinea.monitor.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    private RedisService redisService;

    @Scheduled(fixedRate = RedisKeysConstants.LOOP_TIME, initialDelay = 1000)
    public void loopIPtask(){
        String dbIP = redisService.getLocalIp();
        String localIP = HTTPClientUtil.getLocalIP();
        if(dbIP == null){

        }
    }

}
