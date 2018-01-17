package com.bootdo.model.search.dao;

import com.bootdo.model.search.entity.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 搜索dao
 */
public interface SearchDao extends ElasticsearchRepository<Game,Long> {

    Game findByDbId(String dbId);

    List<Game> findByGameName(String gameName);
}
