package link.liwei.app.blog.basic.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import link.liwei.app.blog.basic.entity.BaseEntity;

/**
 * 用户表
 */
@TableName(value = "user")
public class User extends BaseEntity {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * exist: 是否为数据库字段
     */
    @TableField(value = "user_name", exist = true)
    private String userName;
    private String email;
    private String phone;
    private String password;
    /**
     * 性别 0：男  1：女  2：未知
     */
    private Integer gender;
    /**
     * 删除标志 1:未删除 0：删除
     */
    @TableField(value = "del_flag", exist = true)
    private Integer delFlag;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
