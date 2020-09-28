package com.yhd.amn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Sys;
import com.yhd.amn.common.view.R;
import com.yhd.amn.mapper.SysMapper;
import com.yhd.amn.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysMapper sysMapper;

    /**
     * 新增系统
     * @param sys
     * @return
     */
    @Override
    public R addSys(Sys sys) {
        sysMapper.insert(sys);
        return R.okMsg(R.ADD_SUC);
    }

    /**
     * 查询系统列表
     * @param page 分页
     * @param sys  系统
     * @return
     */
    @Override
    public IPage<Sys> getSysPage(Page<Sys> page, Sys sys) {
        return sysMapper.getSysPage(page,sys);
    }

    /**
     * 根据系统编号查询详情
     * @param sno
     * @return
     */
    @Override
    public Sys getDetailBySno(Integer sno) {
        return sysMapper.getDetailById(sno);
    }

    /**
     * 修改系统
     * @param sys
     */
    @Override
    public void update(Sys sys) {
        sysMapper.updateById(sys);
    }

    /**
     * 删除系统
     * @param sno
     * @return
     */
    @Override
    public Integer delete(Integer sno) {
        return sysMapper.deleteById(sno);
    }
}
