package com.yst.web.controller;
import com.yst.common.bean.Score;
import com.yst.business.biz.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yst.common.response.ReturnT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by hang on 2018/10/23.
 */
@RestController
@RequestMapping("/score/")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("add")
    public ReturnT add(Score score) {
        scoreService.save(score);
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    scoreService.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(Score score) {
	    scoreService.update(score);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        Score score = scoreService.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(score);
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Score> list = scoreService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(Score score) {
        List<Score> list = scoreService.findByObj(score);
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
