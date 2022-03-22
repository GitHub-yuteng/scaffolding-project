package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-02-25 10:14:52
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_dictionary")
public class HxhDictionaryEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型
     */
    private String programCode;

    /**
     * 字典名称
     */
    private String programName;

    /**
     * 字典code
     */
    private String dicCode;

    /**
     * 字典值
     */
    private String dicValue;

    private String dicUrl;

    private Integer sort;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * 1:有效 0:无效
     */
    private Integer valid;

    private LocalDateTime operTime;


}
