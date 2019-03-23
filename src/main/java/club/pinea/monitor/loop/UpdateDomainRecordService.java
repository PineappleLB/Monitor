package club.pinea.monitor.loop;

import club.pinea.monitor.config.RedisKeysConstants;
import club.pinea.monitor.entity.UpdateErrorLog;
import club.pinea.monitor.redis.RedisService;
import club.pinea.monitor.util.HTTPClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新域名绑定IP的记录值服务
 *
 * @author pineapple
 * @create 2019/3/23
 */
@Component
public class UpdateDomainRecordService {

    @Autowired
    private RedisService redisService;

    /**
     * 参数值
     */
    private Object [] params = new Object[]{"login_token","format", "domain_id", "record_id", "sub_domain", "value", "record_type", "record_line_id"};
    /**
     * 参数名
     */
    private Object [] values = new Object[]{"88295,37f9ef8c6d0ee501faf74f25fd99d39f","json","61501618","413266028","home","110.185.214.233","A","0"};

    /**
     * 组织请求参数{参数名和参数值下标保持一致}
     * @param params    参数名数组
     * @param values    参数值数组
     * @return 参数对象
     */
    public List<NameValuePair> getParams(Object[] params, Object[] values){
        /**
         * 校验参数合法性
         */
        boolean flag = params.length>0 && values.length>0 &&  params.length == values.length;
        if (flag){
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for(int i =0; i<params.length; i++){
                nameValuePairList.add(new BasicNameValuePair(params[i].toString(),values[i].toString()));
            }
            return nameValuePairList;
        }else{
            System.err.println("参数对应有误，无法解析参数！");
        }
        return null;
    }

    public void updateDomainRecordByHome(String localIp) {
        if(localIp == null || "".equals(localIp)) {
            throw new IllegalArgumentException("IP地址不能为空！");
        }
        UpdateErrorLog log = null;
        // 重新设置新的IP地址值
        values[5] = localIp;
        List<NameValuePair> paramsList = getParams(params, values);
        try{
            JSONObject obj = HTTPClientUtil.doPostWithJson(RedisKeysConstants.UPDATE_DOMAIN_IP_URL, paramsList);
            System.out.println(obj);
            log = new UpdateErrorLog(null, localIp, obj.toString());
        } catch(Exception e){
            e.printStackTrace();
            log = new UpdateErrorLog(e, localIp, null);
        }
        redisService.saveUpdateLog(log.toString());
    }


}
