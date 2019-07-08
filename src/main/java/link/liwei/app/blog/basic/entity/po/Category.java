package link.liwei.app.blog.basic.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import link.liwei.app.blog.basic.entity.BaseEntity;

/**
 * 分类
 */
@TableName(value = "category")
public class Category extends BaseEntity {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;
    @TableField(value = "category_name")
    private String categoryName;   //分类名称
    //    @TableField(value = "article_id")
//    private String articleId;
    private Integer amount;   //文章数量

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
