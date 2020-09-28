package com.yhd.amn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Amn;
import com.yhd.amn.common.view.R;

/**
 * 查看文件
 */
public interface AmnService {
    //上传文件
    R addAmn(Amn amn);

    //查询列表
    IPage<Amn> getAmnPage(Page<Amn> page, Amn amn);

    //根据id查询详情
    Amn getDetailById(Integer id);

    //修改
    void update(Amn amn);

    //删除
    Integer delete(Integer id);
}
