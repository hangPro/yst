package com.yst.business.biz.impl;

import com.yst.business.repository.SchoolMapper;
import com.yst.common.bean.School;
import com.yst.business.biz.SchoolService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/30.
 */
@Service
public class SchoolServiceImpl extends AbstractService<School> implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

}
