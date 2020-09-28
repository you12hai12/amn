package com.yhd.amn;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Amn;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.service.AmnService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
class AmnApplicationTests extends BaseController {
    @Autowired
    private AmnService amnService;

    @Test
    @Ignore
    void contextLoads() { //测试新增
        Amn amn = new Amn();
        amn.setName("图标");
        amn.setUrl("http://localhost:8888/amn/img/img.png");
        amnService.addAmn(amn);
        System.out.println(amn.getId());
    }

    @Test
    @Ignore
    void testList() { //测试列表
        Page<Amn> page = getPage();
        page.setCurrent(1);
        page.setSize(10);
        page.setTotal(100);
        Amn amn = new Amn();
        IPage<Amn> list = amnService.getAmnPage(page,amn);
        System.out.println(list);
    }

    @Test
    @Ignore
    void testDetailById() { //测试查询详情
        Integer id = 1;
        Amn amn = amnService.getDetailById(id);
        System.out.println(amn.getName());
        System.out.println(amn.getUrl());
    }

    @Test
    @Ignore
    void testUpdate(){ //测试修改
        Integer id = 7;
        Amn amn = new Amn();
        amn.setId(id);
        amn.setName("动物图");
        amn.setUrl("http://localhost:8080/amn/img/img.png");
        amnService.update(amn);
        System.out.println(amn.getName());
        System.out.println(amn.getUrl());
    }

    @Test
    void testDelete() { //测试删除
        Integer id = 7;
        amnService.delete(id);
        Page<Amn> page = getPage();
        page.setCurrent(1);
        page.setSize(10);
        page.setTotal(100);
        Amn amn = new Amn();
        IPage<Amn> list = amnService.getAmnPage(page,amn);
        System.out.println(list.getTotal());
    }
}
