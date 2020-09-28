package com.yhd.amn;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.User;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.utils.DateUtil;
import com.yhd.amn.service.UserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户测试类
 */
@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
public class UserApplicationTests extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 测试新增用户
     */
    @Test
    @Ignore
    void testAddUser() {
        User user = new User();
        user.setUno(3);
        user.setUname("张飒1");
        user.setIno("421126199202124125");
        user.setBirth(DateUtil.fomatDate("1992-02-12"));
        user.setUage(28);
        user.setUsex(0);
        user.setMobile("13956232145");
        user.setAddr("湖南省长沙市");
        user.setRemark("新增用户");
        userService.addUser(user);
        System.out.println(user.getId());
    }

    /**
     * 测试列表
     */
    @Test
    void testUserList() {
        Page<User> page = getPage();
        page.setCurrent(1);
        page.setSize(10);
        page.setTotal(100);
        User user = new User();
        IPage<User> list = userService.getUserPage(page,user);
        System.out.println(list.getTotal());
    }

    @Test
    void testDetailByUno() { //测试查询详情
        Integer uno = 1;
        User user = userService.getDetailByUno(uno);
        System.out.println(user.getUname());
    }

    @Test
    void testEditUser() { //测试修改
        User user = new User();
        user.setId(3);
        user.setUno(3);
        user.setUname("李磊");
        user.setIno("421125199006255263");
        user.setBirth(DateUtil.fomatDate("1990-06-25"));
        user.setUage(30);
        user.setUsex(1);
        user.setMobile("13956232145");
        user.setAddr("湖南省长沙市");
        user.setRemark("修改用户");
        userService.update(user);
    }

    @Test
    void testDeleteUser() { //测试删除
        Integer uno = 3;
        userService.delete(uno);
    }

}
