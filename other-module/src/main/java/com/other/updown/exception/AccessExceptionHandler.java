package com.other.updown.exception;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.other.updown.domain.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author :wuyuhao
 * @version: 2019-2-26
 * @since
 */
@ControllerAdvice
@Slf4j
public class AccessExceptionHandler {
    /**
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ServletRequestBindingException.class)
    public ResponseEntity<Response> handleServletRequestBindingException(ServletRequestBindingException e) throws Exception {
        log.warn("请求参数异常: {}", e.getMessage());

        Response vo = new Response(ErrorCode.INPUT_ERROR.getCode(), "缺少请求参数: " + e.getMessage());
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Response> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e)
            throws Exception {
        log.warn("输入参数异常: {}", e.getName() + "数据类型错误");
        Response vo = new Response(ErrorCode.FIELD_VALIDATE_ERROR.getCode(), e.getName() + "数据类型错误");
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Response> handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
            throws Exception {
        log.warn("输入参数异常: {}", e.getMessage());
        StringBuilder strBuilder = new StringBuilder();
        if (e.getCause() != null && e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) e.getCause();
            for (JsonMappingException.Reference reference : exception.getPath()) {
                strBuilder.append("[").append(reference.getFieldName()).append("数据类型错误] ");
            }
        } else {
            strBuilder.append("缺少Json参数");
        }
        Response vo = new Response(ErrorCode.INPUT_ERROR.getCode(), strBuilder.toString());
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = AccessException.class)
    public ResponseEntity<Response> handleOperationException(AccessException e) {
        log.error("业务处理失败: {}", e.getMessage());

        Response vo = new Response(e.getCode(), e.getMessage());

        if (e.getCode() == ErrorCode.UNKNOWN_ERROR.getCode()) {
            return new ResponseEntity<>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * controller方法参数验证失败全局处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Response> handleMethodValidateFailException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append("[").append(violation.getMessage()).append("] ");
        }
        Response vo = new Response(ErrorCode.INPUT_ERROR.getCode(), strBuilder.toString());
        log.warn("输入参数异常: {}", vo.getResponseStatusObject().getStatusString());
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * controller方法参数验证失败全局处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            sb.append("[").append(error.getDefaultMessage()).append("] ");
        }
        Response vo = new Response(ErrorCode.INPUT_ERROR.getCode(), sb.toString());
        log.warn("输入参数异常: {}", vo.getResponseStatusObject().getStatusString());
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public ResponseEntity<Response> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error("文件大小超过上传限制: {}", e);
        Response vo = new Response(ErrorCode.FILE_SIZE_ERROR.getCode(),
                ErrorCode.FILE_SIZE_ERROR.getMessage() + e.getMessage());
        return new ResponseEntity<>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Response> handleUnknowExcpetion(RuntimeException e) {
        log.error("系统异常: {}", e);
        Response vo = new Response(ErrorCode.UNKNOWN_ERROR.getCode(),
                ErrorCode.UNKNOWN_ERROR.getMessage() + e.getMessage());
        return new ResponseEntity<>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Response> handleBindException(BindException e) {
        log.error("spring校验异常: {}", e);
        Response vo = new Response(ErrorCode.FIELD_VALIDATE_ERROR.getCode(),
                ErrorCode.FIELD_VALIDATE_ERROR.getMessage() + e.getMessage());
        return new ResponseEntity<>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<Response> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("数据插入异常,detail={}",e);
        Response vo = new Response(ErrorCode.DUPLICATEKEY_ERROR.getCode(),
                ErrorCode.DUPLICATEKEY_ERROR.getMessage() + e.getCause());
        return new ResponseEntity<>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
