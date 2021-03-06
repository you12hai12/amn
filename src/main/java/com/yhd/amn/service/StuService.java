package com.yhd.amn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhd.amn.bean.Stu;

/**
 * 学生
 */
public interface StuService extends IService<Stu> {
    /**
     * 新增学生
     * @param stu
     * @return
     */
    void addStu(Stu stu);
}
