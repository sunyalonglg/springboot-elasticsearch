package com.bootdo.model.search.service;


import com.bootdo.model.search.entity.Game;

public interface SearchService {

    Game findById(Long id);

    Game save(Game article);
}
