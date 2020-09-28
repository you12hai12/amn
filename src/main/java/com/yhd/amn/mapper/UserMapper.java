package com.yhd.amn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户列表
     * @param page
     * @param user
     * @return
     */
    IPage<User> getUserPage(@Param("page") Page<User> page, @Param("user") User user);

    /**
     * 根据用户编号查详情
     * @param uno
     * @return
     */
    User getDetailById(Integer uno);
}
