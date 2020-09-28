package com.yhd.amn.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 学生
 */
@Data
@TableName("t_stu")
public class Stu {
    //ID
    @TableId
    private Integer sid;

    //学号
    private Integer sno;

    //语文
    private BigDecimal sch;

    //数学
    private BigDecimal sma;

    //英语
    private BigDecimal sen;

    //班级
    private Integer sclass;

    //老师
    private Integer steacher;

    //学生姓名
    @TableField(exist = false)
    private String uname;

    //身份证号
    @TableField(exist = false)
    private String ino;

    //出生日期
    @TableField(exist = false)
    private Date birth;

    //年龄
    @TableField(exist = false)
    private Integer uage;

    //性别
    @TableField(exist = false)
    private Integer usex;

    //手机号
    @TableField(exist = false)
    private String mobile;

    //住址
    @TableField(exist = false)
    private String addr;

    //备注
    @TableField(exist = false)
    private String remark;
}
