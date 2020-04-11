package com.py.webvalidation.bo;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author 彭有
 * @date 2020/4/11
 */
@Data
public class User {

    private String id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @Min(value = 10, message = "年龄必须大于10")
    private Integer age;

    @Email(message = "邮箱格式不对")
    private String email;

    /**
     * 还可以支持正则方式
     */
    @Pattern(regexp = "")
    private String event;
}
