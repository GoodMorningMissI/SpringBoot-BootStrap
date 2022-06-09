package com.example.labtest.helper;

import lombok.Data;



@Data
public class R<T> {

    /*
    错误代码
     */
    private Integer code;
    /*
    提示信息
     */
    private String msg;
    /*
    具体的内容
     */
    private T data;

}
