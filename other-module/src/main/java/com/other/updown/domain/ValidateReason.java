package com.other.updown.domain;

import lombok.Data;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangbingquan
 * @version 2019年09月22日
 * @since 2019年09月22日
 **/
@Data
public class ValidateReason {
    @NotNull(message = "reason信息不可以为空")
    @Pattern(regexp = "[1-7]{1}", message = "reason的类型值为1-7中的一个类型")
    private String reason;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void validateParams() {
        //调用JSR303验证工具，校验参数
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ValidateReason>> violations = validator.validate(this);
        Iterator<ConstraintViolation<ValidateReason>> iter = violations.iterator();
        if (iter.hasNext()) {
            //因为这里要取出校验失败的对象，所以需要取出这个ConstraintVolition（冲突校验对象）
            ConstraintViolation<ValidateReason> constraintViolation= iter.next();
            String errMessage = constraintViolation.getMessage();
            ValidateReason rootBean = constraintViolation.getRootBean();
            System.out.println(rootBean.toString());
            Class<ValidateReason> rootBeanClass = constraintViolation.getRootBeanClass();
            System.out.println(rootBeanClass.toString());
            throw new ValidationException(errMessage);
        }
    }

    public static void main(String[] args) {
        ValidateReason validateTestClass = new ValidateReason();
        validateTestClass .setReason("数据浴擦");
        validateTestClass .validateParams(); //调用验证的方法
    }
}
