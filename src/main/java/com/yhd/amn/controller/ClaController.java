package com.yhd.amn.controller;

import com.yhd.amn.bean.Cla;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.view.R;
import com.yhd.amn.service.ClaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 班级
 */
@RestController
@RequestMapping("/cla")
public class ClaController extends BaseController {

    @Autowired
    private ClaService claService;

    /**
     * 新增班级
     * @param cla
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addCla(@Validated(Create.class) @RequestBody Cla cla){
        claService.addCla(cla);
        return R.okMsg(R.ADD_SUC);
    }
}
