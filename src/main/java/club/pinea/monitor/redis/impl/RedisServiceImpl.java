package club.pinea.monitor.redis.impl;

import club.pinea.monitor.callback.RedisCallBack;
import club.pinea.monitor.config.RedisKeysConstants;
import club.pinea.monitor.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉<br>
 * 〈redis服务实现类〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private Jedis jedis;

    @Override
    public int setLocalIp(String value) {
        String result = jedis.set(RedisKeysConstants.LOCAL_IP_KEY, value);
        return result == null ? 0 : 1;
    }

    @Override
    public String getLocalIp() {
        return jedis.get(RedisKeysConstants.LOCAL_IP_KEY);
    }

    @Override
    public int setLocalIp(String value, RedisCallBack callback) {
        String result = jedis.set(RedisKeysConstants.LOCAL_IP_KEY, value);
        callback.callback(result, result == null ? 0 : 1);
        return 0;
    }

    @Override
    public String getLocalIp(RedisCallBack callBack) {
        String result = jedis.get(RedisKeysConstants.LOCAL_IP_KEY);
        callBack.callback(result, result == null ? 0 : 1);
        return result;
    }
}
