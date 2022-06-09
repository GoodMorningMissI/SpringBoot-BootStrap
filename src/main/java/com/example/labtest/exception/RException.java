package com.example.labtest.exception;

import com.example.labtest.helper.REnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RException extends RuntimeException {
    private Integer code;
    public RException(Integer code,String msg){
        super(msg);
        this.code=code;
    }
    public RException(REnum rEnum){
        super(rEnum.getMsg());
        this.code=rEnum.getCode();
    }
}
