package com.bootdo.model.search.controller;

import com.bootdo.model.search.entity.Article;
import com.bootdo.model.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/findById")
    public Object queryAccountInfo(String id){
        return searchService.queryAccountInfoById(id);
    }

    @RequestMapping("/save")
    public Object save(Article article){
        return searchService.save(article);
    }


}
