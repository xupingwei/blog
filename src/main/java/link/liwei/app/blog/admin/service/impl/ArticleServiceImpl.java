package link.liwei.app.blog.admin.service.impl;

import link.liwei.app.blog.admin.service.ArticleService;
import link.liwei.app.blog.basic.dao.ArticleDao;
import link.liwei.app.blog.basic.entity.po.Article;
import link.liwei.app.blog.basic.exce.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public int create(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public Article update(Article article) {

        Long id = article.getArticleId();

        if (id == 0) {
            throw new BusinessException("文章ID缺失，更新失败");
        }

        int i = articleDao.updateById(article);
        if (i > 0) {
//            QueryWrapper articleWrapper = new QueryWrapper<Article>();
//            articleWrapper.eq("article_id", id);
            return articleDao.selectById(id);

        }
        throw new BusinessException("文章更新失败");
    }

    @Override
    public int deleteById(Long articleId) {

        if (articleId == 0) {
            throw new BusinessException("文章ID缺失，删除失败");
        }
        int i = articleDao.deleteById(articleId);

        if (i > 0) {
            return i;

        }
        throw new BusinessException("文章删除失败");
    }
}
