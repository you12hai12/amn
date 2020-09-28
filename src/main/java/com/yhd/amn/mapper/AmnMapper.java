package com.yhd.amn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.Amn;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface AmnMapper extends BaseMapper<Amn> {

    /**
     * 查询列表
     * @param page
     * @param amn
     * @return
     */
    IPage<Amn> getAmnPage(@Param("page") Page<Amn> page, @Param("amn") Amn amn);

    /**
     * 根据ID查询详情
     * @param id
     * @return
     */
    Amn getDetailById(Integer id);
}
