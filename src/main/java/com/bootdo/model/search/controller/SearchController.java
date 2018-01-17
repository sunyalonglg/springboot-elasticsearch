package com.bootdo.model.search.controller;

import com.bootdo.model.search.entity.Game;
import com.bootdo.model.search.service.SearchService;
import com.bootdo.model.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试搜索的基本功能
 *
 * @author sunYaLong
 * @version 1.0 2018-1-17 23:14:22
 */
@RestController
@RequestMapping("search")
public class SearchController {

    /** 搜索service */
    @Autowired
    private SearchService searchService;

    /** 初始化数据service */
    @Autowired
    private UserService userService;

    /**
     * 通过游戏id查询
     *
     * @param game 游戏名称
     * @return
     */
    @RequestMapping(value = "/findByGameName",produces = { "application/json;charset=UTF-8" })
    public Object findByGameName(Game game){
        List<Game> byGameName = searchService.findByGameName(game);
        return byGameName;
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Object queryAccountInfo(Long id){
        return searchService.findById(id);
    }

    /**
     * 通过数据库id查询
     *
     * @param game
     * @return
     */
    @RequestMapping("/findByDbId")
    public Object findByDbId(Game game){
        return searchService.findByDbId(game);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @GetMapping("del")
    public Object del(Long id) {
        try {
            searchService.delete(id);
            return 200;
        }catch (Exception e) {
            return 500;
        }
    }

    /**
     * 保存数据到索引库
     *
     * @param article
     * @return
     */
    @RequestMapping("/save")
    public Object save(Game article){
        return searchService.save(article);
    }

    /**
     * 将数据库的数据同步到索引库
     *
     * @return
     */
    @RequestMapping("sync")
    public Object sync(Map map) {
        Map result = new HashMap();
        long total = 0L;
        List list = userService.findById(map);
        for(Object ls:list) {
            Map s = (Map) ls;
            Long id = new Date().getTime()+s.hashCode()+Math.round(5);
            Game game = new Game();
            game.setId(id);
            game.setDbId((String) s.get("id"));
            game.setGameName((String) s.get("game_name"));
            searchService.save(game);
            total++;
        }
        result.put("total",total);
        return result;
    }




}
