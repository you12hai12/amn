package com.yhd.amn.service.impl;

import com.yhd.amn.bean.Stu;
import com.yhd.amn.mapper.StuMapper;
import com.yhd.amn.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    /**
     * 新增学生
     * @param stu
     * @return
     */
    @Override
    public void addStu(Stu stu) {
        stuMapper.insert(stu);
    }
}
