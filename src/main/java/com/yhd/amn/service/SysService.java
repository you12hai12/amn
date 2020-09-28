package com.yhd.amn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Sys;
import com.yhd.amn.common.view.R;

/**
 * 系统
 */
public interface SysService {
    /**
     * 新增
     * @param sys
     * @return
     */
    R addSys(Sys sys);

    /**
     * 查询系统列表
     * @param page 分页
     * @param sys  系统
     * @return
     */
    IPage<Sys> getSysPage(Page<Sys> page, Sys sys);

    /**
     * 根据系统编号查询详情
     * @param sno
     * @return
     */
    Sys getDetailBySno(Integer sno);

    /**
     * 修改系统
     * @param sys
     */
    void update(Sys sys);

    /**
     * 删除系统
     * @param sno
     * @return
     */
    Integer delete(Integer sno);
}
