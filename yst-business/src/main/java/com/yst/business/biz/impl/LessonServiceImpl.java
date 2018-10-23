package com.yst.business.biz.impl;

import com.yst.business.repository.LessonMapper;
import com.yst.common.bean.Lesson;
import com.yst.business.biz.LessonService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/23.
 */
@Service
public class LessonServiceImpl extends AbstractService<Lesson> implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

}
