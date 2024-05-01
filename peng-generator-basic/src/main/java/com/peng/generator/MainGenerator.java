package com.peng.generator;

import com.peng.model.ModelTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 静态文件生成
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "peng-genertor-demo-projects"+ File.separator + "acm-template";
        String outputPath = projectPath;

        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        // 动态文件生成
        String dynamicInputPath = projectPath + File.separator + "peng-generator-basic" + File.separator +"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/peng/acm/MainTemplate.java";

        ModelTemplateConfig data = new ModelTemplateConfig();

        data.setAuthor("peng");
        data.setLoop(false);
        data.setOutputText("输出结果: ");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, data);
    }
}
