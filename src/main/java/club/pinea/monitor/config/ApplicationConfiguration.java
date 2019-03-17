package club.pinea.monitor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

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

    @Bean
    public Jedis initJedis(){
        Jedis jedis = new Jedis(redisIP, redisPort);
        if(redisAuth != null && !"".equals(redisAuth)){
            jedis.auth(redisAuth);
        }
        return jedis;
    }

}
