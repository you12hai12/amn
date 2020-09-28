package com.yhd.amn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.User;
import com.yhd.amn.common.view.R;
import com.yhd.amn.mapper.UserMapper;
import com.yhd.amn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public R addUser(User user) {
        userMapper.insert(user);
        return R.okMsg(R.ADD_SUC);
    }

    /**
     * 用户列表
     * @param page
     * @param user
     * @return
     */
    @Override
    public IPage<User> getUserPage(Page<User> page, User user) {
        return userMapper.getUserPage(page,user);
    }

    /**
     * 根据用户编号查详情
     * @param uno
     * @return
     */
    @Override
    public User getDetailByUno(Integer uno) {
        return userMapper.getDetailById(uno);
    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }

    /**
     * 删除用户
     * @param uno
     * @return
     */
    @Override
    public Integer delete(Integer uno) {
        return userMapper.deleteById(uno);
    }
}
