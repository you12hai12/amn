package com.yhd.amn.controller;

import com.yhd.amn.bean.Stu;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.view.R;
import com.yhd.amn.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StuController extends BaseController {

    @Autowired
    private StuService stuService;

    /**
     * 新增学生
     * @param stu
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addStu(@Validated(Create.class) @RequestBody Stu stu){
        return stuService.addStu(stu);
    }
}
