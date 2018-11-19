package com.yst.business.biz.impl;

import com.yst.business.repository.PlanLessonMapper;
import com.yst.common.bean.PlanLesson;
import com.yst.business.biz.PlanLessonService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/24.
 */
@Service
public class PlanLessonServiceImpl extends AbstractService<PlanLesson> implements PlanLessonService {

    @Autowired
    private PlanLessonMapper planLessonMapper;

}
