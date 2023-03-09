package com.th.academy.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 *
 * @author th
 * @date 2023/3/9 16:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {

    //状态码
    private Integer code;

    //异常信息
    private String msg;

    @Override
    public String toString() {
        return "GlobalException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}
