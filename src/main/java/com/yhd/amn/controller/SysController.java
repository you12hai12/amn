package com.yhd.amn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Sys;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.valid.Update;
import com.yhd.amn.common.view.R;
import com.yhd.amn.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统
 */
@RestController
@RequestMapping("/sys")
public class SysController extends BaseController {

    @Autowired
    private SysService sysService;

    /**
     * 新增系统
     * @param sys 系统实体参数
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addSys(@Validated(Create.class) @RequestBody Sys sys) {
        return sysService.addSys(sys);
    }

    /**
     * 查询系统列表
     * @param sno
     * @param sname
     * @param sversion
     * @param sremark
     * @return
     */
    @GetMapping()
    @RequestMapping("/list")
    public R<IPage<Sys>> getSysPage(@RequestParam(value = "sno",required = false) Integer sno,
                                    @RequestParam(value = "sname",required = false) String sname,
                                    @RequestParam(value = "sversion",required = false) String sversion,
                                    @RequestParam(value = "sremark",required = false) String sremark){
        Page<Sys> page = getPage();
        Sys sys = new Sys();
        sys.setSno(sno);
        sys.setSname(sname);
        sys.setSversion(sversion);
        sys.setSremark(sremark);
        IPage<Sys> sysPage = sysService.getSysPage(page,sys);
        return R.ok(sysPage);
    }

    /**
     * 根据系统编号查询详情
     * @param sno
     * @return
     */
    @GetMapping("detail/{sno}")
    public R getDetailById(@PathVariable(value = "sno") Integer sno){
        Sys sys = sysService.getDetailBySno(sno);
        return R.ok(sys);
    }

    /**
     * 修改系统
     * @param sys
     * @return
     */
    @PutMapping("edit")
    public R updateSys(@Validated(Update.class) @RequestBody Sys sys){
        sysService.update(sys);
        return R.okMsg(R.UPDATE_SUC);
    }

    /**
     * 删除系统
     * @param sno
     * @return
     */
    @DeleteMapping("delete/{sno}")
    public R deleteSys(@PathVariable(value = "sno") Integer sno) {
        sysService.delete(sno);
        return R.okMsg(R.DEL_SUC);
    }
}
