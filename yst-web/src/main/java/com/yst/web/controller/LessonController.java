package com.yst.web.controller;
import com.yst.common.bean.Lesson;
import com.yst.business.biz.LessonService;
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
@RequestMapping("/lesson/")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @RequestMapping("add")
    public ReturnT add(Lesson lesson) {
        lessonService.save(lesson);
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    lessonService.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(Lesson lesson) {
	    lessonService.update(lesson);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        Lesson lesson = lessonService.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(lesson);
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Lesson> list = lessonService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(Lesson lesson) {
        List<Lesson> list = lessonService.findByObj(lesson);
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
