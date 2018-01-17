package com.bootdo.model.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "gam_index",type = "accountinfo", shards = 1,replicas = 0, refreshInterval = "-1")
public class Game implements Serializable {

    @Id
    private Long id;

    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String dbId;

    @Field(index = FieldIndex.analyzed, analyzer = "standard", store = true, searchAnalyzer = "standard", type = FieldType.String)
    private String gameName;

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
