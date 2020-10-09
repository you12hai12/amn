package com.yhd.amn;

import com.yhd.amn.bean.Teacher;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.utils.DateUtil;
import com.yhd.amn.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
public class TeacherApplicationTests extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @Test
    void testAddTeacher() { //测试新增
        Teacher t = new Teacher();
        t.setTno(5);
        t.setTle(1);
        t.setUname("李磊");
        t.setUage(30);
        t.setUsex(1);
        t.setIno("421126199403144125");
        t.setBirth(DateUtil.fomatDate("1994-03-14"));
        t.setMobile("13696532145");
        t.setAddr("湖北省武汉市洪山区");
        t.setRemark("新增用户");
        System.out.println(t.getTno());
        teacherService.addTeacher(t);
    }
}
