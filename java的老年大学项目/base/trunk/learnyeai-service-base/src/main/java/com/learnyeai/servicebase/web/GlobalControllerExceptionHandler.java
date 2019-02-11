package com.learnyeai.servicebase.web;

import com.learnyeai.core.support.ApiResult;
import com.learnyeai.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

/**
 * Created by zpz on 2018/4/16.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult constraintViolationException(HttpServletRequest req, HttpServletResponse res, ConstraintViolationException ex) {
        logger.error(ex.getMessage(), ex);
        res.setStatus(HttpStatus.OK.value());
        ApiResult result = new ApiResult("500", ex.getMessage());
        return result;
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult IllegalArgumentException(HttpServletRequest req, HttpServletResponse res, IllegalArgumentException ex) {
        logger.error(ex.getMessage(), ex);
        res.setStatus(HttpStatus.OK.value());
        ApiResult result = new ApiResult("500", ex.getMessage());
        return result;
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult noHandlerFoundException(HttpServletRequest req, HttpServletResponse res, Exception ex) {
        logger.error(ex.getMessage(), ex);
        res.setStatus(HttpStatus.OK.value());
        return new ApiResult("404", ex.getMessage());
    }

    @ExceptionHandler
    public ApiResult otherException(HttpServletRequest req, HttpServletResponse res, Exception e) {
        logger.error(e.getMessage(), e);
        if(HttpStatus.INTERNAL_SERVER_ERROR.value() == res.getStatus()){
            res.setStatus(HttpStatus.OK.value());
            return new ApiResult("500", e.getMessage());
        }
        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof NullPointerException) {
            return ApiResult.fail("发生空指针异常");
        } else if (e instanceof SQLException) {
            return ApiResult.fail("数据库访问异常");
        }else if(e instanceof BusinessException){
            BusinessException be = (BusinessException)e;
            return new ApiResult(be.getMessageCode(),be.getMessage(), be.getData());
        }

        return ApiResult.fail("服务器代码发生异常,请联系管理员。" + e.getMessage());
    }


}
