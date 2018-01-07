package com.bootdo.model.search.service;


import com.bootdo.model.search.entity.Article;

public interface SearchService {

    Article queryAccountInfoById(String id);

    Article queryAccountInfoByName(String accountName);

    Article save(Article article);
}
