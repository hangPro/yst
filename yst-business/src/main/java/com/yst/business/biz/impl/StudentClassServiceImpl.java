package com.yst.business.biz.impl;

import com.yst.business.repository.StudentClassMapper;
import com.yst.common.bean.StudentClass;
import com.yst.business.biz.StudentClassService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/23.
 */
@Service
public class StudentClassServiceImpl extends AbstractService<StudentClass> implements StudentClassService {

    @Autowired
    private StudentClassMapper studentClassMapper;

}
