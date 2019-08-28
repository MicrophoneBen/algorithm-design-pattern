package com.design.pattern.builder.product;

import com.design.pattern.builder.middleProduct.PastryCream;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhangbingquan
 * @desc 糕点对象，面包建造者对象生产出来的对象
 * @time 2019/7/28 21:55
 */
@Data
public class Pastry {
    /**生产日期*/
    private LocalDateTime productinTime;
    /**奶油对象*/
    private PastryCream pastryCream;
    /**制作的糕点名字*/
    private String pastryName;
    /**制作糕点使用的蛋*/
    private String egg;
    /**制作糕点使用的水*/
    private String water;
}
