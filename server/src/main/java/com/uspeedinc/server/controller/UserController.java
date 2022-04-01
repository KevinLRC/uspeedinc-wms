package com.uspeedinc.server.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.uspeedinc.server.common.Result;
import com.uspeedinc.server.entity.User;
import com.uspeedinc.server.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kevinliu
 * @date 3/31/22 9:01 PM
 * @since v1.0.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper mapper;

    @PostMapping
    public Result<?> login111(@RequestBody User user) {

        Wrapper<User> userWrap = Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword());
        User userResult = mapper.selectOne(userWrap);
        if (userResult == null) {
            return Result.error("1", "用户名或密码错误");
        }
        return Result.success();
    }
}
