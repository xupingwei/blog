package link.liwei.app.blog.basic.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import link.liwei.app.blog.basic.entity.BaseEntity;

import java.util.Date;

/**
 * 文章
 */
@TableName(value = "article")
public class Article extends BaseEntity {

    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;
    private Integer comment;   //评论
    private Integer browse;  //浏览
    private Integer like;  //点赞
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date pubTime;  //发布时间
    private String brief;  //文章简介
    private String content;  //文章内容
    private String author;  //作者
    @TableField(value = "key_word")
    private String keyWords;  //文章关键字
    private String classify;  //文章分类
    /**
     * 删除标志 1:未删除 0：删除
     */
    @TableField(value = "del_flag", exist = true)
    private Integer delFlag = 1;

    public Article() {
    }

    public Article(String brief, String content, String author, String keyWords, String classify) {
        this.brief = brief;
        this.content = content;
        this.author = author;
        this.keyWords = keyWords;
        this.classify = classify;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
