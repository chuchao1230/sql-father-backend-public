package com.yupi.sqlfather.controller;

import com.yupi.sqlfather.common.BaseResponse;
import com.yupi.sqlfather.common.ErrorCode;
import com.yupi.sqlfather.common.ResultUtils;
import com.yupi.sqlfather.core.GeneratorFacade;
import com.yupi.sqlfather.core.model.vo.GenerateVO;
import com.yupi.sqlfather.core.schema.TableSchema;
import com.yupi.sqlfather.core.schema.TableSchemaBuilder;
import com.yupi.sqlfather.exception.BusinessException;
import com.yupi.sqlfather.model.dto.GenerateByXmlRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * xml 相关接口
 */
@RestController
@RequestMapping("/xml")
@Slf4j
public class XmlController {

    @PostMapping("/generate/schema")
    public BaseResponse<GenerateVO> generateBySchema(@RequestBody TableSchema tableSchema) {
        return ResultUtils.success(GeneratorFacade.generateAll(tableSchema));
    }

    /**
     * 根据 xml 获取 schema
     *
     * @param xmlRequest
     * @return
     */
    @PostMapping("/get/schema")
    public BaseResponse<TableSchema> getSchemaByXml(@RequestBody GenerateByXmlRequest xmlRequest) {
        if (xmlRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取 tableSchema
        return ResultUtils.success(TableSchemaBuilder.buildFromSql(xmlRequest.getXml()));
    }
}
