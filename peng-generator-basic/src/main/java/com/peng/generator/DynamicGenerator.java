package com.peng.generator;

import com.peng.model.ModelTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir") + File.separator + "peng-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        ModelTemplateConfig data = new ModelTemplateConfig();

        data.setAuthor("peng");
        data.setLoop(true);
        data.setOutputText("输出结果: ");
        doGenerate(inputPath, outputPath, data);
    }

    /**
     * 动态生成模板
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     */
    public static void doGenerate(String inputPath, String outputPath,Object model) throws IOException, TemplateException {
        // new 出 configuration 对象,参数为 FreeMarker 版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        // 获取指定文件的父目录
        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        cfg.setDefaultEncoding("UTF-8");
        // 指定数字格式
        cfg.setNumberFormat("0.######");
        // 创建模板对象,加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);

        // 调用在根目录下生成此文件
        Writer out = new FileWriter(outputPath);
        // 数据和模板传入代替值
        template.process(model,out);
        // 关闭
        out.close();
    }
}
