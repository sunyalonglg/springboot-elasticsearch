package com.bootdo.model.search.service;


import com.bootdo.model.search.entity.Game;

import java.util.List;

public interface SearchService {

    Game findById(Long id);

    Game save(Game article);

    void delete(Long id);

    Game findByDbId(Game game);

    List<Game> findByGameName(Game game);
}
