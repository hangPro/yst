package com.yst.business.biz.impl;

import com.yst.business.repository.TeacherMapper;
import com.yst.common.bean.Teacher;
import com.yst.business.biz.TeacherService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/23.
 */
@Service
public class TeacherServiceImpl extends AbstractService<Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

}
