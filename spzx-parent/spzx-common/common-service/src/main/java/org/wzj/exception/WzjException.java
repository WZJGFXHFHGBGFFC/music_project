package org.wzj.exception;

import lombok.Data;
import org.wzj.spzx.model.vo.common.ResultCodeEnum;

@Data
public class WzjException extends RuntimeException{
    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public WzjException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.resultCodeEnum = resultCodeEnum;
    }

}
