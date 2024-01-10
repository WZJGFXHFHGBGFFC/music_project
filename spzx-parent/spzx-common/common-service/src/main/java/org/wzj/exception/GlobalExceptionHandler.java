package org.wzj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wzj.spzx.model.vo.common.Result;
import org.wzj.spzx.model.vo.common.ResultCodeEnum;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(){
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(WzjException.class)
    @ResponseBody
    public Result error(WzjException wzjException){
        return Result.build(null,wzjException.getResultCodeEnum());
    }
}
