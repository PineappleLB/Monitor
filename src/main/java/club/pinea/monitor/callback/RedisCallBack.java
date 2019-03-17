package club.pinea.monitor.callback;

/**
 * 〈一句话功能简述〉<br>
 * 〈用于操作redis的回调〉
 *
 * @author Administrator
 * @create 2019/3/17
 * @since 1.0.0
 */
public interface RedisCallBack {

    Object callback(String value, int status);

}
