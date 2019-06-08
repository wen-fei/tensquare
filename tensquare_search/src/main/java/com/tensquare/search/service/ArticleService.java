package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author : TenYun
 * @date : 2019-06-05 16:20
 * @description :
 **/
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

//    @Autowired
//    private IdWorker idWorker;

    public void save(Article article) {
        //article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }


    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return articleDao.findByTitleOrContentLike(keywords, keywords, pageable);
    }
}
