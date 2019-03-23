package club.pinea.monitor.config;

/**
 * 〈一句话功能简述〉<br>
 * 〈redis键的常量表〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
public class RedisKeysConstants {

    // 本地ip地址
    public static final String LOCAL_IP_KEY = "localhost:ip";

//    public static final int LOOP_TIME = 1000 * 60 * 5;
    public static final int LOOP_TIME = 1000 * 30 * 1;

    // 修改绑定域名的IP地址的地址
    public static final String UPDATE_DOMAIN_IP_URL = "https://dnsapi.cn/Record.Modify";

    public static final String UPDATE_IP_LOG_KEY = "localhost:log";

}
