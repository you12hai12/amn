package com.yhd.amn.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 班级实体类
 */
@Data
@TableName("t_cla")
public class Cla {
    //ID
    private Integer cid;

    //班级号
    private Integer cno;

    //班级名称
    private String cname;

    //班级位置
    private String caddr;

}
