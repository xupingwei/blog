package link.liwei.app.blog.admin.controller;

import link.liwei.app.blog.admin.service.ArticleService;
import link.liwei.app.blog.basic.entity.ResultBean;
import link.liwei.app.blog.basic.entity.po.Article;
import link.liwei.app.blog.basic.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/admin/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/create")
    public ResultBean create(@RequestParam("brief") String brief,
                             @RequestParam("author") String author,
                             @RequestParam("content") String content,
                             @RequestParam("keyWords") String keyWords,
                             @RequestParam("classify") String classify) {

        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(author)) {
            return ResultUtils.failure("文章内容或作者不能为空");
        }
        Article article = new Article(brief, content, author, keyWords, classify);
        article.setCreateTime(new Date(System.currentTimeMillis()));
        article.setUpdateTime(new Date(System.currentTimeMillis()));
        article.setPubTime(new Date(System.currentTimeMillis()));
        return ResultUtils.success(articleService.create(article));

    }
}
