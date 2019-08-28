package com.design.pattern.builder.middleProduct;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangbingquan
 * @desc 制作糕点的奶油对象
 * @time 2019/7/28 22:00
 */
@Data
@AllArgsConstructor
public class PastryCream {
    /**制作奶油使用的奶源*/
    private String milk;

    /**制作奶油需要的糖*/
    private String sugar;

    /**制作奶油所需要的水*/
    private String water;
}
