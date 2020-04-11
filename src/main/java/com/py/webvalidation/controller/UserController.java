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

    @PostMapping("/test1")
    public String test1(@Valid @RequestBody User user) {
        System.out.println(user);
        return user.toString();
    }

    @GetMapping("/test2")
    public String test2(@NotNull(message = "name不能为空") String name) {
        System.out.println(name);
        return name + "=============";
    }
}
