package com.py.webvalidation.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 彭有
 * @date 2020/4/11
 */
@Data
@NoArgsConstructor
public class Result<T> {

    private T data;

    private boolean code;

    private Integer type;

    private String message;

    public Result(boolean code, Integer type, String message, T data) {
        this.code = code;
        this.type = type;
        this.message = message;
        this.data = data;
    }

}
