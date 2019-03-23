package club.pinea.monitor.entity;

/**
 * @author pineapple
 * @create 2019/3/23
 */
public class UpdateErrorLog {

    private Long time;

    private String localIp;

    private String reason;

    private String httpRes;

    @Override
    public String toString() {
        return "UpdateErrorLog:{" +
                "time:" + time +
                ", localIp:'" + localIp + '\'' +
                ", reason:'" + reason + '\'' +
                ", httpRes:'" + httpRes + '\'' +
                '}';
    }

    public UpdateErrorLog() {
    }

    public UpdateErrorLog(Exception e) {
        this(e, null);
    }

    public UpdateErrorLog(Exception e, String ip) {
        this(e, ip, null);
    }

    public UpdateErrorLog(Exception e, String ip, String httpRes) {
        this.time = System.currentTimeMillis();
        if(e != null) {
            this.reason = e.getMessage();
        }
        this.httpRes = httpRes;
        this.localIp = ip;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getHttpRes() {
        return httpRes;
    }

    public void setHttpRes(String httpRes) {
        this.httpRes = httpRes;
    }
}
