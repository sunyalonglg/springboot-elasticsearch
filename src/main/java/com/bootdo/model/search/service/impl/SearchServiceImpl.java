package com.bootdo.model.search.service.impl;

import com.bootdo.model.search.dao.SearchDao;
import com.bootdo.model.search.entity.Game;
import com.bootdo.model.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchDao searchDao;

    @Override
    public Game findById(Long id) {
        return searchDao.findOne(id);
    }

    @Override
    public Game save(Game article) {
        Game save = searchDao.save(article);
        return save;
    }
}
