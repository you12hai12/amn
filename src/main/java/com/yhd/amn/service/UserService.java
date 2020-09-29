package com.yhd.amn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.User;
import com.yhd.amn.common.view.R;

/**
 * 用户
 */
public interface UserService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 用户列表
     * @param page
     * @param user
     * @return
     */
    IPage<User> getUserPage(Page<User> page, User user);

    /**
     * 根据用户编号查详情
     * @param uno
     * @return
     */
    User getDetailByUno(Integer uno);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param uno
     * @return
     */
    Integer delete(Integer uno);
}
