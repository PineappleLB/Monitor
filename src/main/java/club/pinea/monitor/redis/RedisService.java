package club.pinea.monitor.redis;

import club.pinea.monitor.callback.RedisCallBack;

/**
 * 〈一句话功能简述〉<br>
 * 〈redis操作相关服务〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
public interface RedisService {

    /**
     * 设置IP地址
     * @param value
     * @return
     */
    int setLocalIp(String value);

    /**
     * 获取IP地址
     * @return
     */
    String getLocalIp();

    /**
     * 设置IP地址，并且回调方法
     * @param value
     * @param callback
     * @return
     */
    int setLocalIp(String value, RedisCallBack callback);

    /**
     * 获取IP地址，并且调用回调方法
     * @param callBack
     * @return
     */
    String getLocalIp(RedisCallBack callBack);

}
