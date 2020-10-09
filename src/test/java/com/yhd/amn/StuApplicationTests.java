package com.yhd.amn;

import com.yhd.amn.bean.Stu;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.utils.DateUtil;
import com.yhd.amn.service.StuService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * 测试学生类方法
 */
@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
public class StuApplicationTests extends BaseController {

    @Autowired
    private StuService stuService;

    @Test
    void testAddStu() {
        Stu s = new Stu();
        s.setSno(4);
        s.setSch(new BigDecimal(89));
        s.setSma(new BigDecimal(90));
        s.setSen(new BigDecimal(87));
        s.setSclass(1);
        s.setSteacher(1);
        s.setUname("张思");
        s.setUage(26);
        s.setUsex(1);
        s.setIno("421126199403144125");
        s.setBirth(DateUtil.fomatDate("1994-03-14"));
        s.setMobile("13696532145");
        s.setAddr("湖北省武汉市洪山区");
        s.setRemark("新增用户");
        stuService.addStu(s);
    }
}
