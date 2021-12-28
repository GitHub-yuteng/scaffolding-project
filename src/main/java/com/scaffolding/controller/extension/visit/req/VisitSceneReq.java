package com.scaffolding.controller.extension.visit.req;

import com.scaffolding.pojo.dto.FileUploadDTO;
import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @Date 2021/8/30
 * @Desc
 */
@Data
public class VisitSceneReq {

    /**
     * 图片凭证
     */
    private List<FileUploadDTO> fileList;

}
