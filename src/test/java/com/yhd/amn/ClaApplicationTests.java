package com.yhd.amn;

import com.yhd.amn.bean.Cla;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.service.ClaService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.yhd.amn.mapper")
public class ClaApplicationTests extends BaseController {

    @Autowired
    private ClaService claService;

    /**
     * 测试新增班级
     */
    @Test
    void testAddCla() {
        Cla cla = new Cla();
        cla.setCno(1);
        cla.setCname("高一一班");
        cla.setCaddr("一区A栋教学楼");
        claService.addCla(cla);
    }

}
