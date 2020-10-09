package com.yhd.amn.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_tea")
public class Teacher {

    //ID
    @TableId
    private Integer tid;

    //工号
    private Integer tno;

    //等级
    private Integer tle;

    //老师姓名
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
