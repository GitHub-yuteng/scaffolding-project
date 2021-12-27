package com.scaffolding.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YT
 * @Date 2021/8/25
 */
@Data
public class FileUploadDTO implements Serializable {

    private static final long serialVersionUID = 6828306039000121497L;
    /**
     * 图片的key值
     */
    private String fileKey;
    /**
     * 图片的链接地址
     */
    private String imgUrl;
    /**
     * 文件名称
     */
    private String fileName;

}
