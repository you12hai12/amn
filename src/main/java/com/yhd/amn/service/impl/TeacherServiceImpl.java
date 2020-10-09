package com.yhd.amn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhd.amn.bean.Teacher;
import com.yhd.amn.bean.User;
import com.yhd.amn.mapper.TeacherMapper;
import com.yhd.amn.service.TeacherService;
import com.yhd.amn.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 老师
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private UserService userService;

    /**
     * 新增老师
     * @param teacher
     */
    @Override
    public void addTeacher(Teacher teacher) {
        User u = new User();
        Teacher t = new Teacher();
        BeanUtils.copyProperties(teacher, u);
        BeanUtils.copyProperties(teacher, t);
        userService.addUser(u);
        u.setUno(u.getId());
        userService.update(u);
        t.setTno(u.getUno());
        this.save(t);
    }
}
