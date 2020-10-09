package com.yhd.amn.controller;

import com.yhd.amn.bean.Teacher;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.view.R;
import com.yhd.amn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 老师
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 新增老师
     * @param teacher
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addStu(@Validated(Create.class) @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return R.okMsg(R.ADD_SUC);
    }
}
