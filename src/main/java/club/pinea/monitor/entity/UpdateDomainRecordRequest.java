package club.pinea.monitor.entity;

/**
 * 修改域名解析记录值的请求实体
 *
 * @author pineapple
 * @create 2019/3/23
 */
public class UpdateDomainRecordRequest extends CommonRequest{

    /**
     * pinea.club
     */
    private Integer domainId = 61501618;

    /**
     * home.pinea.club
     */
    private Integer recordId = 413266028;

    private String subDomain = "home";

    private String recordType = "A";

    private String recordLine = "默认";

    private Integer recordLineId = 0;

    private String value = null;

    private Integer mx;

    private Integer ttl;

    private String status;

    /**
     * 企业用户可使用
     */
    private Integer weight;

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordLine() {
        return recordLine;
    }

    public void setRecordLine(String recordLine) {
        this.recordLine = recordLine;
    }

    public Integer getRecordLineId() {
        return recordLineId;
    }

    public void setRecordLineId(Integer recordLineId) {
        this.recordLineId = recordLineId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMx() {
        return mx;
    }

    public void setMx(Integer mx) {
        this.mx = mx;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
