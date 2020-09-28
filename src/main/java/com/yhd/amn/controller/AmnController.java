package com.yhd.amn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Amn;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.valid.Update;
import com.yhd.amn.service.AmnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.yhd.amn.common.view.R;
import org.springframework.web.bind.annotation.*;

/**
 * 文件上传、查询列表、修改和删除
 */
@RestController
@RequestMapping("/amn")
public class AmnController extends BaseController {

    @Autowired
    private AmnService amnService;

    /**
     * 新增
     * @param amn
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addAmn(@Validated(Create.class) @RequestBody Amn amn){
        return amnService.addAmn(amn);
    }

    /**
     * 查询列表
     * @param name
     * @param url
     * @return
     */
    @GetMapping()
    @RequestMapping("/list")
    public R<IPage<Amn>> getCanPage(@RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "url",required = false) String url){
        Page<Amn> page = getPage();
        Amn amn = new Amn();
        amn.setName(name);
        amn.setUrl(url);
        IPage<Amn> canPage = amnService.getAmnPage(page,amn);
        return R.ok(canPage);
    }

    /**
     * 根据ID查询详情
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public R getDetailById(@PathVariable(value = "id") Integer id){
        Amn amn = amnService.getDetailById(id);
        return R.ok(amn);
    }

    /**
     * 修改
     * @param amn
     * @return
     */
    @PutMapping("edit")
    public R updateAmn(@Validated(Update.class) @RequestBody Amn amn){
        amnService.update(amn);
        return R.okMsg(R.UPDATE_SUC);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R deleteById(@PathVariable(value = "id") Integer id) {
        amnService.delete(id);
        return R.okMsg(R.DEL_SUC);
    }
}
