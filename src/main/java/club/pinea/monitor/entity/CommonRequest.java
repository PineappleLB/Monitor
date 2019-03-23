package club.pinea.monitor.entity;

/**
 * 公共的请求参数
 *
 * @author pineapple
 * @create 2019/3/23
 */
public class CommonRequest {

    private String loginToken = "88295,37f9ef8c6d0ee501faf74f25fd99d39f";

    private String format = "json";

    private String lang = "en";

    private String errorOnEmpty = "no";

    private Integer userId = null;

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getErrorOnEmpty() {
        return errorOnEmpty;
    }

    public void setErrorOnEmpty(String errorOnEmpty) {
        this.errorOnEmpty = errorOnEmpty;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
