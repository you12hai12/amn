package com.yhd.amn.service.impl;

import com.yhd.amn.bean.Cla;
import com.yhd.amn.mapper.ClaMapper;
import com.yhd.amn.service.ClaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 班级
 */
@Service
public class ClaServiceImpl implements ClaService {

    @Autowired
    private ClaMapper claMapper;

    /**
     * 新增班级
     * @param cla
     */
    @Override
    public void addCla(Cla cla) {
        claMapper.insert(cla);
    }
}
