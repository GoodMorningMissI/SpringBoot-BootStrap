package com.example.labtest.aspect;

import com.example.labtest.exception.RException;
import com.example.labtest.helper.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.labtest.helper.RUtil;
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public R handle(Exception e){
        if(e instanceof RException){
            RException rException=(RException) e;
            return RUtil.error(rException.getCode(),rException.getMessage());

        }
        return RUtil.error(-999,e.getMessage());
    }
}
