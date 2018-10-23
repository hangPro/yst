package com.yst.web.controller;
import com.yst.common.bean.StudentClass;
import com.yst.business.biz.StudentClassService;
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
@RequestMapping("/studentClass/")
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @RequestMapping("add")
    public ReturnT add(StudentClass studentClass) {
        studentClassService.save(studentClass);
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    studentClassService.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(StudentClass studentClass) {
	    studentClassService.update(studentClass);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        StudentClass studentClass = studentClassService.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(studentClass);
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StudentClass> list = studentClassService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(StudentClass studentClass) {
        List<StudentClass> list = studentClassService.findByObj(studentClass);
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
