package link.liwei.app.blog.admin.service;

import link.liwei.app.blog.basic.entity.po.Article;

public interface ArticleService {

    int create(Article article);

    Article update(Article article);

    int deleteById(Long articleId);
}
