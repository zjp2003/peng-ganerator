package com.peng.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成器
 */
public class StaticFileGenerator {


    /**
     * 拷贝模板文件
     * @param inputPath 输入目标文件地址
     * @param outputPath 输出结果文件路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }


}
