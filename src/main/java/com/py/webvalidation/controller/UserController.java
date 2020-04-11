package com.py.webvalidation.controller;

import com.py.webvalidation.bo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author 彭有
 * @date 2020/4/11
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    /**
     * 127.0.0.1:8080/user/test1
     *
     * @param user
     * @return
     */
    @PostMapping("/test1")
    public String test1(@Valid @RequestBody User user) {
        System.out.println(user);
        return user.toString();
    }

    /**
     * 请求：127.0.0.1:8080/user/test2
     * 抛异常
     * <p>
     * 请求：127.0.0.1:8080/user/test2?name=
     * 正常
     *
     * @param name
     * @return
     */
    @GetMapping("/test2")
    public String test2(@NotNull(message = "name不能为空") String name) {
        System.out.println(name);
        return name + "=============";
    }
}
