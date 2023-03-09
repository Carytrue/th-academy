package com.th.academy.common.handler;

import com.th.academy.common.exception.GlobalException;
import com.th.academy.common.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author th
 * @date 2023/3/9 16:24
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //自定义异常
    @ExceptionHandler(GlobalException.class)
    public ResponseResult error(GlobalException e) {
        log.error(e.getMsg());
        e.printStackTrace();
        return ResponseResult.error().code(e.getCode()).message(e.getMsg());
    }

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    public ResponseResult error(Exception e) {
        e.printStackTrace();
        return ResponseResult.error().message("执行了全局异常处理..");
    }
}

