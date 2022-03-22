package com.scaffolding.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 10:20 上午
 */
@Data
@EqualsAndHashCode
public class StoreVO implements Serializable {

    private Long id;
    private String storeName;
}
