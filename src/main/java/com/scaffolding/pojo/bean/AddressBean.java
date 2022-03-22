package com.scaffolding.pojo.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author yt
 * @Date 2021/8/30
 * @Desc 省市区
 */
@Data
public class AddressBean implements Serializable {

    /**
     * 省
     */
    public Integer provinceCode;
    @NotBlank(message = "省名称为空")
    public String provinceName;
    /**
     * 市
     */
    public Integer cityCode;
    @NotBlank(message = "市名称为空")
    public String cityName;
    /**
     * 区县
     */
    public Integer countyCode;
    @NotBlank(message = "区县名称为空")
    public String countyName;
    /**
     * 位置
     */
    public String mapPosition;

    public String address;

    public String getAddress() {
        if (StringUtils.isNotBlank(address)) {
            return this.address;
        }
        return Optional.ofNullable(provinceName).orElse("") +
                Optional.ofNullable(cityName).orElse("") +
                Optional.ofNullable(countyName).orElse("") +
                Optional.ofNullable(mapPosition).orElse("");
    }
}
