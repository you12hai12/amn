package com.yhd.amn;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Sys;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.service.SysService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 系统
 */
@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
public class SysApplicationTests extends BaseController {

    @Autowired
    private SysService sysService;

    @Test
    @Ignore
    public void testAddSys(){ //测试系统新增
        Sys sys = new Sys();
        sys.setSno(4);
        sys.setSname("CentOS8操作系统");
        sys.setSversion("Linux");
        sys.setSremark("正在升级中");
        sysService.addSys(sys);
    }

    @Test
    @Ignore
    void testList() { //测试列表
        Page<Sys> page = getPage();
        page.setCurrent(1);
        page.setSize(10);
        page.setTotal(100);
        Sys sys = new Sys();
        IPage<Sys> list = sysService.getSysPage(page,sys);
        System.out.println(list.getTotal());
    }

    @Test
    @Ignore
    void testSysDetailBySno(){ //测试查看详情
        Integer sno = 1;
        Sys sys = sysService.getDetailBySno(sno);
        System.out.println(sys.getSid());
        System.out.println(sys.getSno());
        System.out.println(sys.getSname());
        System.out.println(sys.getSversion());
        System.out.println(sys.getSremark());
    }

    @Test
    @Ignore
    void testEditSys() { //测试修改
        Sys sys = new Sys();
        sys.setSid(3);
        sys.setSno(3);
        sys.setSname("Windows10操作系统");
        sys.setSversion("Windows10");
        sys.setSremark("现在正在使用");
        sysService.update(sys);
    }

    @Test
    void testDeleteSys() {
        Integer sno = 4;
        sysService.delete(sno);
    }
}
