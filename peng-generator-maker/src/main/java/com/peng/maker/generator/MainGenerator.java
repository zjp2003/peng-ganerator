package com.peng.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.peng.maker.generator.file.DynamicFileGenerator;
import com.peng.maker.meta.Meta;
import com.peng.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        Meta meteObject = MetaManager.getMeteObject();
        System.out.println(meteObject);

        // 输出根路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated";
        // 判断是否存在 不存在则创建
        if (!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }

        // 读取 resources 目录
        ClassPathResource classPathResource = new ClassPathResource("");
        // 输入路径的绝对路径
        String inputResourcePath = classPathResource.getAbsolutePath();

        // java包路径
        String outputBasePackage = meteObject.getBasePackage();
        String outputBasePackagePath =  StrUtil.join("/",StrUtil.split(outputBasePackage,"."));

        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/"+ outputBasePackagePath ;

        String inputFilePath;
        String outputFilePath;

        // model.DataModel
        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/model/DataModel.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.GenerateCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.ConfigCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.ListCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.CommandExecutor
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // Main
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);
    }
}
