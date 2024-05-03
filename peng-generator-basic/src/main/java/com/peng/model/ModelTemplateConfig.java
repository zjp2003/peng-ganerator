package com.peng.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class ModelTemplateConfig {

    private String author = "peng";

    private String outputText = "输出：";
    /**
     * 是否循环
     */
    private boolean loop = false;
}
