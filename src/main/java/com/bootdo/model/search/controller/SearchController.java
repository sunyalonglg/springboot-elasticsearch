package com.bootdo.model.search.controller;

import com.bootdo.model.search.entity.Game;
import com.bootdo.model.search.service.SearchService;
import com.bootdo.model.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;
    
    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public Object queryAccountInfo(Long id){
        return searchService.findById(id);
    }

    @RequestMapping("/save")
    public Object save(Game article){
        return searchService.save(article);
    }

    @RequestMapping("sync")
    public Object sync(Map map) {
        Map result = new HashMap();
        List list = userService.findById(map);
        for(Object ls:list) {
            Map s = (Map) ls;
            Long id = new Date().getTime()+s.hashCode()+Math.round(5);
            Game game = new Game();
            game.setId(id);
            game.setGameName((String) s.get("game_name"));
            searchService.save(game);
        }

        return result;
    }




}
