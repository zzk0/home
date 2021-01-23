package top.zzk0.api.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Footprint {

    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "url")
    private String url;

    @TableField(value = "elapsed_time")
    private Integer elapsedTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private Date updateTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "deleted_time")
    private Date deletedTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;

    // ----------------------------------  IDEA 自动生成  ----------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Footprint{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", elapsedTime=" + elapsedTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deletedTime=" + deletedTime +
                ", deleted=" + deleted +
                '}';
    }
}
