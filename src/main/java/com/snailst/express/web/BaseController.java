package com.snailst.express.web;

import com.snailst.express.entity.Res;
import com.snailst.express.enums.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 */
public class BaseController {

    /**
     * 成功
     * @return
     */
    public ResponseEntity<Res> SUCCESS(Object o){
        return new ResponseEntity<>(new Res(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMessage(), o), HttpStatus.OK);
    }

    /**
     * 成功
     * @param res
     * @return
     */
    public ResponseEntity<Res> SUCCESS(Res res){
        res.setCode(ResultEnum.SUCCESS.getCode());
        res.setMessage(ResultEnum.SUCCESS.getMessage());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * 失败
     * @return
     */
    public ResponseEntity<Res> FAILED(){
        return new ResponseEntity<>(new Res(ResultEnum.SYSTEM_ERROR.getCode(),
                ResultEnum.SYSTEM_ERROR.getMessage()), HttpStatus.OK);
    }

    /**
     * 重载 失败
     * @param code
     * @param message
     * @return
     */
    public ResponseEntity<Res> FAILED(String code, String message){
        return new ResponseEntity<>(new Res(code, message), HttpStatus.OK);
    }
}
