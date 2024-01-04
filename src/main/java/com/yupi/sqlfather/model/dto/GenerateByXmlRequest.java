package com.yupi.sqlfather.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据 xml 生成请求体
 *
 *
 */
@Data
public class GenerateByXmlRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String xml;
}
