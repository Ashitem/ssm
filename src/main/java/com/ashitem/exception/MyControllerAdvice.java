package com.ashitem.exception;
import com.ashitem.common.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e){
        return new ResponseResult<>(500,e.getMessage());
    }
}
