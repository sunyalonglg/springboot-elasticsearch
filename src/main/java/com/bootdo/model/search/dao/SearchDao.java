package com.bootdo.model.search.dao;

import com.bootdo.model.search.entity.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索dao
 */
public interface SearchDao extends ElasticsearchRepository<Game,Long> {


}
