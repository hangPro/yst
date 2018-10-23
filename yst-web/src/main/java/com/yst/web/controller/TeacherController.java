package com.yst.web.controller;
import com.yst.common.bean.Teacher;
import com.yst.business.biz.TeacherService;
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
@RequestMapping("/teacher/")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("add")
    public ReturnT add(Teacher teacher) {
        teacherService.save(teacher);
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    teacherService.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(Teacher teacher) {
	    teacherService.update(teacher);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        Teacher teacher = teacherService.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(teacher);
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Teacher> list = teacherService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(Teacher teacher) {
        List<Teacher> list = teacherService.findByObj(teacher);
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
