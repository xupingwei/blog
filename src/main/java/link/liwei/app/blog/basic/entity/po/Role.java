package link.liwei.app.blog.basic.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import link.liwei.app.blog.basic.entity.BaseEntity;

/**
 * 角色表
 */
@TableName(value = "role")
public class Role extends BaseEntity {

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;
    /**
     * 角色名称
     */
    @TableField(value = "role_name", exist = true)
    private String roleName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标志 1:未删除 0：删除
     */
    @TableField(value = "del_flag", exist = true)
    private Integer delFlag = 0;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
