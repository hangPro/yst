package com.yst.business.biz.impl;

import com.yst.business.repository.ScoreMapper;
import com.yst.common.bean.Score;
import com.yst.business.biz.ScoreService;
import com.yst.business.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hang on 2018/10/23.
 */
@Service
public class ScoreServiceImpl extends AbstractService<Score> implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

}
