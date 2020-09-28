package com.yhd.amn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Sys;
import org.apache.ibatis.annotations.Param;

/**
 * 系统
 */
public interface SysMapper extends BaseMapper<Sys> {
    /**
     * 查询系统列表
     * @param page
     * @param sys
     * @return
     */
    IPage<Sys> getSysPage(@Param("page") Page<Sys> page, @Param("sys") Sys sys);

    /**
     * 根据系统编号查询详情
     * @param sno
     * @return
     */
    Sys getDetailById(Integer sno);
}
