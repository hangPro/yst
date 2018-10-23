package com.yst.web.controller;
import com.yst.common.bean.PlanLesson;
import com.yst.business.biz.PlanLessonService;
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
@RequestMapping("/planLesson/")
public class PlanLessonController {

    @Autowired
    PlanLessonService planLessonService;

    @RequestMapping("add")
    public ReturnT add(PlanLesson planLesson) {
        planLessonService.save(planLesson);
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    planLessonService.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(PlanLesson planLesson) {
	    planLessonService.update(planLesson);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        PlanLesson planLesson = planLessonService.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(planLesson);
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PlanLesson> list = planLessonService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(PlanLesson planLesson) {
        List<PlanLesson> list = planLessonService.findByObj(planLesson);
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
