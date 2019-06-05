package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : TenYun
 * @date : 2019-06-05 16:20
 * @description :
 **/

public interface ArticleDao extends ElasticsearchRepository<Article, String> {
}
