package com.bootdo.model.search.dao;

import com.bootdo.model.search.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索dao
 */
public interface SearchDao extends ElasticsearchRepository<Article,String> {

    Article findByAccountName(String accountName);
}
