package link.liwei.app.blog.basic.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户角色关联表
 */
@TableName(value = "user_role")
public class UserRole {

    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "role_id")
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
