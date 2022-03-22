package com.scaffolding.pojo.bean;

import lombok.Data;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 4:17 下午
 */
@Data
public class EnumStatusBean {

    public String type;
    public String typeName;

    public EnumStatusBean() {
    }

    public EnumStatusBean(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
