package com.yhd.amn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Amn;
import com.yhd.amn.mapper.AmnMapper;
import com.yhd.amn.service.AmnService;
import com.yhd.amn.common.view.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查看文件
 */
@Service
public class AmnServiceImpl implements AmnService {

    @Autowired
    private AmnMapper amnMapper;

    //新增
    @Override
    public R addAmn(Amn amn) {
        amnMapper.insert(amn);
        return R.okMsg(R.ADD_SUC);
    }

    //查询列表
    @Override
    public IPage<Amn> getAmnPage(Page<Amn> page, Amn amn) {
        return amnMapper.getAmnPage(page,amn);
    }

    //根据ID查询详情
    @Override
    public Amn getDetailById(Integer id) {
        return amnMapper.getDetailById(id);
    }

    //修改
    @Override
    public void update(Amn amn) {
        amnMapper.updateById(amn);
    }

    //删除
    @Override
    public Integer delete(Integer id) {
        return amnMapper.deleteById(id);
    }

}
