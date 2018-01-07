package com.bootdo.model.search.service.impl;

import com.bootdo.model.search.dao.SearchDao;
import com.bootdo.model.search.entity.Article;
import com.bootdo.model.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchDao searchDao;

    @Override
    public Article queryAccountInfoById(String id) {
        return searchDao.findOne(id);
    }

    @Override
    public Article queryAccountInfoByName(String accountName) {
        return searchDao.findByAccountName(accountName);
    }

    @Override
    public Article save(Article article) {
        Article save = searchDao.save(article);
        return save;
    }
}
