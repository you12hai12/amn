package com.yhd.amn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhd.amn.bean.User;
import com.yhd.amn.common.base.BaseController;
import com.yhd.amn.common.valid.Create;
import com.yhd.amn.common.valid.Update;
import com.yhd.amn.common.view.R;
import com.yhd.amn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addUser(@Validated(Create.class) @RequestBody User user){
        userService.addUser(user);
        return R.okMsg(R.ADD_SUC);
    }

    /**
     * 用户列表
     * @param uno
     * @param uname
     * @return
     */
    @GetMapping()
    @RequestMapping("/list")
    public R<IPage<User>> getUserPage(@RequestParam(value = "uno",required = false) Integer uno,
                                    @RequestParam(value = "uname",required = false) String uname){
        Page<User> page = getPage();
        User user = new User();
        user.setUno(uno);
        user.setUname(uname);
        IPage<User> userPage = userService.getUserPage(page,user);
        return R.ok(userPage);
    }

    /**
     * 根据uno查询用户详情
     * @param uno
     * @return
     */
    @GetMapping("detail/{uno}")
    public R getDetailById(@PathVariable(value = "uno") Integer uno){
        User user = userService.getDetailByUno(uno);
        return R.ok(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping("edit")
    public R updateUser(@Validated(Update.class) @RequestBody User user){
        userService.update(user);
        return R.okMsg(R.UPDATE_SUC);
    }

    /**
     * 删除用户
     * @param uno
     * @return
     */
    @DeleteMapping("delete/{uno}")
    public R deleteSys(@PathVariable(value = "uno") Integer uno) {
        userService.delete(uno);
        return R.okMsg(R.DEL_SUC);
    }
}
