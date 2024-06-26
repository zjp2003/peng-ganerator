package com.peng.maker.meta.enums;

/**
 * 文件类型枚举
 */
public enum FileTypeEnum {


    DIR("动态","dir"),
    FILE("静态","file");

    private final String text;
    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
