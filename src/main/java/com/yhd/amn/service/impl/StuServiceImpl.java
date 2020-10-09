package com.yhd.amn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhd.amn.bean.Stu;
import com.yhd.amn.bean.User;
import com.yhd.amn.mapper.StuMapper;
import com.yhd.amn.service.StuService;
import com.yhd.amn.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生
 */
@Service
public class StuServiceImpl extends ServiceImpl<StuMapper, Stu> implements StuService {

    @Autowired
    private UserService userService;

    /**
     * 新增学生
     * @param stu
     * @return
     */
    @Override
    public void addStu(Stu stu) {
        User u = new User();
        Stu s = new Stu();
        BeanUtils.copyProperties(stu, u);
        BeanUtils.copyProperties(stu, s);
        userService.addUser(u);
        u.setUno(u.getId());
        userService.update(u);
        s.setSno(u.getUno());
        this.save(stu);
    }
}
